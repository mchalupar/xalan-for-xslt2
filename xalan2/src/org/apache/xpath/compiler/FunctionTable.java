/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the  "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/*
 * $Id: FunctionTable.java 468655 2006-10-28 07:12:06Z minchau $
 */
package org.apache.xpath.compiler;

import org.apache.xpath.Expression;
import org.apache.xpath.functions.Function;
import java.util.HashMap;
import javax.xml.transform.TransformerException;

/**
 * The function table for XPath.
 */
public class FunctionTable
{

  /** The 'current()' id. */
  public static final int FUNC_CURRENT = 0;

  /** The 'last()' id. */
  public static final int FUNC_LAST = 1;

  /** The 'position()' id. */
  public static final int FUNC_POSITION = 2;

  /** The 'count()' id. */
  public static final int FUNC_COUNT = 3;

  /** The 'id()' id. */
  public static final int FUNC_ID = 4;

  /** The 'key()' id (XSLT). */
  public static final int FUNC_KEY = 5;

  /** The 'local-name()' id. */
  public static final int FUNC_LOCAL_PART = 7;

  /** The 'namespace-uri()' id. */
  public static final int FUNC_NAMESPACE = 8;

  /** The 'name()' id. */
  public static final int FUNC_QNAME = 9;

  /** The 'generate-id()' id. */
  public static final int FUNC_GENERATE_ID = 10;

  /** The 'not()' id. */
  public static final int FUNC_NOT = 11;

  /** The 'true()' id. */
  public static final int FUNC_TRUE = 12;

  /** The 'false()' id. */
  public static final int FUNC_FALSE = 13;

  /** The 'boolean()' id. */
  public static final int FUNC_BOOLEAN = 14;

  /** The 'number()' id. */
  public static final int FUNC_NUMBER = 15;

  /** The 'floor()' id. */
  public static final int FUNC_FLOOR = 16;

  /** The 'ceiling()' id. */
  public static final int FUNC_CEILING = 17;

  /** The 'round()' id. */
  public static final int FUNC_ROUND = 18;

  /** The 'sum()' id. */
  public static final int FUNC_SUM = 19;

  /** The 'string()' id. */
  public static final int FUNC_STRING = 20;

  /** The 'starts-with()' id. */
  public static final int FUNC_STARTS_WITH = 21;

  /** The 'contains()' id. */
  public static final int FUNC_CONTAINS = 22;

  /** The 'substring-before()' id. */
  public static final int FUNC_SUBSTRING_BEFORE = 23;

  /** The 'substring-after()' id. */
  public static final int FUNC_SUBSTRING_AFTER = 24;

  /** The 'normalize-space()' id. */
  public static final int FUNC_NORMALIZE_SPACE = 25;

  /** The 'translate()' id. */
  public static final int FUNC_TRANSLATE = 26;

  /** The 'concat()' id. */
  public static final int FUNC_CONCAT = 27;

  /** The 'substring()' id. */
  public static final int FUNC_SUBSTRING = 29;

  /** The 'string-length()' id. */
  public static final int FUNC_STRING_LENGTH = 30;

  /** The 'system-property()' id. */
  public static final int FUNC_SYSTEM_PROPERTY = 31;

  /** The 'lang()' id. */
  public static final int FUNC_LANG = 32;

  /** The 'function-available()' id (XSLT). */
  public static final int FUNC_EXT_FUNCTION_AVAILABLE = 33;

  /** The 'element-available()' id (XSLT). */
  public static final int FUNC_EXT_ELEM_AVAILABLE = 34;

  /** The 'unparsed-entity-uri()' id (XSLT). */
  public static final int FUNC_UNPARSED_ENTITY_URI = 36;

  // Proprietary

