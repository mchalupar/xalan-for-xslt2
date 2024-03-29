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
 * $Id: Keywords.java 468655 2006-10-28 07:12:06Z minchau $
 */
package org.apache.xpath.compiler;

import java.util.Hashtable;

/**
 * Table of strings to operation code lookups.
 * @xsl.usage internal
 */
public class Keywords
{

  /** Table of keywords to opcode associations. */
  private static Hashtable m_keywords = new Hashtable();

  /** Table of axes names to opcode associations. */
  private static Hashtable m_axisnames = new Hashtable();

  /** Table of function name to function ID associations. */
  private static Hashtable m_nodetests = new Hashtable();

  /** Table of node type strings to opcode associations. */
  private static Hashtable m_nodetypes = new Hashtable();

  /** ancestor axes string. */
  private static final String FROM_ANCESTORS_STRING = "ancestor";

  /** ancestor-or-self axes string. */
  private static final String FROM_ANCESTORS_OR_SELF_STRING =
    "ancestor-or-self";

  /** attribute axes string. */
  private static final String FROM_ATTRIBUTES_STRING = "attribute";

  /** child axes string. */
  private static final String FROM_CHILDREN_STRING = "child";

  /** descendant-or-self axes string. */
  private static final String FROM_DESCENDANTS_STRING = "descendant";

  /** ancestor axes string. */
  private static final String FROM_DESCENDANTS_OR_SELF_STRING =
    "descendant-or-self";

  /** following axes string. */
  private static final String FROM_FOLLOWING_STRING = "following";

  /** following-sibling axes string. */
  private static final String FROM_FOLLOWING_SIBLINGS_STRING =
    "following-sibling";

  /** parent axes string. */
  private static final String FROM_PARENT_STRING = "parent";

  /** preceding axes string. */
  private static final String FROM_PRECEDING_STRING = "preceding";

  /** preceding-sibling axes string. */
  private static final String FROM_PRECEDING_SIBLINGS_STRING =
    "preceding-sibling";

  /** self axes string. */
  private static final String FROM_SELF_STRING = "self";

  /** namespace axes string. */
  private static final String FROM_NAMESPACE_STRING = "namespace";

  /** self axes abreviated string. */
  private static final String FROM_SELF_ABBREVIATED_STRING = ".";

  /** comment node test string. */
  private static final String NODETYPE_COMMENT_STRING = "comment";

  /** text node test string. */
  private static final String NODETYPE_TEXT_STRING = "text";

  /** processing-instruction node test string. */
  private static final String NODETYPE_PI_STRING = "processing-instruction";

  /** Any node test string. */
  private static final String NODETYPE_NODE_STRING = "node";

  /** Wildcard element string. */
  private static final String NODETYPE_ANYELEMENT_STRING = "*";

  /** current function string. */
  public static final String FUNC_CURRENT_STRING = "current";

  /** last function string. */
  public static final String FUNC_LAST_STRING = "last";

  /** position function string. */
  public static final String FUNC_POSITION_STRING = "position";

  /** count function string. */
  public static final String FUNC_COUNT_STRING = "count";

  /** id function string. */
  static final String FUNC_ID_STRING = "id";

  /** key function string (XSLT). */
  public static final String FUNC_KEY_STRING = "key";

  /** local-name function string. */
  public static final String FUNC_LOCAL_PART_STRING = "local-name";

  /** namespace-uri function string. */
  public static final String FUNC_NAMESPACE_STRING = "namespace-uri";

  /** name function string. */
  public static final String FUNC_NAME_STRING = "name";

  /** generate-id function string (XSLT). */
  public static final String FUNC_GENERATE_ID_STRING = "generate-id";

  /** not function string. */
  public static final String FUNC_NOT_STRING = "not";

  /** true function string. */
  public static final String FUNC_TRUE_STRING = "true";

  /** false function string. */
  public static final String FUNC_FALSE_STRING = "false";

  /** boolean function string. */
  public static final String FUNC_BOOLEAN_STRING = "boolean";

  /** lang function string. */
  public static final String FUNC_LANG_STRING = "lang";

  /** number function string. */
  public static final String FUNC_NUMBER_STRING = "number";

  /** floor function string. */
  public static final String FUNC_FLOOR_STRING = "floor";

  /** ceiling function string. */
  public static final String FUNC_CEILING_STRING = "ceiling";

  /** round function string. */
  public static final String FUNC_ROUND_STRING = "round";

  /** sum function string. */
  public static final String FUNC_SUM_STRING = "sum";

