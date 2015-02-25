/*!
 * This program is free software; you can redistribute it and/or modify it under the
 * terms of the GNU Lesser General Public License, version 2.1 as published by the Free Software
 * Foundation.
 *
 * You should have received a copy of the GNU Lesser General Public License along with this
 * program; if not, you can obtain a copy at http://www.gnu.org/licenses/old-licenses/lgpl-2.1.html
 * or from the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * Copyright (c) 2002-2015 Pentaho Corporation..  All rights reserved.
 */

package org.pentaho.ui.xul.swt.svg;

import static org.junit.Assert.assertNotNull;

import java.io.InputStream;

import org.eclipse.swt.graphics.Image;
import org.junit.Test;
import org.pentaho.ui.svg.SvgImage;
import org.pentaho.ui.svg.SvgSupport;
import org.pentaho.ui.svg.SvgSupportTest;

public class SwtSvgRendererTest {
  @Test
  public final void testRendering() throws Exception {
    InputStream in = SvgSupportTest.class.getResourceAsStream( "/resource/svg/test.svg" );
    SvgImage svg = SvgSupport.loadSvgImage( in );
    assertNotNull( svg.getDocument() );

    Image img = SwtSvgRenderer.renderToBitmap( null, svg );
    assertNotNull( img );
  }
}
