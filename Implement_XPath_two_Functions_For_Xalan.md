# Introduction #

This project implement [XPath 2.0 functions](http://www.w3.org/TR/xpath-functions/) for Xalan already. XSLT 2.0 supply much more functions than 1.0 version and it is more powful.


# Test Case #

## Sample XML Document ##

Suppose we have the following XML document:

```
 <?xml version="1.0"?> 
 <doc> 
  <name first="David" last="Marston">David Marston</name> 
  <name first="David" last="Bertoni">David Bertoni</name> 
  <name first="Donald" last="Leslie">Donald Leslie</name> 
  <name first="Emily" last="Farmer">Emily Farmer</name> 
  <name first="Joseph" last="Kesselman">Joseph Kesselman</name> 
  <name first="Myriam" last="Midy">Myriam Midy</name> 
  <name first="Paul" last="Dick">Paul Dick</name> 
  <name first="Stephen" last="Auriemma">Stephen Auriemma</name> 
  <name first="Scott" last="Boag">Scott Boag</name> 
  <name first="Shane" last="Curcuru">Shane Curcuru</name> 
 </doc> 
```

## Sample Code ##

And we want to parse the document using Xalan, suppose we want to get all the guys who's first name starts with D, so we have the following test case :

```
public class ApplyXPath 
 { 
  protected String filename = null; 
  protected String xpath = null; 

  /** Process input args and execute the XPath. */ 
  public void doMain(String[] args) throws Exception 
  { 
  filename = args[0]; 
  xpath = args[1]; 

  if ((filename != null) && (filename.length() > 0) 
  && (xpath != null) && (xpath.length() > 0)) 
  { 
  // Tell that we're loading classes and parsing, so the time it 
  // takes to do this doesn't get confused with the time to do 
  // the actual query and serialization. 
  System.out.println("Loading classes, parsing "
  +filename+", and setting up serializer"); 
  
 // Set up a DOM tree to query. 
  InputSource in = new InputSource(new FileInputStream(filename)); 
  DocumentBuilderFactory dfactory = DocumentBuilderFactory.newInstance(); 
  dfactory.setNamespaceAware(true); 
  Document doc = dfactory.newDocumentBuilder().parse(in); 
  
 // Set up an identity transformer to use as serializer. 
  Transformer serializer = TransformerFactory.newInstance().newTransformer(); 
  serializer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes"); 

  // Use the simple XPath API to select a nodeIterator. 
  System.out.println("Querying DOM using "+xpath); 
  NodeIterator nl = XPathAPI.selectNodeIterator(doc, xpath); 

  // Serialize the found nodes to System.out. 
 System.out.println("<output>"); 
  
  Node n; 
  while ((n = nl.nextNode())!= null) 
  { 
	if (isTextNode(n)) { 
  // DOM may have more than one node corresponding to a 
  // single XPath text node. Coalesce all contiguous text nodes 
  // at this level 
  StringBuffer sb = new StringBuffer(n.getNodeValue()); 
  for ( 
  Node nn = n.getNextSibling(); 
  isTextNode(nn); 
  nn = nn.getNextSibling() 
  ) { 
  sb.append(nn.getNodeValue()); 
  } 
  System.out.print(sb); 
  } 
  else { 
  serializer.transform(new DOMSource(n), 
  new StreamResult(new OutputStreamWriter(System.out))); 
  
  } 
  System.out.println(); 
  } 
  System.out.println("</output>"); 
  } 
  else 
  { 
  System.out.println("Bad input args: " + filename + ", " + xpath); 
  } 
  } 
  
  /** Decide if the node is text, and so must be handled specially */ 
  static boolean isTextNode(Node n) { 
  if (n == null) 
  return false; 
  short nodeType = n.getNodeType(); 
  return nodeType == Node.CDATA_SECTION_NODE || nodeType == Node.TEXT_NODE; 
  } 

  /** Main method to run from the command line. */ 
  public static void main (String[] args) 
  throws Exception 
  { 
  ApplyXPath app = new ApplyXPath(); 
  app.doMain(new String[]{"foo.xml","/doc/name[starts-with(@first,'D')]"}); 
  } 
				 
 }
```

## Sample Result ##

It works like this:

```

Loading classes, parsing foo.xml, and setting up serializer 
 Querying DOM using /doc/name[starts-with(@first,'D')] 
 <output> 
 <name first="David" last="Marston">David Marston</name> 
 <name first="David" last="Bertoni">David Bertoni</name> 
 <name first="Donald" last="Leslie">Donald Leslie</name> 
 </output> 
```

It works well, Xalan supply starts-with function for us in XSLT 1.0 specification, but if we want to find the guys who's first name ends with d, how can we do this?

## The Problem ##

If the change
```
app.doMain(new String[]{"foo.xml","/doc/name[starts-with(@first,'D')]"}); 
```
to
```
app.doMain(new String[]{"foo.xml","/doc/name[ends-with(@first,'D')]"}); 
```

We will catch this exception:

```
 Loading classes, parsing foo.xml, and setting up serializer 
 Querying DOM using /doc/name[ends-with(@first,'D')] 
 Exception in thread "main" javax.xml.transform.TransformerException: 找不到函数：ends-with 
  at org.apache.xpath.compiler.XPathParser.error(XPathParser.java:610) 
  at org.apache.xpath.compiler.XPathParser.FunctionCall(XPathParser.java:1507) 
  at org.apache.xpath.compiler.XPathParser.PrimaryExpr(XPathParser.java:1446) 
  at org.apache.xpath.compiler.XPathParser.FilterExpr(XPathParser.java:1345) 
  at org.apache.xpath.compiler.XPathParser.PathExpr(XPathParser.java:1278) 
  at org.apache.xpath.compiler.XPathParser.UnionExpr(XPathParser.java:1236) 
  at org.apache.xpath.compiler.XPathParser.UnaryExpr(XPathParser.java:1142) 
  at org.apache.xpath.compiler.XPathParser.MultiplicativeExpr(XPathParser.java:1063) 
  at org.apache.xpath.compiler.XPathParser.AdditiveExpr(XPathParser.java:1005) 
  at org.apache.xpath.compiler.XPathParser.RelationalExpr(XPathParser.java:930) 
  at org.apache.xpath.compiler.XPathParser.EqualityExpr(XPathParser.java:870) 
  at org.apache.xpath.compiler.XPathParser.AndExpr(XPathParser.java:834) 
  at org.apache.xpath.compiler.XPathParser.OrExpr(XPathParser.java:807) 
  at org.apache.xpath.compiler.XPathParser.Expr(XPathParser.java:790) 
  at org.apache.xpath.compiler.XPathParser.PredicateExpr(XPathParser.java:1954) 
  at org.apache.xpath.compiler.XPathParser.Predicate(XPathParser.java:1936) 
  at org.apache.xpath.compiler.XPathParser.Step(XPathParser.java:1726) 
  at org.apache.xpath.compiler.XPathParser.RelativeLocationPath(XPathParser.java:1635) 
  at org.apache.xpath.compiler.XPathParser.LocationPath(XPathParser.java:1597) 
  at org.apache.xpath.compiler.XPathParser.PathExpr(XPathParser.java:1317) 
  at org.apache.xpath.compiler.XPathParser.UnionExpr(XPathParser.java:1236) 
  at org.apache.xpath.compiler.XPathParser.UnaryExpr(XPathParser.java:1142) 
  at org.apache.xpath.compiler.XPathParser.MultiplicativeExpr(XPathParser.java:1063) 
  at org.apache.xpath.compiler.XPathParser.AdditiveExpr(XPathParser.java:1005) 
  at org.apache.xpath.compiler.XPathParser.RelationalExpr(XPathParser.java:930) 
  at org.apache.xpath.compiler.XPathParser.EqualityExpr(XPathParser.java:870) 
  at org.apache.xpath.compiler.XPathParser.AndExpr(XPathParser.java:834) 
  at org.apache.xpath.compiler.XPathParser.OrExpr(XPathParser.java:807) 
  at org.apache.xpath.compiler.XPathParser.Expr(XPathParser.java:790) 
  at org.apache.xpath.compiler.XPathParser.initXPath(XPathParser.java:129) 
  at org.apache.xpath.XPath.<init>(XPath.java:178) 
  at org.apache.xpath.XPathAPI.eval(XPathAPI.java:236) 
  at org.apache.xpath.XPathAPI.selectNodeIterator(XPathAPI.java:128) 
  at org.apache.xpath.XPathAPI.selectNodeIterator(XPathAPI.java:108) 
  at ApplyXPath.ApplyXPath.doMain(ApplyXPath.java:73) 
  at ApplyXPath.ApplyXPath.main(ApplyXPath.java:123) 

```

Xalan can not find the ' ends-with ' function, XSLT 2.0 includes this function but Xalan is developed under XSLT 1.0 specification. This project has implemented all the XPath 2.0 functions for Xalan .

If you run the sample test case with this project environment, you will get the following output:
```

Loading classes, parsing foo.xml, and setting up serializer
Querying DOM using /doc/name[ends-with(@first,'d')]
<output>
<name first="David" last="Marston">David Marston</name>
<name first="David" last="Bertoni">David Bertoni</name>
<name first="Donald" last="Leslie">Donald Leslie</name>
</output>

```

See, it works well :-)