  /** string function string. */
  public static final String FUNC_STRING_STRING = "string";

  /** starts-with function string. */
  public static final String FUNC_STARTS_WITH_STRING = "starts-with";

  /** contains function string. */
  public static final String FUNC_CONTAINS_STRING = "contains";

  /** substring-before function string. */
  public static final String FUNC_SUBSTRING_BEFORE_STRING =
    "substring-before";

  /** substring-after function string. */
  public static final String FUNC_SUBSTRING_AFTER_STRING = "substring-after";

  /** normalize-space function string. */
  public static final String FUNC_NORMALIZE_SPACE_STRING = "normalize-space";

  /** translate function string. */
  public static final String FUNC_TRANSLATE_STRING = "translate";

  /** concat function string. */
  public static final String FUNC_CONCAT_STRING = "concat";

  /** system-property function string. */
  public static final String FUNC_SYSTEM_PROPERTY_STRING = "system-property";

  /** function-available function string (XSLT). */
  public static final String FUNC_EXT_FUNCTION_AVAILABLE_STRING =
    "function-available";

  /** element-available function string (XSLT). */
  public static final String FUNC_EXT_ELEM_AVAILABLE_STRING =
    "element-available";

  /** substring function string. */
  public static final String FUNC_SUBSTRING_STRING = "substring";

  /** string-length function string. */
  public static final String FUNC_STRING_LENGTH_STRING = "string-length";

  /** unparsed-entity-uri function string (XSLT). */
  public static final String FUNC_UNPARSED_ENTITY_URI_STRING =
    "unparsed-entity-uri";

  // Proprietary, built in functions

  /** current function string (Proprietary). */
  public static final String FUNC_DOCLOCATION_STRING = "document-location";
  /** XSLT 2.0 Functions and Operators on String */
  public static final String FUNC_ENDS_WITH_STRING = "ends-with";
  public static final String FUNC_UPPER_CASE_STRING = "upper-case";
  public static final String FUNC_LOWER_CASE_STRING = "lower-case";
  public static final String FUNC_STRING_JOIN_STRING = "string-join";
  public static final String FUNC_STRING_MATCHES = "matches";
  public static final String FUNC_STRING_REPLACE = "replace";
  public static final String FUNC_STRING_TOKENIZE = "tokenize";
  public static final String FUNC_STRING_NORMALIZE_UNICODE = "normalize-unicode";
  public static final String FUNC_STRING_ENCODE_FOR_URI = "encode-for-uri";
  public static final String FUNC_STRING_IRI_TO_URI = "iri-to-uri";
  public static final String FUNC_STRING_ESCAPE_HTML_URI = "escape-html-uri";
  
  /** XSLT 2.0 Functions and Operators on Numerics */
  public static final String FUNC_NUMBER_ADD= "numeric-add";
  public static final String FUNC_NUMBER_SUBTRACT= "numeric-subtract";
  public static final String FUNC_NUMBER_MULTIPLY= "numeric-multiply";
  public static final String FUNC_NUMBER_DIVIDE= "numeric-divide";
  public static final String FUNC_NUMBER_INTEGER_DIVIDE= "numeric-integer-divide";
  public static final String FUNC_NUMBER_MOD= "numeric-mod";
  public static final String FUNC_NUMBER_UNARY_PLUS= "numeric-unary-plus";
  public static final String FUNC_NUMBER_UNARY_MINUS= "numeric-unary-minus";
  public static final String FUNC_NUMBER_EQUAL= "numeric-equal";
  public static final String FUNC_NUMBER_LESS_THAN= "numeric-less-than";
  public static final String FUNC_NUMBER_GREATER_THAN= "numeric-greater-than";
  public static final String FUNC_NUMBER_ABS = "abs";
  public static final String FUNC_NUMBER_ROUND_HALF_TO_EVEN = "round-half-to-even";
  /** XSLT 2.0 Functions and Operators on Boolean */
  public static final String FUNC_BOOLEAN_EQUAL = "boolean-equal";
  public static final String FUNC_BOOLEAN_LESS_THAN = "boolean-less-than";
  public static final String FUNC_BOOLEAN_GREATER_THAN = "boolean-greater-than";

  public static final String FUNC_AGGREGATE_MAX = "max";
  public static final String FUNC_AGGREGATE_MIN = "min";
  public static final String FUNC_AGGREGATE_AVG = "avg";
  