  /** The 'document-location()' id (Proprietary). */
  public static final int FUNC_DOCLOCATION = 35;
  /** XSLT 2.0 Functions and Operators on String */
  public static final int FUNC_ENDS_WITH = 37;
  public static final int FUNC_UPPER_CASE = 38;
  public static final int FUNC_LOWER_CASE = 39;
  public static final int FUNC_STRING_JOIN = 40;
  public static final int FUNC_STRING_MATCHES = 41;
  public static final int FUNC_STRING_REPLACE = 42;
  public static final int FUNC_STRING_TOKENIZE = 43;
  public static final int FUNC_STRING_NORMALIZE_UNICODE = 44;
  public static final int FUNC_STRING_ENCODE_FOR_URI = 45;
  public static final int FUNC_STRING_IRI_TO_URI = 46;
  public static final int FUNC_STRING_ESCAPE_HTML_URI = 47;
  /** XSLT 2.0 Functions and Operators on Numerics */
  public static final int FUNC_NUMBER_ADD= 48;
  public static final int FUNC_NUMBER_SUBTRACT= 49;
  public static final int FUNC_NUMBER_MULTIPLY= 50;
  public static final int FUNC_NUMBER_DIVIDE= 51;
  public static final int FUNC_NUMBER_INTEGER_DIVIDE= 52;
  public static final int FUNC_NUMBER_MOD= 53;
  public static final int FUNC_NUMBER_UNARY_PLUS= 54;
  public static final int FUNC_NUMBER_UNARY_MINUS= 55;
  public static final int FUNC_NUMBER_EQUAL= 56;
  public static final int FUNC_NUMBER_LESS_THAN= 57;
  public static final int FUNC_NUMBER_GREATER_THAN= 58;
  public static final int FUNC_NUMBER_ABS = 59;
  public static final int FUNC_NUMBER_ROUND_HALF_TO_EVEN = 60;
  /** XSLT 2.0 Functions and Operators on Boolean */
  public static final int FUNC_BOOLEAN_EQUAL = 61;
  public static final int FUNC_BOOLEAN_LESS_THAN = 62;
  public static final int FUNC_BOOLEAN_GREATER_THAN = 63;

  /**
   * The function table.
   */
  private static Class m_functions[];

  /** Table of function name to function ID associations. */
  private static HashMap m_functionID = new HashMap();
    
  /**
   * The function table contains customized functions
   */
  private Class m_functions_customer[] = new Class[NUM_ALLOWABLE_ADDINS];

  /**
   * Table of function name to function ID associations for customized functions
   */
  private HashMap m_functionID_customer = new HashMap();
  
  /**
   * Number of built in functions.  Be sure to update this as
   * built-in functions are added.
   */
  private static final int NUM_BUILT_IN_FUNCS = 64;

  /**
   * Number of built-in functions that may be added.
   */
  private static final int NUM_ALLOWABLE_ADDINS = 30;

  /**
   * The index to the next free function index.
   */
  private int m_funcNextFreeIndex = NUM_BUILT_IN_FUNCS;
  
