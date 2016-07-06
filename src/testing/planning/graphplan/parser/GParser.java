/*******************************************************************************
 * Copyright (C) 2013 Andrei Olaru, Marius-Tudor Benea, Nguyen Thi Thuy Nga, Amal El Fallah Seghrouchni, Cedric Herpson.
 * 
 * This file is part of tATAmI-PC.
 * 
 * tATAmI-PC is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation, either version 3 of the License, or any later version.
 * 
 * tATAmI-PC is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License along with tATAmI-PC.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
/* Generated By:JavaCC: Do not edit this line. GParser.java */
package testing.planning.graphplan.parser;

import testing.planning.graphplan.*;
import java.util.*;

public class GParser implements GParserConstants {

  public static void main(String args[]) throws ParseException {
    GParser parser = null ;
    if (args.length == 0) {
      System.out.println("GParser Version 0.1:  Reading from standard input . . .");
      parser = new GParser(System.in);
    } else {
      System.out.println("GParser Version 0.1:  Reading from file " + args[0] + " . . .");
      try {
        parser = new GParser(new java.io.FileInputStream(args[0]));
      } catch (java.io.FileNotFoundException e) {
        System.out.println("GParser Version 0.1:  File " + args[0] + " not found.");
        return;
      }
    }

     // start the parser

     parser.OpFile();
     System.out.println("GParser Version 0.1: Ops File Parsed Successfuly");

     // parse the facts file
     try {
        parser.ReInit(new java.io.FileInputStream(args[1]));
      } catch (java.io.FileNotFoundException e) {
        System.out.println("GParser Version 0.1:  File " + args[1] + " not found.");
        return;
      }
        parser.FactFile();
      System.out.println("GParser Version 0.1: Facts File Parsed Successfuly");

  }

  static final public String Term() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case VARIABLE:
      jj_consume_token(VARIABLE);
               {if (true) return getToken(0).image;}
      break;
    case NUMBER:
      jj_consume_token(NUMBER);
               {if (true) return getToken(0).image;}
      break;
    default:
      jj_la1[0] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static final public Expression Expr() throws ParseException {
 String left;
 String right;
 Token op;
 Expression e;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NUMBER:
    case VARIABLE:
      left = Term();
      op = jj_consume_token(ROP);
      right = Term();
                                           {if (true) return new Expression (left, op.image, right);}
      break;
    case TRUE:
      jj_consume_token(TRUE);
           {if (true) return null;}
      break;
    default:
      jj_la1[1] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static final public TParaList ParaList() throws ParseException {
 Vector types = new Vector();
 Vector vars = new Vector();
 Token t;
    t = jj_consume_token(LITERAL);
                types.addElement(t.image);
    t = jj_consume_token(VARIABLE);
                 vars.addElement(t.image);
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 14:
        ;
        break;
      default:
        jj_la1[2] = jj_gen;
        break label_1;
      }
      jj_consume_token(14);
      t = jj_consume_token(LITERAL);
                      types.addElement(t.image);
      t = jj_consume_token(VARIABLE);
                                                                  vars.addElement(t.image);
    }
   {if (true) return new TParaList (types, vars);}
    throw new Error("Missing return statement in function");
  }

  static final public Vector ParaCond() throws ParseException {
 Vector cond = new Vector();
 Expression e;
    e = Expr();
  if (e != null)
        cond.addElement(e);
  else
        {if (true) return null;}    // null vector means "true"

    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case AND:
        ;
        break;
      default:
        jj_la1[3] = jj_gen;
        break label_2;
      }
      jj_consume_token(AND);
      e = Expr();
                    cond.addElement(e);
    }
  {if (true) return cond;}
    throw new Error("Missing return statement in function");
  }

  static final public String VarList() throws ParseException {
 Token t;
 String vl = new String();
    t = jj_consume_token(VARIABLE);
                  vl += t.image;
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 14:
        ;
        break;
      default:
        jj_la1[4] = jj_gen;
        break label_3;
      }
      jj_consume_token(14);
      jj_consume_token(VARIABLE);
                  vl += "," + getToken(0).image;
    }
   {if (true) return vl;}
    throw new Error("Missing return statement in function");
  }

  static final public String Proposition() throws ParseException {
 Token t;
 String pro = new String();
 String temp = new String();
    t = jj_consume_token(LITERAL);
                   pro += t.image + "(";
    jj_consume_token(15);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case VARIABLE:
      temp = VarList();
      break;
    default:
      jj_la1[5] = jj_gen;
      ;
    }
    jj_consume_token(16);
   {if (true) return (pro + temp + ")" );}
    throw new Error("Missing return statement in function");
  }

  static final public Vector Conjunction() throws ParseException {
 String cnj = new String();
 String temp = new String();
 Vector v = new Vector();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 17:
      jj_consume_token(17);
      cnj = Proposition();
                          v.addElement(cnj);
      label_4:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case AND:
          ;
          break;
        default:
          jj_la1[6] = jj_gen;
          break label_4;
        }
        jj_consume_token(AND);
        cnj = Proposition();
                              v.addElement(cnj);
      }
      jj_consume_token(18);
                                                          {if (true) return v;}
      break;
    case TRUE:
      jj_consume_token(TRUE);
             {if (true) return null;}
      break;
    default:
      jj_la1[7] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static final public TOpHead OpHead() throws ParseException {
 Token t;
 String name;
 TParaList pl = null;
    t = jj_consume_token(LITERAL);
               name = t.image;
    jj_consume_token(15);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LITERAL:
      pl = ParaList();
      break;
    default:
      jj_la1[8] = jj_gen;
      ;
    }
    jj_consume_token(16);
  {if (true) return new TOpHead(name, pl);}
    throw new Error("Missing return statement in function");
  }

  static final public TOperator Operator() throws ParseException {
 TOpHead head;
 Vector cond;
 Vector pre;
 Vector add;
 Vector del;
    jj_consume_token(19);
    head = OpHead();
    cond = ParaCond();
    pre = Conjunction();
    add = Conjunction();
    del = Conjunction();
  {if (true) return new TOperator (head, cond, pre, add, del);}
    throw new Error("Missing return statement in function");
  }

  static final public TOperatorSet OpFile() throws ParseException {
 TOperator op;
 TOperatorSet ops = new TOperatorSet();
    label_5:
    while (true) {
      op = Operator();
                    ops.addOperator(op);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 19:
        ;
        break;
      default:
        jj_la1[9] = jj_gen;
        break label_5;
      }
    }
   {if (true) return ops;}
    throw new Error("Missing return statement in function");
  }

