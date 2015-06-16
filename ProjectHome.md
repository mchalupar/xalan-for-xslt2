> # GSoC 2011 Project - Implement XSLT 2 for Xalan #


Apache Xalan-Java is a powful XSLT processor for XML transforming based on W3C recommendation XSL Transformations (XSLT) Version 1.0 and XML Path Language (XPath) Version 1.0, XSL Transformations (XSLT) Version 2.0 specification was published on 23 January 2007,this new version give us more powful functions, new dat model and serialization etc.


In my daily work, i use XSLT and XPath to parse XML and change XML document to another format, i did this with Xalan.As we know,Xalan support XSLT version 1.0 and XPath version 1.0 only.But my XML parse job is so complex, and usually, i must use some XPath v2.0 functions to finish my parse job. So, i encountered trouble.


Then I Google keywords with Xalan and XSLT 2.0,i found many developers hope that Xalan based XSLT 2.0 could become reality besides me. At the same time, i discuss this topic with open source developers in mail list, so many guys are interested in implementing complete XSTL 2.0 specification for Xalan. We discuss this project deeply, and i got many good ideas and advises from the discussion. And also they told me Xalan lost its most active contributors a few years ago due to time demands from Real Jobs, and development slowed down as a result,but they love to see Xalan tackle it.Due to XSLT 2.0 and XPath 2.0 are large specifications that I imagine could take the developers years to implement correctly,anyway it need some guy get the ball rolling, i want to be this guy.


Compared with XSLT 1.0, XSLT 2.0 and XPath 2.0 have some important new characteristic.


New features in XPath 2.0:

  1. Sequences, in XPath2.0 everything is sequences
> 2. For _expression_,in XPath 2.0,we can use for _expression_ to iterator every item in the sequence, compute _expression_ value for each item, at last return the sequence result by connect all the _expression_ values.
> 3. Condition _expression_, XPath 2.0's condition _expression_ can be used to compute different value on the basis of the condition's true or false value.
> 4. Limited _expression_,limited _expression_ in XPath 2.0 can be used to judge that whether every item in the sequence satisfy appointed condition, its value is always true of false. There are two kinds of limited _expression_: some _expression_ and every _expression_.
> 5. Datatype,XPath 2.0's datetype is based on XML Schema, it supports all the basic built-in datatype,such as xs:integer,xs:string and xs:date ect.
> 6. Date and time, XSLT 1.0 has not date and time datatype, it must use string to represent date and time. Due to XPath 2.0 system is based on XML schema, so there is date and time data type in XPath 2.0.
> 7. More functions support,XSLT 2.0 specification has more powful functions definition.Functions in XPath 2.0 is defined in a special recommedation "XQuery 1.0 and XPath 2.0 Functions and Operations", functions in this recommendation specification belong to namespace "http://www.w3.org/2005/xpath-functions", this namespace is bound with prefix "fn".

> It includes these serveral types:

  * Constructor Functions
  * Functions and Operators on Numerics
  * Functions on Strings
  * Functions on anyURI
  * Functions and Operators on Boolean Values
  * Functions and Operators on Durations, Dates and Times
  * Functions Related to QNames
  * Operators on base64Binary and hexBinary
  * Operators on NOTATION
  * Functions and Operators on Nodes
  * Functions and Operators on Sequences
  * Context Functions

There are also many new features in XSLT 2.0:

  1. Group, basic group syntax,group sort,group-adjacent and group-starting-with etc.
> 2. Connotive document node, or we can call it temporary tree
> 3. Element result-document, we can use to generate multi output file in XPath 2.0
> 4. Improvement of element value-of
> 5. Char mapping,XSLT 2.0 supply more flexible solution for us to handler specific characters in XML such as '<' and '&'
> 6. Custom stylesheet function,in XSLT 2.0, we can use to create our own functions in stylesheet
> 7. Other new features.

In order to implement all the XSLT 2.0 specification,it requires some moderately basic data structure changes to track Schema types and to handle Sequences which aren't simply nodesets,and also,i must implements all the new functions defined in XSLT 2.0,fortunately,there is a open source XPath 2.0 processor (http://wiki.eclipse.org/PsychoPathXPathProcessor) which is at Eclipse.It is already being used by Xerces-J for XSD 1.1 Assertion support.Why re-invent the wheel if we can leverage something that already exists ? PsychoPath already is XML Schema Aware, leverages Xerces-J(http://xerces.apache.org/xerces2-j) and passes about 99.9% of the Xpath 2.0 test suite. It is currently undergoing testing against the the official W3C Test Suite.



So, in order to implement all the XSLT 2.0 specification for Xalan, there are two steps:

1. Merge Xalan codes with PsychoPath codes,this will help us a lot,once this job is done, Xalan has implemented all the XPath 2.0 features. There are some issues to resolve during this merging process,for example:
  * PsychoPath is not "streamy" yet, nor is Xalan, it is a big challenge
  * In PsychoPath,type informations is not part of current interfaces,i will have to extend or replace the DTM interfaces to carry the additional data
  * XSLTC fit in problem. XSLTC runs against the same data model interfaces (DTM), and In Theory implementing compilation should just be a matter of generating code equivalent to what the interpreter is doing. In practice, it's a lot of detail work.

2. Implement all the other XSLT 2.0 features which were described before for Xalan.

In my plan, i will hold the whole XSLT 2.0 implemention project as a long term open source project under Apache, do it step by step, may be as a GSoC project,i can only implement a subset of this capability i was thinking of working on,at lease, i will finish the following tasks:

  1. Merge Xalan codes with PsychoPath codes, i will do this first, but this is not a simple task,may be it will cost me one month or even more to merge it correctly.
> 2. Resolve merge problems between Xalan and PsychoPath
> 3. Implement XSLT 2.0 Group feature for Xalan
> 4. Implement XSLT 2.0 temporary tree feature for Xalan
> 5. Implement Element result-document feature for Xalan