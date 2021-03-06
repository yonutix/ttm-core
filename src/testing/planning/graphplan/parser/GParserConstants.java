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
/* Generated By:JavaCC: Do not edit this line. GParserConstants.java */
package testing.planning.graphplan.parser;

public interface GParserConstants {

  int EOF = 0;
  int DIGIT = 6;
  int NUMBER = 7;
  int LETTER = 8;
  int ROP = 9;
  int AND = 10;
  int TRUE = 11;
  int LITERAL = 12;
  int VARIABLE = 13;

  int DEFAULT = 0;

  String[] tokenImage = {
    "<EOF>",
    "\" \"",
    "\"\\t\"",
    "\"\\n\"",
    "\"\\r\"",
    "\"\\r\\n\"",
    "<DIGIT>",
    "<NUMBER>",
    "<LETTER>",
    "<ROP>",
    "\"&\"",
    "\"true\"",
    "<LITERAL>",
    "<VARIABLE>",
    "\",\"",
    "\"(\"",
    "\")\"",
    "\"[\"",
    "\"]\"",
    "\"operator:\"",
    "\"objects:\"",
    "\";\"",
    "\"init:\"",
    "\"goal:\"",
  };

}