  static
  {
    m_functions = new Class[NUM_BUILT_IN_FUNCS];
    m_functions[FUNC_CURRENT] = org.apache.xpath.functions.FuncCurrent.class;
    m_functions[FUNC_LAST] = org.apache.xpath.functions.FuncLast.class;
    m_functions[FUNC_POSITION] = org.apache.xpath.functions.FuncPosition.class;
    m_functions[FUNC_COUNT] = org.apache.xpath.functions.FuncCount.class;
    m_functions[FUNC_ID] = org.apache.xpath.functions.FuncId.class;
    m_functions[FUNC_KEY] =
      org.apache.xalan.templates.FuncKey.class;
    m_functions[FUNC_LOCAL_PART] = 
      org.apache.xpath.functions.FuncLocalPart.class;
    m_functions[FUNC_NAMESPACE] = 
      org.apache.xpath.functions.FuncNamespace.class;
    m_functions[FUNC_QNAME] = org.apache.xpath.functions.FuncQname.class;
    m_functions[FUNC_GENERATE_ID] = 
      org.apache.xpath.functions.FuncGenerateId.class;
    m_functions[FUNC_NOT] = org.apache.xpath.functions.Boolean.FuncNot.class;
    m_functions[FUNC_TRUE] = org.apache.xpath.functions.Boolean.FuncTrue.class;
    m_functions[FUNC_FALSE] = org.apache.xpath.functions.Boolean.FuncFalse.class;
    m_functions[FUNC_BOOLEAN] = org.apache.xpath.functions.Boolean.FuncBoolean.class;
    m_functions[FUNC_LANG] = org.apache.xpath.functions.FuncLang.class;
    m_functions[FUNC_NUMBER] = org.apache.xpath.functions.Number.FuncNumber.class;
    m_functions[FUNC_FLOOR] = org.apache.xpath.functions.Number.FuncFloor.class;
    m_functions[FUNC_CEILING] = org.apache.xpath.functions.Number.FuncCeiling.class;
    m_functions[FUNC_ROUND] = org.apache.xpath.functions.Number.FuncRound.class;
    m_functions[FUNC_SUM] = org.apache.xpath.functions.Number.FuncSum.class;
    m_functions[FUNC_STRING] = org.apache.xpath.functions.String.FuncString.class;
    m_functions[FUNC_STARTS_WITH] = 
      org.apache.xpath.functions.String.FuncStartsWith.class;
    m_functions[FUNC_CONTAINS] = org.apache.xpath.functions.String.FuncContains.class;
    m_functions[FUNC_SUBSTRING_BEFORE] = 
      org.apache.xpath.functions.String.FuncSubstringBefore.class;
    m_functions[FUNC_SUBSTRING_AFTER] = 
      org.apache.xpath.functions.String.FuncSubstringAfter.class;
    m_functions[FUNC_NORMALIZE_SPACE] = 
      org.apache.xpath.functions.FuncNormalizeSpace.class;
    m_functions[FUNC_TRANSLATE] = 
      org.apache.xpath.functions.FuncTranslate.class;
    m_functions[FUNC_CONCAT] = org.apache.xpath.functions.String.FuncConcat.class;
    m_functions[FUNC_SYSTEM_PROPERTY] = 
      org.apache.xpath.functions.FuncSystemProperty.class;
    m_functions[FUNC_EXT_FUNCTION_AVAILABLE] =
      org.apache.xpath.functions.FuncExtFunctionAvailable.class;
    m_functions[FUNC_EXT_ELEM_AVAILABLE] =
      org.apache.xpath.functions.FuncExtElementAvailable.class;
    m_functions[FUNC_SUBSTRING] = 
      org.apache.xpath.functions.String.FuncSubstring.class;
    m_functions[FUNC_STRING_LENGTH] = 
      org.apache.xpath.functions.String.FuncStringLength.class;
    m_functions[FUNC_DOCLOCATION] = 
      org.apache.xpath.functions.FuncDoclocation.class;
    m_functions[FUNC_UNPARSED_ENTITY_URI] =
      org.apache.xpath.functions.FuncUnparsedEntityURI.class;
    m_functions[FUNC_ENDS_WITH] = 
        org.apache.xpath.functions.String.FuncEndsWith.class;
    m_functions[FUNC_UPPER_CASE] = 
        org.apache.xpath.functions.String.FuncUpperCase.class;
    m_functions[FUNC_LOWER_CASE] = 
        org.apache.xpath.functions.String.FuncLowerCase.class;
    m_functions[FUNC_STRING_JOIN] = 
        org.apache.xpath.functions.String.FuncStringJoin.class;
    m_functions[FUNC_STRING_MATCHES] = org.apache.xpath.functions.String.FuncStringMatches.class;
    m_functions[FUNC_STRING_REPLACE] = org.apache.xpath.functions.String.FuncStringReplace.class;
    m_functions[FUNC_STRING_TOKENIZE] = org.apache.xpath.functions.String.FuncStringTokenize.class;
    m_functions[FUNC_STRING_NORMALIZE_UNICODE] = org.apache.xpath.functions.String.FuncStringNormalizeUnicode.class;
    m_functions[FUNC_STRING_ENCODE_FOR_URI] = org.apache.xpath.functions.String.FuncStringEncodeForURI.class;
    m_functions[FUNC_STRING_IRI_TO_URI] = org.apache.xpath.functions.String.FuncStringIriToUri.class;
    m_functions[FUNC_STRING_ESCAPE_HTML_URI] = org.apache.xpath.functions.String.FuncStringEscapeHTMLURI.class;
    
    m_functions[FUNC_NUMBER_ADD] = org.apache.xpath.functions.Number.FuncNumberAdd.class;
    m_functions[FUNC_NUMBER_SUBTRACT] = org.apache.xpath.functions.Number.FuncNumberSubtract.class;
    m_functions[FUNC_NUMBER_MULTIPLY] = org.apache.xpath.functions.Number.FuncNumberMultiply.class;
    m_functions[FUNC_NUMBER_DIVIDE] = org.apache.xpath.functions.Number.FuncNumberDivide.class;
    m_functions[FUNC_NUMBER_INTEGER_DIVIDE] = org.apache.xpath.functions.Number.FuncNumberIntegerDivide.class;
    m_functions[FUNC_NUMBER_MOD] = org.apache.xpath.functions.Number.FuncNumberMod.class;
    m_functions[FUNC_NUMBER_UNARY_PLUS] = org.apache.xpath.functions.Number.FuncNumberUnaryPlus.class;
    m_functions[FUNC_NUMBER_UNARY_MINUS] = org.apache.xpath.functions.Number.FuncNumberUnaryMinus.class;
    m_functions[FUNC_NUMBER_EQUAL] = org.apache.xpath.functions.Number.FuncNumberEqual.class;
    m_functions[FUNC_NUMBER_LESS_THAN] = org.apache.xpath.functions.Number.FuncNumberLessThan.class;
    m_functions[FUNC_NUMBER_GREATER_THAN] = org.apache.xpath.functions.Number.FuncNumberGreaterThan.class;
    m_functions[FUNC_NUMBER_ABS] = org.apache.xpath.functions.Number.FuncNumberABS.class;
    m_functions[FUNC_NUMBER_ROUND_HALF_TO_EVEN] = org.apache.xpath.functions.Number.FuncNumberRoundHalfToEven.class;
    
    m_functions[FUNC_BOOLEAN_EQUAL] = org.apache.xpath.functions.Boolean.FuncBooleanEqual.class;
    m_functions[FUNC_BOOLEAN_LESS_THAN] = org.apache.xpath.functions.Boolean.FuncBooleanLessThan.class;
    m_functions[FUNC_BOOLEAN_GREATER_THAN] = org.apache.xpath.functions.Boolean.FuncBooleanGreaterThan.class;
  }