////////////////////  Parsing the Facts File //////////////////////////////
  static final public ObjectSet Objects() throws ParseException {
 ObjectSet os;
    jj_consume_token(20);
    os = ObjList();
  {if (true) return os;}
    throw new Error("Missing return statement in function");
  }

  static final public ObjectSet ObjList() throws ParseException {
 ObjectSet os = new ObjectSet();
 Token type;
 Token name;
    label_6:
    while (true) {
      type = jj_consume_token(LITERAL);
      jj_consume_token(15);
      name = jj_consume_token(LITERAL);
      jj_consume_token(16);
      jj_consume_token(21);
    os.addObject(new Pair(type.image, name.image));
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case LITERAL:
        ;
        break;
      default:
        jj_la1[10] = jj_gen;
        break label_6;
      }
    }
  {if (true) return os;}
    throw new Error("Missing return statement in function");
  }

  static final public Conjunction InitState() throws ParseException {
 Conjunction cnj = new Conjunction();
    jj_consume_token(22);
    cnj = IConjunction();
  {if (true) return cnj;}
    throw new Error("Missing return statement in function");
  }

  static final public Conjunction IConjunction() throws ParseException {
 Conjunction cnj = new Conjunction();
 String temp;
    temp = IProposition();
                        cnj.addLiteral(temp);
    label_7:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case AND:
        ;
        break;
      default:
        jj_la1[11] = jj_gen;
        break label_7;
      }
      jj_consume_token(AND);
      temp = IProposition();
                              cnj.addLiteral (temp);
    }
 {if (true) return cnj;}
    throw new Error("Missing return statement in function");
  }

  static final public String IProposition() throws ParseException {
 Token t;
 String s;
 String temp = new String();
    t = jj_consume_token(LITERAL);
                s = t.image + "(";
    jj_consume_token(15);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LITERAL:
      temp = DList();
      break;
    default:
      jj_la1[12] = jj_gen;
      ;
    }
    jj_consume_token(16);
  s += temp + ")"; {if (true) return s;}
    throw new Error("Missing return statement in function");
  }

  static final public String DList() throws ParseException {
 Token t;
 String s;
    t = jj_consume_token(LITERAL);
                  s = t.image;
    label_8:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 14:
        ;
        break;
      default:
        jj_la1[13] = jj_gen;
        break label_8;
      }
      jj_consume_token(14);
      t = jj_consume_token(LITERAL);
                     { s += "," + t.image; }
    }
  {if (true) return s;}
    throw new Error("Missing return statement in function");
  }

  static final public Conjunction Goal() throws ParseException {
 Conjunction cnj = new Conjunction();
    jj_consume_token(23);
    cnj = IConjunction();
  {if (true) return cnj;}
    throw new Error("Missing return statement in function");
  }

  static final public void FactFile() throws ParseException {
    Objects();
    InitState();
    Goal();
  }

  static private boolean jj_initialized_once = false;
  static public GParserTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  static public Token token, jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[14];
  static private int[] jj_la1_0;
  static {
      jj_la1_0();
   }
   private static void jj_la1_0() {
      jj_la1_0 = new int[] {0x2080,0x2880,0x4000,0x400,0x4000,0x2000,0x400,0x20800,0x1000,0x80000,0x1000,0x400,0x1000,0x4000,};
   }

  public GParser(java.io.InputStream stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  You must");
      System.out.println("       either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new GParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 14; i++) jj_la1[i] = -1;
  }

  static public void ReInit(java.io.InputStream stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 14; i++) jj_la1[i] = -1;
  }

  public GParser(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  You must");
      System.out.println("       either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new GParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 14; i++) jj_la1[i] = -1;
  }

  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 14; i++) jj_la1[i] = -1;
  }

  public GParser(GParserTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  You must");
      System.out.println("       either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 14; i++) jj_la1[i] = -1;
  }

  public void ReInit(GParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 14; i++) jj_la1[i] = -1;
  }

  static final private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static final private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.Vector jj_expentries = new java.util.Vector();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  static public ParseException generateParseException() {
    jj_expentries.removeAllElements();
    boolean[] la1tokens = new boolean[24];
    for (int i = 0; i < 24; i++) {
      la1tokens[i] = false;
    }
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 14; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 24; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.addElement(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = (int[])jj_expentries.elementAt(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  static final public void enable_tracing() {
  }

  static final public void disable_tracing() {
  }

}