  public static final String FUNC_SEQUENCE_CONCATENATE = "concatenate";
  public static final String FUNC_SEQUENCE_INDEXOF ="index-of";
  public static final String FUNC_SEQUENCE_EMPTY ="empty";
  public static final String FUNC_SEQUENCE_EXISTS ="exists";
  public static final String FUNC_SEQUENCE_DISTINCT_VALUE ="distinct-values";
  public static final String FUNC_SEQUENCE_INSERT_BEFORE ="insert-before";
  public static final String FUNC_SEQUENCE_REMOVE ="remove";
  public static final String FUNC_SEQUENCE_REVERSE ="reverse";
  public static final String FUNC_SEQUENCE_SUBSEQUENCE ="subsequence";
  public static final String FUNC_SEQUENCE_UNORDERED ="unordered";
  
  static
  {
    m_axisnames.put(FROM_ANCESTORS_STRING,
                    new Integer(OpCodes.FROM_ANCESTORS));
    m_axisnames.put(FROM_ANCESTORS_OR_SELF_STRING,
                    new Integer(OpCodes.FROM_ANCESTORS_OR_SELF));
    m_axisnames.put(FROM_ATTRIBUTES_STRING,
                    new Integer(OpCodes.FROM_ATTRIBUTES));
    m_axisnames.put(FROM_CHILDREN_STRING,
                    new Integer(OpCodes.FROM_CHILDREN));
    m_axisnames.put(FROM_DESCENDANTS_STRING,
                    new Integer(OpCodes.FROM_DESCENDANTS));
    m_axisnames.put(FROM_DESCENDANTS_OR_SELF_STRING,
                    new Integer(OpCodes.FROM_DESCENDANTS_OR_SELF));
    m_axisnames.put(FROM_FOLLOWING_STRING,
                    new Integer(OpCodes.FROM_FOLLOWING));
    m_axisnames.put(FROM_FOLLOWING_SIBLINGS_STRING,
                    new Integer(OpCodes.FROM_FOLLOWING_SIBLINGS));
    m_axisnames.put(FROM_PARENT_STRING,
                    new Integer(OpCodes.FROM_PARENT));
    m_axisnames.put(FROM_PRECEDING_STRING,
                    new Integer(OpCodes.FROM_PRECEDING));
    m_axisnames.put(FROM_PRECEDING_SIBLINGS_STRING,
                    new Integer(OpCodes.FROM_PRECEDING_SIBLINGS));
    m_axisnames.put(FROM_SELF_STRING,
                    new Integer(OpCodes.FROM_SELF));
    m_axisnames.put(FROM_NAMESPACE_STRING,
                    new Integer(OpCodes.FROM_NAMESPACE));
    m_nodetypes.put(NODETYPE_COMMENT_STRING,
                    new Integer(OpCodes.NODETYPE_COMMENT));
    m_nodetypes.put(NODETYPE_TEXT_STRING,
                    new Integer(OpCodes.NODETYPE_TEXT));
    m_nodetypes.put(NODETYPE_PI_STRING,
                    new Integer(OpCodes.NODETYPE_PI));
    m_nodetypes.put(NODETYPE_NODE_STRING,
                    new Integer(OpCodes.NODETYPE_NODE));
    m_nodetypes.put(NODETYPE_ANYELEMENT_STRING,
                    new Integer(OpCodes.NODETYPE_ANYELEMENT));
    m_keywords.put(FROM_SELF_ABBREVIATED_STRING,
                   new Integer(OpCodes.FROM_SELF));
    m_keywords.put(FUNC_ID_STRING,
                   new Integer(FunctionTable.FUNC_ID));
    m_keywords.put(FUNC_KEY_STRING,
                   new Integer(FunctionTable.FUNC_KEY));

    m_nodetests.put(NODETYPE_COMMENT_STRING,
                    new Integer(OpCodes.NODETYPE_COMMENT));
    m_nodetests.put(NODETYPE_TEXT_STRING,
                    new Integer(OpCodes.NODETYPE_TEXT));
    m_nodetests.put(NODETYPE_PI_STRING,
                    new Integer(OpCodes.NODETYPE_PI));
    m_nodetests.put(NODETYPE_NODE_STRING,
                    new Integer(OpCodes.NODETYPE_NODE));
  }
  
  static Object getAxisName(String key){
          return m_axisnames.get(key);
  }
  
  static Object lookupNodeTest(String key){
          return m_nodetests.get(key);
  }
  
  static Object getKeyWord(String key){
          return m_keywords.get(key);
  }
  
  static Object getNodeType(String key){
          return m_nodetypes.get(key);
  }      
}