  static{
          m_functionID.put(Keywords.FUNC_CURRENT_STRING,
                          new Integer(FunctionTable.FUNC_CURRENT));
          m_functionID.put(Keywords.FUNC_LAST_STRING,
                          new Integer(FunctionTable.FUNC_LAST));
          m_functionID.put(Keywords.FUNC_POSITION_STRING,
                          new Integer(FunctionTable.FUNC_POSITION));
          m_functionID.put(Keywords.FUNC_COUNT_STRING,
                          new Integer(FunctionTable.FUNC_COUNT));
          m_functionID.put(Keywords.FUNC_ID_STRING,
                          new Integer(FunctionTable.FUNC_ID));
          m_functionID.put(Keywords.FUNC_KEY_STRING,
                          new Integer(FunctionTable.FUNC_KEY));
          m_functionID.put(Keywords.FUNC_LOCAL_PART_STRING,
                          new Integer(FunctionTable.FUNC_LOCAL_PART));
          m_functionID.put(Keywords.FUNC_NAMESPACE_STRING,
                          new Integer(FunctionTable.FUNC_NAMESPACE));
          m_functionID.put(Keywords.FUNC_NAME_STRING,
                          new Integer(FunctionTable.FUNC_QNAME));
          m_functionID.put(Keywords.FUNC_GENERATE_ID_STRING,
                          new Integer(FunctionTable.FUNC_GENERATE_ID));
          m_functionID.put(Keywords.FUNC_NOT_STRING,
                          new Integer(FunctionTable.FUNC_NOT));
          m_functionID.put(Keywords.FUNC_TRUE_STRING,
                          new Integer(FunctionTable.FUNC_TRUE));
          m_functionID.put(Keywords.FUNC_FALSE_STRING,
                          new Integer(FunctionTable.FUNC_FALSE));
          m_functionID.put(Keywords.FUNC_BOOLEAN_STRING,
                          new Integer(FunctionTable.FUNC_BOOLEAN));
          m_functionID.put(Keywords.FUNC_LANG_STRING,
                          new Integer(FunctionTable.FUNC_LANG));
          m_functionID.put(Keywords.FUNC_NUMBER_STRING,
                          new Integer(FunctionTable.FUNC_NUMBER));
          m_functionID.put(Keywords.FUNC_FLOOR_STRING,
                          new Integer(FunctionTable.FUNC_FLOOR));
          m_functionID.put(Keywords.FUNC_CEILING_STRING,
                          new Integer(FunctionTable.FUNC_CEILING));
          m_functionID.put(Keywords.FUNC_ROUND_STRING,
                          new Integer(FunctionTable.FUNC_ROUND));
          m_functionID.put(Keywords.FUNC_SUM_STRING,
                          new Integer(FunctionTable.FUNC_SUM));
          m_functionID.put(Keywords.FUNC_STRING_STRING,
                          new Integer(FunctionTable.FUNC_STRING));
          m_functionID.put(Keywords.FUNC_STARTS_WITH_STRING,
                          new Integer(FunctionTable.FUNC_STARTS_WITH));
          m_functionID.put(Keywords.FUNC_CONTAINS_STRING,
                          new Integer(FunctionTable.FUNC_CONTAINS));
          m_functionID.put(Keywords.FUNC_SUBSTRING_BEFORE_STRING,
                          new Integer(FunctionTable.FUNC_SUBSTRING_BEFORE));
          m_functionID.put(Keywords.FUNC_SUBSTRING_AFTER_STRING,
                          new Integer(FunctionTable.FUNC_SUBSTRING_AFTER));
          m_functionID.put(Keywords.FUNC_NORMALIZE_SPACE_STRING,
                          new Integer(FunctionTable.FUNC_NORMALIZE_SPACE));
          m_functionID.put(Keywords.FUNC_TRANSLATE_STRING,
                          new Integer(FunctionTable.FUNC_TRANSLATE));
          m_functionID.put(Keywords.FUNC_CONCAT_STRING,
                          new Integer(FunctionTable.FUNC_CONCAT));
          m_functionID.put(Keywords.FUNC_SYSTEM_PROPERTY_STRING,
                          new Integer(FunctionTable.FUNC_SYSTEM_PROPERTY));
          m_functionID.put(Keywords.FUNC_EXT_FUNCTION_AVAILABLE_STRING,
                        new Integer(FunctionTable.FUNC_EXT_FUNCTION_AVAILABLE));
          m_functionID.put(Keywords.FUNC_EXT_ELEM_AVAILABLE_STRING,
                          new Integer(FunctionTable.FUNC_EXT_ELEM_AVAILABLE));
          m_functionID.put(Keywords.FUNC_SUBSTRING_STRING,
                          new Integer(FunctionTable.FUNC_SUBSTRING));
          m_functionID.put(Keywords.FUNC_STRING_LENGTH_STRING,
                          new Integer(FunctionTable.FUNC_STRING_LENGTH));
          m_functionID.put(Keywords.FUNC_UNPARSED_ENTITY_URI_STRING,
                          new Integer(FunctionTable.FUNC_UNPARSED_ENTITY_URI));
          m_functionID.put(Keywords.FUNC_DOCLOCATION_STRING,
                          new Integer(FunctionTable.FUNC_DOCLOCATION)); 
          m_functionID.put(Keywords.FUNC_ENDS_WITH_STRING,
                  new Integer(FunctionTable.FUNC_ENDS_WITH));
          m_functionID.put(Keywords.FUNC_UPPER_CASE_STRING,
                  new Integer(FunctionTable.FUNC_UPPER_CASE));
          m_functionID.put(Keywords.FUNC_LOWER_CASE_STRING,
                  new Integer(FunctionTable.FUNC_LOWER_CASE));
          m_functionID.put(Keywords.FUNC_STRING_JOIN_STRING,
                  new Integer(FunctionTable.FUNC_STRING_JOIN));
          m_functionID.put(Keywords.FUNC_STRING_MATCHES, new Integer(FUNC_STRING_MATCHES));
          m_functionID.put(Keywords.FUNC_STRING_REPLACE, new Integer(FUNC_STRING_REPLACE));
          m_functionID.put(Keywords.FUNC_STRING_TOKENIZE, new Integer(FUNC_STRING_TOKENIZE));
          m_functionID.put(Keywords.FUNC_STRING_NORMALIZE_UNICODE, new Integer(FUNC_STRING_NORMALIZE_UNICODE));
          m_functionID.put(Keywords.FUNC_STRING_ENCODE_FOR_URI, new Integer(FUNC_STRING_ENCODE_FOR_URI));
          m_functionID.put(Keywords.FUNC_STRING_IRI_TO_URI, new Integer(FUNC_STRING_IRI_TO_URI));
          m_functionID.put(Keywords.FUNC_STRING_ESCAPE_HTML_URI, new Integer(FUNC_STRING_ESCAPE_HTML_URI));
          
          m_functionID.put(Keywords.FUNC_NUMBER_ADD, new Integer(FUNC_NUMBER_ADD));
          m_functionID.put(Keywords.FUNC_NUMBER_SUBTRACT, new Integer(FUNC_NUMBER_SUBTRACT));
          m_functionID.put(Keywords.FUNC_NUMBER_MULTIPLY, new Integer(FUNC_NUMBER_MULTIPLY));
          m_functionID.put(Keywords.FUNC_NUMBER_DIVIDE, new Integer(FUNC_NUMBER_DIVIDE));
          m_functionID.put(Keywords.FUNC_NUMBER_INTEGER_DIVIDE, new Integer(FUNC_NUMBER_INTEGER_DIVIDE));
          m_functionID.put(Keywords.FUNC_NUMBER_MOD, new Integer(FUNC_NUMBER_MOD));
          m_functionID.put(Keywords.FUNC_NUMBER_UNARY_PLUS, new Integer(FUNC_NUMBER_UNARY_PLUS));
          m_functionID.put(Keywords.FUNC_NUMBER_UNARY_MINUS, new Integer(FUNC_NUMBER_UNARY_MINUS));
          m_functionID.put(Keywords.FUNC_NUMBER_EQUAL, new Integer(FUNC_NUMBER_EQUAL));
          m_functionID.put(Keywords.FUNC_NUMBER_LESS_THAN, new Integer(FUNC_NUMBER_LESS_THAN));
          m_functionID.put(Keywords.FUNC_NUMBER_GREATER_THAN, new Integer(FUNC_NUMBER_GREATER_THAN));
          m_functionID.put(Keywords.FUNC_NUMBER_ABS, new Integer(FUNC_NUMBER_ABS));
          m_functionID.put(Keywords.FUNC_NUMBER_ROUND_HALF_TO_EVEN, new Integer(FUNC_NUMBER_ROUND_HALF_TO_EVEN));
  }
  
