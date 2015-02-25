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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.PNGTranscoder;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Image;
import org.pentaho.ui.svg.SvgImage;

public class SwtSvgRenderer {
  /**
   * Convert SVG image to swt Image.
   * 
   * TODO: it will be good to change for direct rendering on the swt canvas for better performance.
   */
  public static Image renderToBitmap( Device device, SvgImage svg ) throws Exception {
    PNGTranscoder tr = new PNGTranscoder();
    TranscoderInput input = new TranscoderInput( svg.getDocument() );
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    TranscoderOutput output = new TranscoderOutput( out );
    tr.transcode( input, output );

    return new Image( device, new ByteArrayInputStream( out.toByteArray() ) );
  }
}
