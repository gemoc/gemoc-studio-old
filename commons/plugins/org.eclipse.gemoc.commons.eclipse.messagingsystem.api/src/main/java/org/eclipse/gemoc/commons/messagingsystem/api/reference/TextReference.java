/*$Id:  $
* License : EPL
* Copyright : IRISA / INRIA 
* ----------------------------------------------------------------------------
* Creation date : 14 avr. 2011
* Authors : 
*      Didier Vojtisek <didier.vojtisek@inria.fr>
*/
package org.eclipse.gemoc.commons.messagingsystem.api.reference;

import java.net.URL;

public class TextReference extends org.eclipse.gemoc.commons.messagingsystem.api.reference.FileReference {

		protected Integer beginOffset = 0;
		protected Integer endOffset = 0;
		protected Integer beginLine = 0;
		protected Integer endLine = 0;
		
			
		public TextReference(URL fileURL, Integer beginOffset, Integer endOffset) {
			super(fileURL);
			this.beginOffset = beginOffset;
			this.endOffset = endOffset;
		}
		
		// getters and setters
		public Integer getBeginOffset() {
			return beginOffset;
		}
		public void setBeginOffset(Integer beginOffset) {
			this.beginOffset = beginOffset;
		}
		public Integer getEndOffset() {
			return endOffset;
		}
		public void setEndOffset(Integer endOffset) {
			this.endOffset = endOffset;
		}
		public Integer getBeginLine() {
			return beginLine;
		}

		public void setBeginLine(Integer beginLine) {
			this.beginLine = beginLine;
		}

		public Integer getEndLine() {
			return endLine;
		}

		public void setEndLine(Integer endLine) {
			this.endLine = endLine;
		}

		@Override
		public String toString() {
			
			return this.getClass().getCanonicalName()+"("+fileURL+",offset["+beginOffset+","+endOffset+"],line["+beginLine+","+endLine+"])";
		}	
		
	}

	
