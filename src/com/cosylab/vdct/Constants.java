package com.cosylab.vdct;

/**
 * Copyright (c) 2002, Cosylab, Ltd., Control System Laboratory, www.cosylab.com
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer. 
 * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation 
 * and/or other materials provided with the distribution. 
 * Neither the name of the Cosylab, Ltd., Control System Laboratory nor the names
 * of its contributors may be used to endorse or promote products derived 
 * from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE 
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE 
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, 
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY
 * OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

import java.awt.Color;

/**
 * Insert the type's description here.
 * Creation date: (8.1.2001 18:21:54)
 * @author Matej Sekoranja
 */

public class Constants {

    public final static int VDCT_WIDTH = 1000;
    public final static int VDCT_HEIGHT = 770;

//    public final static String COPY_SUFFIX = "_copy";
//    public final static String MOVE_SUFFIX = "_2";
    public final static String COPY_SUFFIX = "2";
    public final static String MOVE_SUFFIX = "2";

 	public final static String VDCT_PLUGINS_FILE = "VDCT_PLUGINS_FILE";
 	
    public /*final*/ static char GROUP_SEPARATOR = ':';
    public final static char FIELD_SEPARATOR = '.';
    public final static String HARDWARE_LINK = "#";

    public final static String UNTITLED = "Untitled";
    public final static String MAIN_GROUP = "Main group";
    public final static String TEMPLATE_GROUP = "Template";

    public final static String CONFIG_DIR = "config/";
    public final static String DTD_DIR = CONFIG_DIR + "dtd/";

    public final static String NONE = "<none>";
	public final static String MENU_DEFAULT_VALUE_INDICATOR = "*";
    public final static String CLIPBOARD_NAME = "<clipboard>";

    public final static int MAX_RECORD_NAME_LENGTH = 29;
    public final static int MAX_GROUP_NAME_LENGTH = MAX_RECORD_NAME_LENGTH - 2;

    public final static int UNDO_STEPS_TO_REMEMBER = 25;

    public final static int VIRTUAL_WIDTH = 5000;
    public final static int VIRTUAL_HEIGHT = 5000;

    public final static int GRID_SIZE = 20;

    public static final int RECORD_WIDTH = 160;
    public static final int RECORD_HEIGHT = 45;

    public static final int FIELD_WIDTH = RECORD_WIDTH - 30;
    public static final int FIELD_HEIGHT = 20;

    public static final int GROUP_FIELD_WIDTH = RECORD_WIDTH - 30;
    public static final int GROUP_FIELD_HEIGHT = 20;

    public static final int GROUP_WIDTH = 200;
    public static final int GROUP_HEIGHT = 120;

    public static final int TEMPLATE_WIDTH = 200;
    public static final int TEMPLATE_INITIAL_HEIGHT = 120;
    public static final int TEMPLATE_MIN_HEIGHT = 180;

    public static final int INVISIBLE_CROSS_SIZE = 10;

    public static final int LINK_STUB_SIZE = 20;

    public static final int CONNECTOR_WIDTH = 6;
    public static final int CONNECTOR_HEIGHT = 6;
    public static final int LINK_RADIOUS = 5;

    public static final int TAIL_LENGTH = 50 + 3 * LINK_RADIOUS;
    public static final int LINK_LABEL_LENGTH = TAIL_LENGTH - 3 * LINK_RADIOUS;

    public static final String DEFAULT_FONT = "sansserif";

/*
	// VDCT mode
    public final static Color BACKGROUND_COLOR = Color.white;
    public final static Color PICK_COLOR = Color.pink;
    public final static Color FRAME_COLOR = Color.black;
    public final static Color HILITE_COLOR = Color.red;
    public final static Color LINE_COLOR = Color.black;
    public final static Color RECORD_COLOR = Color.white;
    public final static Color SELECTION_COLOR = Color.pink;
    public final static Color LINK_COLOR = Color.white;

    public final static Color GRID_COLOR = Color.lightGray;
*/

	// Capfast mode
    public final static Color BACKGROUND_COLOR = Color.black;
    public final static Color PICK_COLOR = Color.red;
    public final static Color FRAME_COLOR = Color.white;
    public final static Color HILITE_COLOR = Color.yellow;
    public final static Color LINE_COLOR = Color.white;
    public final static Color RECORD_COLOR = Color.black;
    public final static Color SELECTION_COLOR = Color.red;
    public final static Color LINK_COLOR = Color.white;

    public final static Color GRID_COLOR = Color.lightGray;

    public static final int DASHED_LINE_DENSITY = 8;
    public static final int ARROW_SIZE = 16;
    public static final double ARROW_SHARPNESS = Math.PI / 12;

}
