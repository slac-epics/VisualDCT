package com.cosylab.vdct.util;

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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

/**
 * @author Matej
 */
public class PathSpecification
{
	
	protected ArrayList currentPath = null;
	protected ArrayList addPath = null;
	
	protected String currentDir = null;
	public static final char PATH_SEPARATOR = ':';
	
	/**
	 */
	public PathSpecification (String defaultPath)
	{
		currentDir = defaultPath;
		
		currentPath = new ArrayList();
		currentPath.add(currentDir);

		addPath = new ArrayList();		
	}
	
	/**
	 */
	public static void splitPath(String dirs, String currentDir, ArrayList list)
	{
		if (dirs==null || dirs.length()==0)
			return;

		// replace all to PATH_SEPARATOR
		dirs = dirs.replace(File.pathSeparatorChar, PATH_SEPARATOR);
		
		int pos1 = -1;
		int pos2 = pos1;
		do
		{
			pos2 = dirs.indexOf(PATH_SEPARATOR, pos1+1);
			if (pos2==-1)
				pos2 = dirs.length();

			// special case for  "::" part
			if ((pos1+1)==pos2)
				list.add(currentDir);			
			else
			{
				String part = dirs.substring(pos1+1, pos2);
				list.add(part);			
			}	

			pos1 = pos2;
		} while (pos1<dirs.length());
		
	}

	/**
	 */
	public void setPath(String dirs)
	{
		if (dirs!=null && dirs.length()>0)
		{
			currentPath.clear();
			splitPath(dirs, currentDir, currentPath);
		}
	}		
	
	/**
	 */
	public void addAddPath(String dirs)
	{
		splitPath(dirs, currentDir, addPath);
	}

	/**
	 */
	public File search4File(String fileName) throws FileNotFoundException
	{
		// should we use paths?
		File t = null;
		if (fileName.indexOf('/')!=-1 || fileName.indexOf('\\')!=-1)
		{
			t = new File(currentDir, fileName);
			if (t.exists())
				return t;
			else
				return null;		
		}
		
		// go and search		
		Iterator pI = currentPath.iterator();
		while (pI.hasNext())
		{
			String rootPath = (String)pI.next();
			
			// check path
			t = new File(rootPath, fileName);
			if (t.exists())
				return t;
				
			// check all add paths
			Iterator aI = addPath.iterator();
			while (aI.hasNext())
			{
				String fullPath = rootPath + File.separator + (String)aI.next();
				t = new File(fullPath, fileName);
				if (t.exists())
					return t;
			}

		}
		 
		StringBuffer path = new StringBuffer();
		pI = currentPath.iterator();
		while (pI.hasNext())
		{
			path.append(pI.next());
			if (pI.hasNext()) path.append(':');
		}
				
		StringBuffer addpath = new StringBuffer();
		pI = addPath.iterator();
		while (pI.hasNext())
		{
			addpath.append(pI.next());
			if (pI.hasNext()) addpath.append(':');
		}

		// not found
		throw new FileNotFoundException("File '"+fileName+"' not found (path: \""+path.toString()+"\", addpath: \""+addpath.toString()+"\").");
	}

/*
	public static void main(String[] argv)
	{
		// test
		DBPathSpecification spec = new DBPathSpecification(CURRENT_DIR);

		System.out.println("===========");
		spec.search4File("dummy");
		System.out.println("===========");
		spec.setPath("");		
		spec.search4File("dummy");
		System.out.println("===========");
		spec.setPath(":");		
		spec.search4File("dummy");
		System.out.println("===========");
		spec.setPath("nnn::mmm");		
		spec.search4File("dummy");
		System.out.println("===========");
		spec.setPath(":nnn");		
		spec.search4File("dummy");
		System.out.println("===========");
		spec.setPath("mmm:");		
		spec.search4File("dummy");
		System.out.println("===========");
		spec.setPath(":usr:lib:dbd:dir:sth::well:sth:here");		
		spec.search4File("dummy");
		System.out.println("===========");
		spec.addAddPath("added:added2");
		spec.search4File("dummy");
		System.out.println("===========");
	}
*/
}