  public FunctionTable(){
  }
  
  /**
   * Return the name of the a function in the static table. Needed to avoid
   * making the table publicly available.
   */
  String getFunctionName(int funcID) {
      if (funcID < NUM_BUILT_IN_FUNCS) return m_functions[funcID].getName();
      else return m_functions_customer[funcID - NUM_BUILT_IN_FUNCS].getName();
  }

  /**
   * Obtain a new Function object from a function ID.
   *
   * @param which  The function ID, which may correspond to one of the FUNC_XXX 
   *    values found in {@link org.apache.xpath.compiler.FunctionTable}, but may 
   *    be a value installed by an external module. 
   *
   * @return a a new Function instance.
   *
   * @throws javax.xml.transform.TransformerException if ClassNotFoundException, 
   *    IllegalAccessException, or InstantiationException is thrown.
   */
  Function getFunction(int which)
          throws javax.xml.transform.TransformerException
  {
          try{
              if (which < NUM_BUILT_IN_FUNCS) 
                  return (Function) m_functions[which].newInstance();
              else 
                  return (Function) m_functions_customer[
                      which-NUM_BUILT_IN_FUNCS].newInstance();                  
          }catch (IllegalAccessException ex){
                  throw new TransformerException(ex.getMessage());
          }catch (InstantiationException ex){
                  throw new TransformerException(ex.getMessage());
          }
  }
  
  /**
   * Obtain a function ID from a given function name
   * @param key the function name in a java.lang.String format.
   * @return a function ID, which may correspond to one of the FUNC_XXX values
   * found in {@link org.apache.xpath.compiler.FunctionTable}, but may be a 
   * value installed by an external module.
   */
  Object getFunctionID(String key){
          Object id = m_functionID_customer.get(key);
          if (null == id) id = m_functionID.get(key);
          return id;
  }
  
  /**
   * Install a built-in function.
   * @param name The unqualified name of the function, must not be null
   * @param func A Implementation of an XPath Function object.
   * @return the position of the function in the internal index.
   */
  public int installFunction(String name, Class func)
  {

    int funcIndex;
    Object funcIndexObj = getFunctionID(name);

    if (null != funcIndexObj)
    {
      funcIndex = ((Integer) funcIndexObj).intValue();
      
      if (funcIndex < NUM_BUILT_IN_FUNCS){
              funcIndex = m_funcNextFreeIndex++;
              m_functionID_customer.put(name, new Integer(funcIndex)); 
      }
      m_functions_customer[funcIndex - NUM_BUILT_IN_FUNCS] = func;          
    }
    else
    {
            funcIndex = m_funcNextFreeIndex++;
                          
            m_functions_customer[funcIndex-NUM_BUILT_IN_FUNCS] = func;
                    
            m_functionID_customer.put(name, 
                new Integer(funcIndex));   
    }
    return funcIndex;
  }

  /**
   * Tell if a built-in, non-namespaced function is available.
   *
   * @param methName The local name of the function.
   *
   * @return True if the function can be executed.
   */
  public boolean functionAvailable(String methName)
  {
      Object tblEntry = m_functionID.get(methName);
      if (null != tblEntry) return true;
      else{
              tblEntry = m_functionID_customer.get(methName);
              return (null != tblEntry)? true : false;
      }
  }
}
