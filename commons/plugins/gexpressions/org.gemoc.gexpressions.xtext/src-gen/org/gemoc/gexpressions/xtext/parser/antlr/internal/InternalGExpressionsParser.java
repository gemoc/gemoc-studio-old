package org.gemoc.gexpressions.xtext.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.gemoc.gexpressions.xtext.services.GExpressionsGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalGExpressionsParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_BOOLEAN", "RULE_INT", "RULE_DOUBLE", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "';'", "'import'", "'#'", "'if'", "'then'", "'else'", "'endif'", "'('", "')'", "'.'", "'->'", "'and'", "'xor'", "'or'", "'='", "'<>'", "'<'", "'>'", "'<='", "'>='", "'+'", "'-'", "'*'", "'/'", "'not'", "'~'"
    };
    public static final int RULE_BOOLEAN=6;
    public static final int RULE_ID=5;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=12;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=10;
    public static final int EOF=-1;
    public static final int RULE_DOUBLE=8;
    public static final int RULE_ML_COMMENT=9;
    public static final int T__30=30;
    public static final int T__19=19;
    public static final int T__31=31;
    public static final int RULE_STRING=4;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__16=16;
    public static final int T__34=34;
    public static final int T__15=15;
    public static final int T__35=35;
    public static final int T__18=18;
    public static final int T__36=36;
    public static final int T__17=17;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=7;
    public static final int RULE_WS=11;

    // delegates
    // delegators


        public InternalGExpressionsParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalGExpressionsParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalGExpressionsParser.tokenNames; }
    public String getGrammarFileName() { return "../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g"; }



     	private GExpressionsGrammarAccess grammarAccess;
     	
        public InternalGExpressionsParser(TokenStream input, GExpressionsGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "GProgram";	
       	}
       	
       	@Override
       	protected GExpressionsGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleGProgram"
    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:68:1: entryRuleGProgram returns [EObject current=null] : iv_ruleGProgram= ruleGProgram EOF ;
    public final EObject entryRuleGProgram() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGProgram = null;


        try {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:69:2: (iv_ruleGProgram= ruleGProgram EOF )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:70:2: iv_ruleGProgram= ruleGProgram EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGProgramRule()); 
            }
            pushFollow(FOLLOW_ruleGProgram_in_entryRuleGProgram75);
            iv_ruleGProgram=ruleGProgram();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGProgram; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleGProgram85); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGProgram"


    // $ANTLR start "ruleGProgram"
    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:77:1: ruleGProgram returns [EObject current=null] : ( ( (lv_imports_0_0= ruleGImportStatement ) )* ( ( (lv_expressions_1_0= ruleGExpression ) ) ( (otherlv_2= ';' )? ( (lv_expressions_3_0= ruleGExpression ) ) )* )? ) ;
    public final EObject ruleGProgram() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_imports_0_0 = null;

        EObject lv_expressions_1_0 = null;

        EObject lv_expressions_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:80:28: ( ( ( (lv_imports_0_0= ruleGImportStatement ) )* ( ( (lv_expressions_1_0= ruleGExpression ) ) ( (otherlv_2= ';' )? ( (lv_expressions_3_0= ruleGExpression ) ) )* )? ) )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:81:1: ( ( (lv_imports_0_0= ruleGImportStatement ) )* ( ( (lv_expressions_1_0= ruleGExpression ) ) ( (otherlv_2= ';' )? ( (lv_expressions_3_0= ruleGExpression ) ) )* )? )
            {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:81:1: ( ( (lv_imports_0_0= ruleGImportStatement ) )* ( ( (lv_expressions_1_0= ruleGExpression ) ) ( (otherlv_2= ';' )? ( (lv_expressions_3_0= ruleGExpression ) ) )* )? )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:81:2: ( (lv_imports_0_0= ruleGImportStatement ) )* ( ( (lv_expressions_1_0= ruleGExpression ) ) ( (otherlv_2= ';' )? ( (lv_expressions_3_0= ruleGExpression ) ) )* )?
            {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:81:2: ( (lv_imports_0_0= ruleGImportStatement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==14) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:82:1: (lv_imports_0_0= ruleGImportStatement )
            	    {
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:82:1: (lv_imports_0_0= ruleGImportStatement )
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:83:3: lv_imports_0_0= ruleGImportStatement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getGProgramAccess().getImportsGImportStatementParserRuleCall_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleGImportStatement_in_ruleGProgram131);
            	    lv_imports_0_0=ruleGImportStatement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getGProgramRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"imports",
            	              		lv_imports_0_0, 
            	              		"GImportStatement");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:99:3: ( ( (lv_expressions_1_0= ruleGExpression ) ) ( (otherlv_2= ';' )? ( (lv_expressions_3_0= ruleGExpression ) ) )* )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>=RULE_STRING && LA4_0<=RULE_DOUBLE)||(LA4_0>=15 && LA4_0<=16)||LA4_0==20||(LA4_0>=37 && LA4_0<=38)) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:99:4: ( (lv_expressions_1_0= ruleGExpression ) ) ( (otherlv_2= ';' )? ( (lv_expressions_3_0= ruleGExpression ) ) )*
                    {
                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:99:4: ( (lv_expressions_1_0= ruleGExpression ) )
                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:100:1: (lv_expressions_1_0= ruleGExpression )
                    {
                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:100:1: (lv_expressions_1_0= ruleGExpression )
                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:101:3: lv_expressions_1_0= ruleGExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getGProgramAccess().getExpressionsGExpressionParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleGExpression_in_ruleGProgram154);
                    lv_expressions_1_0=ruleGExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getGProgramRule());
                      	        }
                             		add(
                             			current, 
                             			"expressions",
                              		lv_expressions_1_0, 
                              		"GExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:117:2: ( (otherlv_2= ';' )? ( (lv_expressions_3_0= ruleGExpression ) ) )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( ((LA3_0>=RULE_STRING && LA3_0<=RULE_DOUBLE)||LA3_0==13||(LA3_0>=15 && LA3_0<=16)||LA3_0==20||(LA3_0>=37 && LA3_0<=38)) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:117:3: (otherlv_2= ';' )? ( (lv_expressions_3_0= ruleGExpression ) )
                    	    {
                    	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:117:3: (otherlv_2= ';' )?
                    	    int alt2=2;
                    	    int LA2_0 = input.LA(1);

                    	    if ( (LA2_0==13) ) {
                    	        alt2=1;
                    	    }
                    	    switch (alt2) {
                    	        case 1 :
                    	            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:117:5: otherlv_2= ';'
                    	            {
                    	            otherlv_2=(Token)match(input,13,FOLLOW_13_in_ruleGProgram168); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	                  	newLeafNode(otherlv_2, grammarAccess.getGProgramAccess().getSemicolonKeyword_1_1_0());
                    	                  
                    	            }

                    	            }
                    	            break;

                    	    }

                    	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:121:3: ( (lv_expressions_3_0= ruleGExpression ) )
                    	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:122:1: (lv_expressions_3_0= ruleGExpression )
                    	    {
                    	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:122:1: (lv_expressions_3_0= ruleGExpression )
                    	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:123:3: lv_expressions_3_0= ruleGExpression
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getGProgramAccess().getExpressionsGExpressionParserRuleCall_1_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleGExpression_in_ruleGProgram191);
                    	    lv_expressions_3_0=ruleGExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getGProgramRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"expressions",
                    	              		lv_expressions_3_0, 
                    	              		"GExpression");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGProgram"


    // $ANTLR start "entryRuleGImportStatement"
    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:147:1: entryRuleGImportStatement returns [EObject current=null] : iv_ruleGImportStatement= ruleGImportStatement EOF ;
    public final EObject entryRuleGImportStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGImportStatement = null;


        try {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:148:2: (iv_ruleGImportStatement= ruleGImportStatement EOF )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:149:2: iv_ruleGImportStatement= ruleGImportStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGImportStatementRule()); 
            }
            pushFollow(FOLLOW_ruleGImportStatement_in_entryRuleGImportStatement231);
            iv_ruleGImportStatement=ruleGImportStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGImportStatement; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleGImportStatement241); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGImportStatement"


    // $ANTLR start "ruleGImportStatement"
    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:156:1: ruleGImportStatement returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleGImportStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_importURI_1_0=null;

         enterRule(); 
            
        try {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:159:28: ( (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) ) )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:160:1: (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) )
            {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:160:1: (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:160:3: otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,14,FOLLOW_14_in_ruleGImportStatement278); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getGImportStatementAccess().getImportKeyword_0());
                  
            }
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:164:1: ( (lv_importURI_1_0= RULE_STRING ) )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:165:1: (lv_importURI_1_0= RULE_STRING )
            {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:165:1: (lv_importURI_1_0= RULE_STRING )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:166:3: lv_importURI_1_0= RULE_STRING
            {
            lv_importURI_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleGImportStatement295); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_importURI_1_0, grammarAccess.getGImportStatementAccess().getImportURISTRINGTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getGImportStatementRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"importURI",
                      		lv_importURI_1_0, 
                      		"STRING");
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGImportStatement"


    // $ANTLR start "entryRuleGExpression"
    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:190:1: entryRuleGExpression returns [EObject current=null] : iv_ruleGExpression= ruleGExpression EOF ;
    public final EObject entryRuleGExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGExpression = null;


        try {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:191:2: (iv_ruleGExpression= ruleGExpression EOF )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:192:2: iv_ruleGExpression= ruleGExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleGExpression_in_entryRuleGExpression336);
            iv_ruleGExpression=ruleGExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleGExpression346); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGExpression"


    // $ANTLR start "ruleGExpression"
    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:199:1: ruleGExpression returns [EObject current=null] : this_GOrExpression_0= ruleGOrExpression ;
    public final EObject ruleGExpression() throws RecognitionException {
        EObject current = null;

        EObject this_GOrExpression_0 = null;


         enterRule(); 
            
        try {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:202:28: (this_GOrExpression_0= ruleGOrExpression )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:204:5: this_GOrExpression_0= ruleGOrExpression
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getGExpressionAccess().getGOrExpressionParserRuleCall()); 
                  
            }
            pushFollow(FOLLOW_ruleGOrExpression_in_ruleGExpression392);
            this_GOrExpression_0=ruleGOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_GOrExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGExpression"


    // $ANTLR start "entryRuleGOrExpression"
    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:220:1: entryRuleGOrExpression returns [EObject current=null] : iv_ruleGOrExpression= ruleGOrExpression EOF ;
    public final EObject entryRuleGOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGOrExpression = null;


        try {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:221:2: (iv_ruleGOrExpression= ruleGOrExpression EOF )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:222:2: iv_ruleGOrExpression= ruleGOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGOrExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleGOrExpression_in_entryRuleGOrExpression426);
            iv_ruleGOrExpression=ruleGOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGOrExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleGOrExpression436); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGOrExpression"


    // $ANTLR start "ruleGOrExpression"
    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:229:1: ruleGOrExpression returns [EObject current=null] : (this_GXorExpression_0= ruleGXorExpression ( () ( (lv_operator_2_0= ruleGOrOperator ) ) ( (lv_rightOperand_3_0= ruleGXorExpression ) ) )* ) ;
    public final EObject ruleGOrExpression() throws RecognitionException {
        EObject current = null;

        EObject this_GXorExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:232:28: ( (this_GXorExpression_0= ruleGXorExpression ( () ( (lv_operator_2_0= ruleGOrOperator ) ) ( (lv_rightOperand_3_0= ruleGXorExpression ) ) )* ) )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:233:1: (this_GXorExpression_0= ruleGXorExpression ( () ( (lv_operator_2_0= ruleGOrOperator ) ) ( (lv_rightOperand_3_0= ruleGXorExpression ) ) )* )
            {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:233:1: (this_GXorExpression_0= ruleGXorExpression ( () ( (lv_operator_2_0= ruleGOrOperator ) ) ( (lv_rightOperand_3_0= ruleGXorExpression ) ) )* )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:234:5: this_GXorExpression_0= ruleGXorExpression ( () ( (lv_operator_2_0= ruleGOrOperator ) ) ( (lv_rightOperand_3_0= ruleGXorExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getGOrExpressionAccess().getGXorExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleGXorExpression_in_ruleGOrExpression483);
            this_GXorExpression_0=ruleGXorExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_GXorExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:242:1: ( () ( (lv_operator_2_0= ruleGOrOperator ) ) ( (lv_rightOperand_3_0= ruleGXorExpression ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==26) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:242:2: () ( (lv_operator_2_0= ruleGOrOperator ) ) ( (lv_rightOperand_3_0= ruleGXorExpression ) )
            	    {
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:242:2: ()
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:243:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getGOrExpressionAccess().getGOrExpressionLeftOperandAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:248:2: ( (lv_operator_2_0= ruleGOrOperator ) )
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:249:1: (lv_operator_2_0= ruleGOrOperator )
            	    {
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:249:1: (lv_operator_2_0= ruleGOrOperator )
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:250:3: lv_operator_2_0= ruleGOrOperator
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getGOrExpressionAccess().getOperatorGOrOperatorEnumRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleGOrOperator_in_ruleGOrExpression513);
            	    lv_operator_2_0=ruleGOrOperator();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getGOrExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"operator",
            	              		lv_operator_2_0, 
            	              		"GOrOperator");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:266:2: ( (lv_rightOperand_3_0= ruleGXorExpression ) )
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:267:1: (lv_rightOperand_3_0= ruleGXorExpression )
            	    {
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:267:1: (lv_rightOperand_3_0= ruleGXorExpression )
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:268:3: lv_rightOperand_3_0= ruleGXorExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getGOrExpressionAccess().getRightOperandGXorExpressionParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleGXorExpression_in_ruleGOrExpression534);
            	    lv_rightOperand_3_0=ruleGXorExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getGOrExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"rightOperand",
            	              		lv_rightOperand_3_0, 
            	              		"GXorExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGOrExpression"


    // $ANTLR start "entryRuleGXorExpression"
    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:292:1: entryRuleGXorExpression returns [EObject current=null] : iv_ruleGXorExpression= ruleGXorExpression EOF ;
    public final EObject entryRuleGXorExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGXorExpression = null;


        try {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:293:2: (iv_ruleGXorExpression= ruleGXorExpression EOF )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:294:2: iv_ruleGXorExpression= ruleGXorExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGXorExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleGXorExpression_in_entryRuleGXorExpression572);
            iv_ruleGXorExpression=ruleGXorExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGXorExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleGXorExpression582); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGXorExpression"


    // $ANTLR start "ruleGXorExpression"
    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:301:1: ruleGXorExpression returns [EObject current=null] : (this_GAndExpression_0= ruleGAndExpression ( () ( (lv_operator_2_0= ruleGXorOperator ) ) ( (lv_rightOperand_3_0= ruleGAndExpression ) ) )* ) ;
    public final EObject ruleGXorExpression() throws RecognitionException {
        EObject current = null;

        EObject this_GAndExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:304:28: ( (this_GAndExpression_0= ruleGAndExpression ( () ( (lv_operator_2_0= ruleGXorOperator ) ) ( (lv_rightOperand_3_0= ruleGAndExpression ) ) )* ) )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:305:1: (this_GAndExpression_0= ruleGAndExpression ( () ( (lv_operator_2_0= ruleGXorOperator ) ) ( (lv_rightOperand_3_0= ruleGAndExpression ) ) )* )
            {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:305:1: (this_GAndExpression_0= ruleGAndExpression ( () ( (lv_operator_2_0= ruleGXorOperator ) ) ( (lv_rightOperand_3_0= ruleGAndExpression ) ) )* )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:306:5: this_GAndExpression_0= ruleGAndExpression ( () ( (lv_operator_2_0= ruleGXorOperator ) ) ( (lv_rightOperand_3_0= ruleGAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getGXorExpressionAccess().getGAndExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleGAndExpression_in_ruleGXorExpression629);
            this_GAndExpression_0=ruleGAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_GAndExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:314:1: ( () ( (lv_operator_2_0= ruleGXorOperator ) ) ( (lv_rightOperand_3_0= ruleGAndExpression ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==25) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:314:2: () ( (lv_operator_2_0= ruleGXorOperator ) ) ( (lv_rightOperand_3_0= ruleGAndExpression ) )
            	    {
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:314:2: ()
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:315:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getGXorExpressionAccess().getGXorExpressionLeftOperandAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:320:2: ( (lv_operator_2_0= ruleGXorOperator ) )
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:321:1: (lv_operator_2_0= ruleGXorOperator )
            	    {
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:321:1: (lv_operator_2_0= ruleGXorOperator )
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:322:3: lv_operator_2_0= ruleGXorOperator
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getGXorExpressionAccess().getOperatorGXorOperatorEnumRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleGXorOperator_in_ruleGXorExpression659);
            	    lv_operator_2_0=ruleGXorOperator();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getGXorExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"operator",
            	              		lv_operator_2_0, 
            	              		"GXorOperator");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:338:2: ( (lv_rightOperand_3_0= ruleGAndExpression ) )
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:339:1: (lv_rightOperand_3_0= ruleGAndExpression )
            	    {
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:339:1: (lv_rightOperand_3_0= ruleGAndExpression )
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:340:3: lv_rightOperand_3_0= ruleGAndExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getGXorExpressionAccess().getRightOperandGAndExpressionParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleGAndExpression_in_ruleGXorExpression680);
            	    lv_rightOperand_3_0=ruleGAndExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getGXorExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"rightOperand",
            	              		lv_rightOperand_3_0, 
            	              		"GAndExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGXorExpression"


    // $ANTLR start "entryRuleGAndExpression"
    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:364:1: entryRuleGAndExpression returns [EObject current=null] : iv_ruleGAndExpression= ruleGAndExpression EOF ;
    public final EObject entryRuleGAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGAndExpression = null;


        try {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:365:2: (iv_ruleGAndExpression= ruleGAndExpression EOF )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:366:2: iv_ruleGAndExpression= ruleGAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGAndExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleGAndExpression_in_entryRuleGAndExpression718);
            iv_ruleGAndExpression=ruleGAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGAndExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleGAndExpression728); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGAndExpression"


    // $ANTLR start "ruleGAndExpression"
    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:373:1: ruleGAndExpression returns [EObject current=null] : (this_GEqualityExpression_0= ruleGEqualityExpression ( () ( (lv_operator_2_0= ruleGAndOperator ) ) ( (lv_rightOperand_3_0= ruleGEqualityExpression ) ) )* ) ;
    public final EObject ruleGAndExpression() throws RecognitionException {
        EObject current = null;

        EObject this_GEqualityExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:376:28: ( (this_GEqualityExpression_0= ruleGEqualityExpression ( () ( (lv_operator_2_0= ruleGAndOperator ) ) ( (lv_rightOperand_3_0= ruleGEqualityExpression ) ) )* ) )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:377:1: (this_GEqualityExpression_0= ruleGEqualityExpression ( () ( (lv_operator_2_0= ruleGAndOperator ) ) ( (lv_rightOperand_3_0= ruleGEqualityExpression ) ) )* )
            {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:377:1: (this_GEqualityExpression_0= ruleGEqualityExpression ( () ( (lv_operator_2_0= ruleGAndOperator ) ) ( (lv_rightOperand_3_0= ruleGEqualityExpression ) ) )* )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:378:5: this_GEqualityExpression_0= ruleGEqualityExpression ( () ( (lv_operator_2_0= ruleGAndOperator ) ) ( (lv_rightOperand_3_0= ruleGEqualityExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getGAndExpressionAccess().getGEqualityExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleGEqualityExpression_in_ruleGAndExpression775);
            this_GEqualityExpression_0=ruleGEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_GEqualityExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:386:1: ( () ( (lv_operator_2_0= ruleGAndOperator ) ) ( (lv_rightOperand_3_0= ruleGEqualityExpression ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==24) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:386:2: () ( (lv_operator_2_0= ruleGAndOperator ) ) ( (lv_rightOperand_3_0= ruleGEqualityExpression ) )
            	    {
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:386:2: ()
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:387:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getGAndExpressionAccess().getGAndExpressionLeftOperandAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:392:2: ( (lv_operator_2_0= ruleGAndOperator ) )
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:393:1: (lv_operator_2_0= ruleGAndOperator )
            	    {
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:393:1: (lv_operator_2_0= ruleGAndOperator )
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:394:3: lv_operator_2_0= ruleGAndOperator
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getGAndExpressionAccess().getOperatorGAndOperatorEnumRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleGAndOperator_in_ruleGAndExpression805);
            	    lv_operator_2_0=ruleGAndOperator();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getGAndExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"operator",
            	              		lv_operator_2_0, 
            	              		"GAndOperator");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:410:2: ( (lv_rightOperand_3_0= ruleGEqualityExpression ) )
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:411:1: (lv_rightOperand_3_0= ruleGEqualityExpression )
            	    {
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:411:1: (lv_rightOperand_3_0= ruleGEqualityExpression )
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:412:3: lv_rightOperand_3_0= ruleGEqualityExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getGAndExpressionAccess().getRightOperandGEqualityExpressionParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleGEqualityExpression_in_ruleGAndExpression826);
            	    lv_rightOperand_3_0=ruleGEqualityExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getGAndExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"rightOperand",
            	              		lv_rightOperand_3_0, 
            	              		"GEqualityExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGAndExpression"


    // $ANTLR start "entryRuleGEqualityExpression"
    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:436:1: entryRuleGEqualityExpression returns [EObject current=null] : iv_ruleGEqualityExpression= ruleGEqualityExpression EOF ;
    public final EObject entryRuleGEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGEqualityExpression = null;


        try {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:437:2: (iv_ruleGEqualityExpression= ruleGEqualityExpression EOF )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:438:2: iv_ruleGEqualityExpression= ruleGEqualityExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGEqualityExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleGEqualityExpression_in_entryRuleGEqualityExpression864);
            iv_ruleGEqualityExpression=ruleGEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGEqualityExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleGEqualityExpression874); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGEqualityExpression"


    // $ANTLR start "ruleGEqualityExpression"
    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:445:1: ruleGEqualityExpression returns [EObject current=null] : (this_GRelationExpression_0= ruleGRelationExpression ( () ( (lv_operator_2_0= ruleGEqualityOperator ) ) ( (lv_rightOperand_3_0= ruleGRelationExpression ) ) )* ) ;
    public final EObject ruleGEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject this_GRelationExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:448:28: ( (this_GRelationExpression_0= ruleGRelationExpression ( () ( (lv_operator_2_0= ruleGEqualityOperator ) ) ( (lv_rightOperand_3_0= ruleGRelationExpression ) ) )* ) )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:449:1: (this_GRelationExpression_0= ruleGRelationExpression ( () ( (lv_operator_2_0= ruleGEqualityOperator ) ) ( (lv_rightOperand_3_0= ruleGRelationExpression ) ) )* )
            {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:449:1: (this_GRelationExpression_0= ruleGRelationExpression ( () ( (lv_operator_2_0= ruleGEqualityOperator ) ) ( (lv_rightOperand_3_0= ruleGRelationExpression ) ) )* )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:450:5: this_GRelationExpression_0= ruleGRelationExpression ( () ( (lv_operator_2_0= ruleGEqualityOperator ) ) ( (lv_rightOperand_3_0= ruleGRelationExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getGEqualityExpressionAccess().getGRelationExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleGRelationExpression_in_ruleGEqualityExpression921);
            this_GRelationExpression_0=ruleGRelationExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_GRelationExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:458:1: ( () ( (lv_operator_2_0= ruleGEqualityOperator ) ) ( (lv_rightOperand_3_0= ruleGRelationExpression ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>=27 && LA8_0<=28)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:458:2: () ( (lv_operator_2_0= ruleGEqualityOperator ) ) ( (lv_rightOperand_3_0= ruleGRelationExpression ) )
            	    {
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:458:2: ()
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:459:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getGEqualityExpressionAccess().getGEqualityExpressionLeftOperandAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:464:2: ( (lv_operator_2_0= ruleGEqualityOperator ) )
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:465:1: (lv_operator_2_0= ruleGEqualityOperator )
            	    {
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:465:1: (lv_operator_2_0= ruleGEqualityOperator )
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:466:3: lv_operator_2_0= ruleGEqualityOperator
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getGEqualityExpressionAccess().getOperatorGEqualityOperatorEnumRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleGEqualityOperator_in_ruleGEqualityExpression951);
            	    lv_operator_2_0=ruleGEqualityOperator();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getGEqualityExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"operator",
            	              		lv_operator_2_0, 
            	              		"GEqualityOperator");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:482:2: ( (lv_rightOperand_3_0= ruleGRelationExpression ) )
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:483:1: (lv_rightOperand_3_0= ruleGRelationExpression )
            	    {
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:483:1: (lv_rightOperand_3_0= ruleGRelationExpression )
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:484:3: lv_rightOperand_3_0= ruleGRelationExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getGEqualityExpressionAccess().getRightOperandGRelationExpressionParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleGRelationExpression_in_ruleGEqualityExpression972);
            	    lv_rightOperand_3_0=ruleGRelationExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getGEqualityExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"rightOperand",
            	              		lv_rightOperand_3_0, 
            	              		"GRelationExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGEqualityExpression"


    // $ANTLR start "entryRuleGRelationExpression"
    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:508:1: entryRuleGRelationExpression returns [EObject current=null] : iv_ruleGRelationExpression= ruleGRelationExpression EOF ;
    public final EObject entryRuleGRelationExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGRelationExpression = null;


        try {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:509:2: (iv_ruleGRelationExpression= ruleGRelationExpression EOF )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:510:2: iv_ruleGRelationExpression= ruleGRelationExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGRelationExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleGRelationExpression_in_entryRuleGRelationExpression1010);
            iv_ruleGRelationExpression=ruleGRelationExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGRelationExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleGRelationExpression1020); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGRelationExpression"


    // $ANTLR start "ruleGRelationExpression"
    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:517:1: ruleGRelationExpression returns [EObject current=null] : (this_GAdditionExpression_0= ruleGAdditionExpression ( () ( (lv_operator_2_0= ruleGRelationOperator ) ) ( (lv_rightOperand_3_0= ruleGAdditionExpression ) ) )* ) ;
    public final EObject ruleGRelationExpression() throws RecognitionException {
        EObject current = null;

        EObject this_GAdditionExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:520:28: ( (this_GAdditionExpression_0= ruleGAdditionExpression ( () ( (lv_operator_2_0= ruleGRelationOperator ) ) ( (lv_rightOperand_3_0= ruleGAdditionExpression ) ) )* ) )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:521:1: (this_GAdditionExpression_0= ruleGAdditionExpression ( () ( (lv_operator_2_0= ruleGRelationOperator ) ) ( (lv_rightOperand_3_0= ruleGAdditionExpression ) ) )* )
            {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:521:1: (this_GAdditionExpression_0= ruleGAdditionExpression ( () ( (lv_operator_2_0= ruleGRelationOperator ) ) ( (lv_rightOperand_3_0= ruleGAdditionExpression ) ) )* )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:522:5: this_GAdditionExpression_0= ruleGAdditionExpression ( () ( (lv_operator_2_0= ruleGRelationOperator ) ) ( (lv_rightOperand_3_0= ruleGAdditionExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getGRelationExpressionAccess().getGAdditionExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleGAdditionExpression_in_ruleGRelationExpression1067);
            this_GAdditionExpression_0=ruleGAdditionExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_GAdditionExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:530:1: ( () ( (lv_operator_2_0= ruleGRelationOperator ) ) ( (lv_rightOperand_3_0= ruleGAdditionExpression ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>=29 && LA9_0<=32)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:530:2: () ( (lv_operator_2_0= ruleGRelationOperator ) ) ( (lv_rightOperand_3_0= ruleGAdditionExpression ) )
            	    {
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:530:2: ()
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:531:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getGRelationExpressionAccess().getGRelationExpressionLeftOperandAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:536:2: ( (lv_operator_2_0= ruleGRelationOperator ) )
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:537:1: (lv_operator_2_0= ruleGRelationOperator )
            	    {
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:537:1: (lv_operator_2_0= ruleGRelationOperator )
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:538:3: lv_operator_2_0= ruleGRelationOperator
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getGRelationExpressionAccess().getOperatorGRelationOperatorEnumRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleGRelationOperator_in_ruleGRelationExpression1097);
            	    lv_operator_2_0=ruleGRelationOperator();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getGRelationExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"operator",
            	              		lv_operator_2_0, 
            	              		"GRelationOperator");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:554:2: ( (lv_rightOperand_3_0= ruleGAdditionExpression ) )
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:555:1: (lv_rightOperand_3_0= ruleGAdditionExpression )
            	    {
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:555:1: (lv_rightOperand_3_0= ruleGAdditionExpression )
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:556:3: lv_rightOperand_3_0= ruleGAdditionExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getGRelationExpressionAccess().getRightOperandGAdditionExpressionParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleGAdditionExpression_in_ruleGRelationExpression1118);
            	    lv_rightOperand_3_0=ruleGAdditionExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getGRelationExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"rightOperand",
            	              		lv_rightOperand_3_0, 
            	              		"GAdditionExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGRelationExpression"


    // $ANTLR start "entryRuleGAdditionExpression"
    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:580:1: entryRuleGAdditionExpression returns [EObject current=null] : iv_ruleGAdditionExpression= ruleGAdditionExpression EOF ;
    public final EObject entryRuleGAdditionExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGAdditionExpression = null;


        try {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:581:2: (iv_ruleGAdditionExpression= ruleGAdditionExpression EOF )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:582:2: iv_ruleGAdditionExpression= ruleGAdditionExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGAdditionExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleGAdditionExpression_in_entryRuleGAdditionExpression1156);
            iv_ruleGAdditionExpression=ruleGAdditionExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGAdditionExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleGAdditionExpression1166); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGAdditionExpression"


    // $ANTLR start "ruleGAdditionExpression"
    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:589:1: ruleGAdditionExpression returns [EObject current=null] : (this_GMultiplicationExpression_0= ruleGMultiplicationExpression ( () ( (lv_operator_2_0= ruleGAdditionOperator ) ) ( (lv_rightOperand_3_0= ruleGMultiplicationExpression ) ) )* ) ;
    public final EObject ruleGAdditionExpression() throws RecognitionException {
        EObject current = null;

        EObject this_GMultiplicationExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:592:28: ( (this_GMultiplicationExpression_0= ruleGMultiplicationExpression ( () ( (lv_operator_2_0= ruleGAdditionOperator ) ) ( (lv_rightOperand_3_0= ruleGMultiplicationExpression ) ) )* ) )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:593:1: (this_GMultiplicationExpression_0= ruleGMultiplicationExpression ( () ( (lv_operator_2_0= ruleGAdditionOperator ) ) ( (lv_rightOperand_3_0= ruleGMultiplicationExpression ) ) )* )
            {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:593:1: (this_GMultiplicationExpression_0= ruleGMultiplicationExpression ( () ( (lv_operator_2_0= ruleGAdditionOperator ) ) ( (lv_rightOperand_3_0= ruleGMultiplicationExpression ) ) )* )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:594:5: this_GMultiplicationExpression_0= ruleGMultiplicationExpression ( () ( (lv_operator_2_0= ruleGAdditionOperator ) ) ( (lv_rightOperand_3_0= ruleGMultiplicationExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getGAdditionExpressionAccess().getGMultiplicationExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleGMultiplicationExpression_in_ruleGAdditionExpression1213);
            this_GMultiplicationExpression_0=ruleGMultiplicationExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_GMultiplicationExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:602:1: ( () ( (lv_operator_2_0= ruleGAdditionOperator ) ) ( (lv_rightOperand_3_0= ruleGMultiplicationExpression ) ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>=33 && LA10_0<=34)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:602:2: () ( (lv_operator_2_0= ruleGAdditionOperator ) ) ( (lv_rightOperand_3_0= ruleGMultiplicationExpression ) )
            	    {
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:602:2: ()
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:603:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getGAdditionExpressionAccess().getGAdditionExpressionLeftOperandAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:608:2: ( (lv_operator_2_0= ruleGAdditionOperator ) )
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:609:1: (lv_operator_2_0= ruleGAdditionOperator )
            	    {
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:609:1: (lv_operator_2_0= ruleGAdditionOperator )
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:610:3: lv_operator_2_0= ruleGAdditionOperator
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getGAdditionExpressionAccess().getOperatorGAdditionOperatorEnumRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleGAdditionOperator_in_ruleGAdditionExpression1243);
            	    lv_operator_2_0=ruleGAdditionOperator();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getGAdditionExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"operator",
            	              		lv_operator_2_0, 
            	              		"GAdditionOperator");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:626:2: ( (lv_rightOperand_3_0= ruleGMultiplicationExpression ) )
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:627:1: (lv_rightOperand_3_0= ruleGMultiplicationExpression )
            	    {
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:627:1: (lv_rightOperand_3_0= ruleGMultiplicationExpression )
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:628:3: lv_rightOperand_3_0= ruleGMultiplicationExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getGAdditionExpressionAccess().getRightOperandGMultiplicationExpressionParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleGMultiplicationExpression_in_ruleGAdditionExpression1264);
            	    lv_rightOperand_3_0=ruleGMultiplicationExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getGAdditionExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"rightOperand",
            	              		lv_rightOperand_3_0, 
            	              		"GMultiplicationExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGAdditionExpression"


    // $ANTLR start "entryRuleGMultiplicationExpression"
    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:652:1: entryRuleGMultiplicationExpression returns [EObject current=null] : iv_ruleGMultiplicationExpression= ruleGMultiplicationExpression EOF ;
    public final EObject entryRuleGMultiplicationExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGMultiplicationExpression = null;


        try {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:653:2: (iv_ruleGMultiplicationExpression= ruleGMultiplicationExpression EOF )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:654:2: iv_ruleGMultiplicationExpression= ruleGMultiplicationExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGMultiplicationExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleGMultiplicationExpression_in_entryRuleGMultiplicationExpression1302);
            iv_ruleGMultiplicationExpression=ruleGMultiplicationExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGMultiplicationExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleGMultiplicationExpression1312); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGMultiplicationExpression"


    // $ANTLR start "ruleGMultiplicationExpression"
    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:661:1: ruleGMultiplicationExpression returns [EObject current=null] : (this_GNegationExpression_0= ruleGNegationExpression ( () ( (lv_operator_2_0= ruleGMultiplicationOperator ) ) ( (lv_rightOperand_3_0= ruleGNegationExpression ) ) )* ) ;
    public final EObject ruleGMultiplicationExpression() throws RecognitionException {
        EObject current = null;

        EObject this_GNegationExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:664:28: ( (this_GNegationExpression_0= ruleGNegationExpression ( () ( (lv_operator_2_0= ruleGMultiplicationOperator ) ) ( (lv_rightOperand_3_0= ruleGNegationExpression ) ) )* ) )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:665:1: (this_GNegationExpression_0= ruleGNegationExpression ( () ( (lv_operator_2_0= ruleGMultiplicationOperator ) ) ( (lv_rightOperand_3_0= ruleGNegationExpression ) ) )* )
            {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:665:1: (this_GNegationExpression_0= ruleGNegationExpression ( () ( (lv_operator_2_0= ruleGMultiplicationOperator ) ) ( (lv_rightOperand_3_0= ruleGNegationExpression ) ) )* )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:666:5: this_GNegationExpression_0= ruleGNegationExpression ( () ( (lv_operator_2_0= ruleGMultiplicationOperator ) ) ( (lv_rightOperand_3_0= ruleGNegationExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getGMultiplicationExpressionAccess().getGNegationExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleGNegationExpression_in_ruleGMultiplicationExpression1359);
            this_GNegationExpression_0=ruleGNegationExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_GNegationExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:674:1: ( () ( (lv_operator_2_0= ruleGMultiplicationOperator ) ) ( (lv_rightOperand_3_0= ruleGNegationExpression ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>=35 && LA11_0<=36)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:674:2: () ( (lv_operator_2_0= ruleGMultiplicationOperator ) ) ( (lv_rightOperand_3_0= ruleGNegationExpression ) )
            	    {
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:674:2: ()
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:675:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getGMultiplicationExpressionAccess().getGMultiplicationExpressionLeftOperandAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:680:2: ( (lv_operator_2_0= ruleGMultiplicationOperator ) )
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:681:1: (lv_operator_2_0= ruleGMultiplicationOperator )
            	    {
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:681:1: (lv_operator_2_0= ruleGMultiplicationOperator )
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:682:3: lv_operator_2_0= ruleGMultiplicationOperator
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getGMultiplicationExpressionAccess().getOperatorGMultiplicationOperatorEnumRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleGMultiplicationOperator_in_ruleGMultiplicationExpression1389);
            	    lv_operator_2_0=ruleGMultiplicationOperator();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getGMultiplicationExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"operator",
            	              		lv_operator_2_0, 
            	              		"GMultiplicationOperator");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:698:2: ( (lv_rightOperand_3_0= ruleGNegationExpression ) )
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:699:1: (lv_rightOperand_3_0= ruleGNegationExpression )
            	    {
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:699:1: (lv_rightOperand_3_0= ruleGNegationExpression )
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:700:3: lv_rightOperand_3_0= ruleGNegationExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getGMultiplicationExpressionAccess().getRightOperandGNegationExpressionParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleGNegationExpression_in_ruleGMultiplicationExpression1410);
            	    lv_rightOperand_3_0=ruleGNegationExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getGMultiplicationExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"rightOperand",
            	              		lv_rightOperand_3_0, 
            	              		"GNegationExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGMultiplicationExpression"


    // $ANTLR start "entryRuleGNegationExpression"
    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:724:1: entryRuleGNegationExpression returns [EObject current=null] : iv_ruleGNegationExpression= ruleGNegationExpression EOF ;
    public final EObject entryRuleGNegationExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGNegationExpression = null;


        try {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:725:2: (iv_ruleGNegationExpression= ruleGNegationExpression EOF )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:726:2: iv_ruleGNegationExpression= ruleGNegationExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGNegationExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleGNegationExpression_in_entryRuleGNegationExpression1448);
            iv_ruleGNegationExpression=ruleGNegationExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGNegationExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleGNegationExpression1458); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGNegationExpression"


    // $ANTLR start "ruleGNegationExpression"
    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:733:1: ruleGNegationExpression returns [EObject current=null] : (this_GNavigationExpression_0= ruleGNavigationExpression | ( () ( (lv_operator_2_0= ruleGNegationOperator ) ) ( (lv_operand_3_0= ruleGNavigationExpression ) ) ) ) ;
    public final EObject ruleGNegationExpression() throws RecognitionException {
        EObject current = null;

        EObject this_GNavigationExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_operand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:736:28: ( (this_GNavigationExpression_0= ruleGNavigationExpression | ( () ( (lv_operator_2_0= ruleGNegationOperator ) ) ( (lv_operand_3_0= ruleGNavigationExpression ) ) ) ) )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:737:1: (this_GNavigationExpression_0= ruleGNavigationExpression | ( () ( (lv_operator_2_0= ruleGNegationOperator ) ) ( (lv_operand_3_0= ruleGNavigationExpression ) ) ) )
            {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:737:1: (this_GNavigationExpression_0= ruleGNavigationExpression | ( () ( (lv_operator_2_0= ruleGNegationOperator ) ) ( (lv_operand_3_0= ruleGNavigationExpression ) ) ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( ((LA12_0>=RULE_STRING && LA12_0<=RULE_DOUBLE)||(LA12_0>=15 && LA12_0<=16)||LA12_0==20) ) {
                alt12=1;
            }
            else if ( ((LA12_0>=37 && LA12_0<=38)) ) {
                alt12=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:738:5: this_GNavigationExpression_0= ruleGNavigationExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getGNegationExpressionAccess().getGNavigationExpressionParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleGNavigationExpression_in_ruleGNegationExpression1505);
                    this_GNavigationExpression_0=ruleGNavigationExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_GNavigationExpression_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:747:6: ( () ( (lv_operator_2_0= ruleGNegationOperator ) ) ( (lv_operand_3_0= ruleGNavigationExpression ) ) )
                    {
                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:747:6: ( () ( (lv_operator_2_0= ruleGNegationOperator ) ) ( (lv_operand_3_0= ruleGNavigationExpression ) ) )
                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:747:7: () ( (lv_operator_2_0= ruleGNegationOperator ) ) ( (lv_operand_3_0= ruleGNavigationExpression ) )
                    {
                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:747:7: ()
                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:748:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getGNegationExpressionAccess().getGNegationExpressionAction_1_0(),
                                  current);
                          
                    }

                    }

                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:753:2: ( (lv_operator_2_0= ruleGNegationOperator ) )
                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:754:1: (lv_operator_2_0= ruleGNegationOperator )
                    {
                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:754:1: (lv_operator_2_0= ruleGNegationOperator )
                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:755:3: lv_operator_2_0= ruleGNegationOperator
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getGNegationExpressionAccess().getOperatorGNegationOperatorEnumRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleGNegationOperator_in_ruleGNegationExpression1541);
                    lv_operator_2_0=ruleGNegationOperator();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getGNegationExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"operator",
                              		lv_operator_2_0, 
                              		"GNegationOperator");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:771:2: ( (lv_operand_3_0= ruleGNavigationExpression ) )
                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:772:1: (lv_operand_3_0= ruleGNavigationExpression )
                    {
                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:772:1: (lv_operand_3_0= ruleGNavigationExpression )
                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:773:3: lv_operand_3_0= ruleGNavigationExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getGNegationExpressionAccess().getOperandGNavigationExpressionParserRuleCall_1_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleGNavigationExpression_in_ruleGNegationExpression1562);
                    lv_operand_3_0=ruleGNavigationExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getGNegationExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"operand",
                              		lv_operand_3_0, 
                              		"GNavigationExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGNegationExpression"


    // $ANTLR start "entryRuleGNavigationExpression"
    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:797:1: entryRuleGNavigationExpression returns [EObject current=null] : iv_ruleGNavigationExpression= ruleGNavigationExpression EOF ;
    public final EObject entryRuleGNavigationExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGNavigationExpression = null;


        try {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:798:2: (iv_ruleGNavigationExpression= ruleGNavigationExpression EOF )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:799:2: iv_ruleGNavigationExpression= ruleGNavigationExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGNavigationExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleGNavigationExpression_in_entryRuleGNavigationExpression1599);
            iv_ruleGNavigationExpression=ruleGNavigationExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGNavigationExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleGNavigationExpression1609); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGNavigationExpression"


    // $ANTLR start "ruleGNavigationExpression"
    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:806:1: ruleGNavigationExpression returns [EObject current=null] : (this_GReferenceExpression_0= ruleGReferenceExpression ( () ruleNavigationOperator ( (otherlv_3= RULE_ID ) ) )* ) ;
    public final EObject ruleGNavigationExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_3=null;
        EObject this_GReferenceExpression_0 = null;


         enterRule(); 
            
        try {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:809:28: ( (this_GReferenceExpression_0= ruleGReferenceExpression ( () ruleNavigationOperator ( (otherlv_3= RULE_ID ) ) )* ) )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:810:1: (this_GReferenceExpression_0= ruleGReferenceExpression ( () ruleNavigationOperator ( (otherlv_3= RULE_ID ) ) )* )
            {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:810:1: (this_GReferenceExpression_0= ruleGReferenceExpression ( () ruleNavigationOperator ( (otherlv_3= RULE_ID ) ) )* )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:811:5: this_GReferenceExpression_0= ruleGReferenceExpression ( () ruleNavigationOperator ( (otherlv_3= RULE_ID ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getGNavigationExpressionAccess().getGReferenceExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleGReferenceExpression_in_ruleGNavigationExpression1656);
            this_GReferenceExpression_0=ruleGReferenceExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_GReferenceExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:819:1: ( () ruleNavigationOperator ( (otherlv_3= RULE_ID ) ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>=22 && LA13_0<=23)) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:819:2: () ruleNavigationOperator ( (otherlv_3= RULE_ID ) )
            	    {
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:819:2: ()
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:820:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getGNavigationExpressionAccess().getGNavigationExpressionBodyAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getGNavigationExpressionAccess().getNavigationOperatorParserRuleCall_1_1()); 
            	          
            	    }
            	    pushFollow(FOLLOW_ruleNavigationOperator_in_ruleGNavigationExpression1681);
            	    ruleNavigationOperator();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	              afterParserOrEnumRuleCall();
            	          
            	    }
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:833:1: ( (otherlv_3= RULE_ID ) )
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:834:1: (otherlv_3= RULE_ID )
            	    {
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:834:1: (otherlv_3= RULE_ID )
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:835:3: otherlv_3= RULE_ID
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getGNavigationExpressionRule());
            	      	        }
            	              
            	    }
            	    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGNavigationExpression1700); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		newLeafNode(otherlv_3, grammarAccess.getGNavigationExpressionAccess().getReferencedEObjectEObjectCrossReference_1_2_0()); 
            	      	
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGNavigationExpression"


    // $ANTLR start "entryRuleGReferenceExpression"
    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:854:1: entryRuleGReferenceExpression returns [EObject current=null] : iv_ruleGReferenceExpression= ruleGReferenceExpression EOF ;
    public final EObject entryRuleGReferenceExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGReferenceExpression = null;


        try {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:855:2: (iv_ruleGReferenceExpression= ruleGReferenceExpression EOF )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:856:2: iv_ruleGReferenceExpression= ruleGReferenceExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGReferenceExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleGReferenceExpression_in_entryRuleGReferenceExpression1738);
            iv_ruleGReferenceExpression=ruleGReferenceExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGReferenceExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleGReferenceExpression1748); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGReferenceExpression"


    // $ANTLR start "ruleGReferenceExpression"
    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:863:1: ruleGReferenceExpression returns [EObject current=null] : (this_GPrimaryExpression_0= ruleGPrimaryExpression | ( () ( (otherlv_2= RULE_ID ) ) ) ) ;
    public final EObject ruleGReferenceExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_GPrimaryExpression_0 = null;


         enterRule(); 
            
        try {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:866:28: ( (this_GPrimaryExpression_0= ruleGPrimaryExpression | ( () ( (otherlv_2= RULE_ID ) ) ) ) )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:867:1: (this_GPrimaryExpression_0= ruleGPrimaryExpression | ( () ( (otherlv_2= RULE_ID ) ) ) )
            {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:867:1: (this_GPrimaryExpression_0= ruleGPrimaryExpression | ( () ( (otherlv_2= RULE_ID ) ) ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_STRING||(LA14_0>=RULE_BOOLEAN && LA14_0<=RULE_DOUBLE)||(LA14_0>=15 && LA14_0<=16)||LA14_0==20) ) {
                alt14=1;
            }
            else if ( (LA14_0==RULE_ID) ) {
                alt14=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:868:5: this_GPrimaryExpression_0= ruleGPrimaryExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getGReferenceExpressionAccess().getGPrimaryExpressionParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleGPrimaryExpression_in_ruleGReferenceExpression1795);
                    this_GPrimaryExpression_0=ruleGPrimaryExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_GPrimaryExpression_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:877:6: ( () ( (otherlv_2= RULE_ID ) ) )
                    {
                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:877:6: ( () ( (otherlv_2= RULE_ID ) ) )
                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:877:7: () ( (otherlv_2= RULE_ID ) )
                    {
                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:877:7: ()
                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:878:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getGReferenceExpressionAccess().getGReferenceExpressionAction_1_0(),
                                  current);
                          
                    }

                    }

                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:883:2: ( (otherlv_2= RULE_ID ) )
                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:884:1: (otherlv_2= RULE_ID )
                    {
                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:884:1: (otherlv_2= RULE_ID )
                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:885:3: otherlv_2= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getGReferenceExpressionRule());
                      	        }
                              
                    }
                    otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGReferenceExpression1830); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_2, grammarAccess.getGReferenceExpressionAccess().getReferencedEObjectEObjectCrossReference_1_1_0()); 
                      	
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGReferenceExpression"


    // $ANTLR start "entryRuleGPrimaryExpression"
    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:904:1: entryRuleGPrimaryExpression returns [EObject current=null] : iv_ruleGPrimaryExpression= ruleGPrimaryExpression EOF ;
    public final EObject entryRuleGPrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGPrimaryExpression = null;


        try {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:905:2: (iv_ruleGPrimaryExpression= ruleGPrimaryExpression EOF )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:906:2: iv_ruleGPrimaryExpression= ruleGPrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGPrimaryExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleGPrimaryExpression_in_entryRuleGPrimaryExpression1867);
            iv_ruleGPrimaryExpression=ruleGPrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGPrimaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleGPrimaryExpression1877); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGPrimaryExpression"


    // $ANTLR start "ruleGPrimaryExpression"
    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:913:1: ruleGPrimaryExpression returns [EObject current=null] : (this_GStringExpression_0= ruleGStringExpression | this_GBooleanExpression_1= ruleGBooleanExpression | this_GNumericExpression_2= ruleGNumericExpression | this_GEnumLiteralExpression_3= ruleGEnumLiteralExpression | this_GIfExpression_4= ruleGIfExpression | this_GBraceExpression_5= ruleGBraceExpression ) ;
    public final EObject ruleGPrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_GStringExpression_0 = null;

        EObject this_GBooleanExpression_1 = null;

        EObject this_GNumericExpression_2 = null;

        EObject this_GEnumLiteralExpression_3 = null;

        EObject this_GIfExpression_4 = null;

        EObject this_GBraceExpression_5 = null;


         enterRule(); 
            
        try {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:916:28: ( (this_GStringExpression_0= ruleGStringExpression | this_GBooleanExpression_1= ruleGBooleanExpression | this_GNumericExpression_2= ruleGNumericExpression | this_GEnumLiteralExpression_3= ruleGEnumLiteralExpression | this_GIfExpression_4= ruleGIfExpression | this_GBraceExpression_5= ruleGBraceExpression ) )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:917:1: (this_GStringExpression_0= ruleGStringExpression | this_GBooleanExpression_1= ruleGBooleanExpression | this_GNumericExpression_2= ruleGNumericExpression | this_GEnumLiteralExpression_3= ruleGEnumLiteralExpression | this_GIfExpression_4= ruleGIfExpression | this_GBraceExpression_5= ruleGBraceExpression )
            {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:917:1: (this_GStringExpression_0= ruleGStringExpression | this_GBooleanExpression_1= ruleGBooleanExpression | this_GNumericExpression_2= ruleGNumericExpression | this_GEnumLiteralExpression_3= ruleGEnumLiteralExpression | this_GIfExpression_4= ruleGIfExpression | this_GBraceExpression_5= ruleGBraceExpression )
            int alt15=6;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt15=1;
                }
                break;
            case RULE_BOOLEAN:
                {
                alt15=2;
                }
                break;
            case RULE_INT:
            case RULE_DOUBLE:
                {
                alt15=3;
                }
                break;
            case 15:
                {
                alt15=4;
                }
                break;
            case 16:
                {
                alt15=5;
                }
                break;
            case 20:
                {
                alt15=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:918:5: this_GStringExpression_0= ruleGStringExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getGPrimaryExpressionAccess().getGStringExpressionParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleGStringExpression_in_ruleGPrimaryExpression1924);
                    this_GStringExpression_0=ruleGStringExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_GStringExpression_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:928:5: this_GBooleanExpression_1= ruleGBooleanExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getGPrimaryExpressionAccess().getGBooleanExpressionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleGBooleanExpression_in_ruleGPrimaryExpression1951);
                    this_GBooleanExpression_1=ruleGBooleanExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_GBooleanExpression_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:938:5: this_GNumericExpression_2= ruleGNumericExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getGPrimaryExpressionAccess().getGNumericExpressionParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleGNumericExpression_in_ruleGPrimaryExpression1978);
                    this_GNumericExpression_2=ruleGNumericExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_GNumericExpression_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:948:5: this_GEnumLiteralExpression_3= ruleGEnumLiteralExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getGPrimaryExpressionAccess().getGEnumLiteralExpressionParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleGEnumLiteralExpression_in_ruleGPrimaryExpression2005);
                    this_GEnumLiteralExpression_3=ruleGEnumLiteralExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_GEnumLiteralExpression_3; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 5 :
                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:958:5: this_GIfExpression_4= ruleGIfExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getGPrimaryExpressionAccess().getGIfExpressionParserRuleCall_4()); 
                          
                    }
                    pushFollow(FOLLOW_ruleGIfExpression_in_ruleGPrimaryExpression2032);
                    this_GIfExpression_4=ruleGIfExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_GIfExpression_4; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 6 :
                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:968:5: this_GBraceExpression_5= ruleGBraceExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getGPrimaryExpressionAccess().getGBraceExpressionParserRuleCall_5()); 
                          
                    }
                    pushFollow(FOLLOW_ruleGBraceExpression_in_ruleGPrimaryExpression2059);
                    this_GBraceExpression_5=ruleGBraceExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_GBraceExpression_5; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGPrimaryExpression"


    // $ANTLR start "entryRuleGStringExpression"
    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:984:1: entryRuleGStringExpression returns [EObject current=null] : iv_ruleGStringExpression= ruleGStringExpression EOF ;
    public final EObject entryRuleGStringExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGStringExpression = null;


        try {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:985:2: (iv_ruleGStringExpression= ruleGStringExpression EOF )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:986:2: iv_ruleGStringExpression= ruleGStringExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGStringExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleGStringExpression_in_entryRuleGStringExpression2094);
            iv_ruleGStringExpression=ruleGStringExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGStringExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleGStringExpression2104); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGStringExpression"


    // $ANTLR start "ruleGStringExpression"
    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:993:1: ruleGStringExpression returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleGStringExpression() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:996:28: ( ( () ( (lv_value_1_0= RULE_STRING ) ) ) )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:997:1: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:997:1: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:997:2: () ( (lv_value_1_0= RULE_STRING ) )
            {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:997:2: ()
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:998:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getGStringExpressionAccess().getGStringExpressionAction_0(),
                          current);
                  
            }

            }

            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1003:2: ( (lv_value_1_0= RULE_STRING ) )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1004:1: (lv_value_1_0= RULE_STRING )
            {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1004:1: (lv_value_1_0= RULE_STRING )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1005:3: lv_value_1_0= RULE_STRING
            {
            lv_value_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleGStringExpression2155); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_value_1_0, grammarAccess.getGStringExpressionAccess().getValueSTRINGTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getGStringExpressionRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"value",
                      		lv_value_1_0, 
                      		"STRING");
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGStringExpression"


    // $ANTLR start "entryRuleGBooleanExpression"
    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1029:1: entryRuleGBooleanExpression returns [EObject current=null] : iv_ruleGBooleanExpression= ruleGBooleanExpression EOF ;
    public final EObject entryRuleGBooleanExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGBooleanExpression = null;


        try {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1030:2: (iv_ruleGBooleanExpression= ruleGBooleanExpression EOF )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1031:2: iv_ruleGBooleanExpression= ruleGBooleanExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGBooleanExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleGBooleanExpression_in_entryRuleGBooleanExpression2196);
            iv_ruleGBooleanExpression=ruleGBooleanExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGBooleanExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleGBooleanExpression2206); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGBooleanExpression"


    // $ANTLR start "ruleGBooleanExpression"
    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1038:1: ruleGBooleanExpression returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_BOOLEAN ) ) ) ;
    public final EObject ruleGBooleanExpression() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1041:28: ( ( () ( (lv_value_1_0= RULE_BOOLEAN ) ) ) )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1042:1: ( () ( (lv_value_1_0= RULE_BOOLEAN ) ) )
            {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1042:1: ( () ( (lv_value_1_0= RULE_BOOLEAN ) ) )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1042:2: () ( (lv_value_1_0= RULE_BOOLEAN ) )
            {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1042:2: ()
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1043:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getGBooleanExpressionAccess().getGBooleanExpressionAction_0(),
                          current);
                  
            }

            }

            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1048:2: ( (lv_value_1_0= RULE_BOOLEAN ) )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1049:1: (lv_value_1_0= RULE_BOOLEAN )
            {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1049:1: (lv_value_1_0= RULE_BOOLEAN )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1050:3: lv_value_1_0= RULE_BOOLEAN
            {
            lv_value_1_0=(Token)match(input,RULE_BOOLEAN,FOLLOW_RULE_BOOLEAN_in_ruleGBooleanExpression2257); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_value_1_0, grammarAccess.getGBooleanExpressionAccess().getValueBOOLEANTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getGBooleanExpressionRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"value",
                      		lv_value_1_0, 
                      		"BOOLEAN");
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGBooleanExpression"


    // $ANTLR start "entryRuleGNumericExpression"
    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1074:1: entryRuleGNumericExpression returns [EObject current=null] : iv_ruleGNumericExpression= ruleGNumericExpression EOF ;
    public final EObject entryRuleGNumericExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGNumericExpression = null;


        try {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1075:2: (iv_ruleGNumericExpression= ruleGNumericExpression EOF )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1076:2: iv_ruleGNumericExpression= ruleGNumericExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGNumericExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleGNumericExpression_in_entryRuleGNumericExpression2298);
            iv_ruleGNumericExpression=ruleGNumericExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGNumericExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleGNumericExpression2308); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGNumericExpression"


    // $ANTLR start "ruleGNumericExpression"
    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1083:1: ruleGNumericExpression returns [EObject current=null] : (this_GIntegerExpression_0= ruleGIntegerExpression | this_GDoubleExpression_1= ruleGDoubleExpression ) ;
    public final EObject ruleGNumericExpression() throws RecognitionException {
        EObject current = null;

        EObject this_GIntegerExpression_0 = null;

        EObject this_GDoubleExpression_1 = null;


         enterRule(); 
            
        try {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1086:28: ( (this_GIntegerExpression_0= ruleGIntegerExpression | this_GDoubleExpression_1= ruleGDoubleExpression ) )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1087:1: (this_GIntegerExpression_0= ruleGIntegerExpression | this_GDoubleExpression_1= ruleGDoubleExpression )
            {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1087:1: (this_GIntegerExpression_0= ruleGIntegerExpression | this_GDoubleExpression_1= ruleGDoubleExpression )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_INT) ) {
                alt16=1;
            }
            else if ( (LA16_0==RULE_DOUBLE) ) {
                alt16=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1088:5: this_GIntegerExpression_0= ruleGIntegerExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getGNumericExpressionAccess().getGIntegerExpressionParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleGIntegerExpression_in_ruleGNumericExpression2355);
                    this_GIntegerExpression_0=ruleGIntegerExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_GIntegerExpression_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1098:5: this_GDoubleExpression_1= ruleGDoubleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getGNumericExpressionAccess().getGDoubleExpressionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleGDoubleExpression_in_ruleGNumericExpression2382);
                    this_GDoubleExpression_1=ruleGDoubleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_GDoubleExpression_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGNumericExpression"


    // $ANTLR start "entryRuleGIntegerExpression"
    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1114:1: entryRuleGIntegerExpression returns [EObject current=null] : iv_ruleGIntegerExpression= ruleGIntegerExpression EOF ;
    public final EObject entryRuleGIntegerExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGIntegerExpression = null;


        try {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1115:2: (iv_ruleGIntegerExpression= ruleGIntegerExpression EOF )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1116:2: iv_ruleGIntegerExpression= ruleGIntegerExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGIntegerExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleGIntegerExpression_in_entryRuleGIntegerExpression2417);
            iv_ruleGIntegerExpression=ruleGIntegerExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGIntegerExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleGIntegerExpression2427); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGIntegerExpression"


    // $ANTLR start "ruleGIntegerExpression"
    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1123:1: ruleGIntegerExpression returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_INT ) ) ) ;
    public final EObject ruleGIntegerExpression() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1126:28: ( ( () ( (lv_value_1_0= RULE_INT ) ) ) )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1127:1: ( () ( (lv_value_1_0= RULE_INT ) ) )
            {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1127:1: ( () ( (lv_value_1_0= RULE_INT ) ) )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1127:2: () ( (lv_value_1_0= RULE_INT ) )
            {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1127:2: ()
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1128:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getGIntegerExpressionAccess().getGIntegerExpressionAction_0(),
                          current);
                  
            }

            }

            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1133:2: ( (lv_value_1_0= RULE_INT ) )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1134:1: (lv_value_1_0= RULE_INT )
            {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1134:1: (lv_value_1_0= RULE_INT )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1135:3: lv_value_1_0= RULE_INT
            {
            lv_value_1_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleGIntegerExpression2478); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_value_1_0, grammarAccess.getGIntegerExpressionAccess().getValueINTTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getGIntegerExpressionRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"value",
                      		lv_value_1_0, 
                      		"INT");
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGIntegerExpression"


    // $ANTLR start "entryRuleGDoubleExpression"
    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1159:1: entryRuleGDoubleExpression returns [EObject current=null] : iv_ruleGDoubleExpression= ruleGDoubleExpression EOF ;
    public final EObject entryRuleGDoubleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGDoubleExpression = null;


        try {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1160:2: (iv_ruleGDoubleExpression= ruleGDoubleExpression EOF )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1161:2: iv_ruleGDoubleExpression= ruleGDoubleExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGDoubleExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleGDoubleExpression_in_entryRuleGDoubleExpression2519);
            iv_ruleGDoubleExpression=ruleGDoubleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGDoubleExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleGDoubleExpression2529); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGDoubleExpression"


    // $ANTLR start "ruleGDoubleExpression"
    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1168:1: ruleGDoubleExpression returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_DOUBLE ) ) ) ;
    public final EObject ruleGDoubleExpression() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1171:28: ( ( () ( (lv_value_1_0= RULE_DOUBLE ) ) ) )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1172:1: ( () ( (lv_value_1_0= RULE_DOUBLE ) ) )
            {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1172:1: ( () ( (lv_value_1_0= RULE_DOUBLE ) ) )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1172:2: () ( (lv_value_1_0= RULE_DOUBLE ) )
            {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1172:2: ()
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1173:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getGDoubleExpressionAccess().getGDoubleExpressionAction_0(),
                          current);
                  
            }

            }

            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1178:2: ( (lv_value_1_0= RULE_DOUBLE ) )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1179:1: (lv_value_1_0= RULE_DOUBLE )
            {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1179:1: (lv_value_1_0= RULE_DOUBLE )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1180:3: lv_value_1_0= RULE_DOUBLE
            {
            lv_value_1_0=(Token)match(input,RULE_DOUBLE,FOLLOW_RULE_DOUBLE_in_ruleGDoubleExpression2580); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_value_1_0, grammarAccess.getGDoubleExpressionAccess().getValueDOUBLETerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getGDoubleExpressionRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"value",
                      		lv_value_1_0, 
                      		"DOUBLE");
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGDoubleExpression"


    // $ANTLR start "entryRuleGEnumLiteralExpression"
    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1204:1: entryRuleGEnumLiteralExpression returns [EObject current=null] : iv_ruleGEnumLiteralExpression= ruleGEnumLiteralExpression EOF ;
    public final EObject entryRuleGEnumLiteralExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGEnumLiteralExpression = null;


        try {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1205:2: (iv_ruleGEnumLiteralExpression= ruleGEnumLiteralExpression EOF )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1206:2: iv_ruleGEnumLiteralExpression= ruleGEnumLiteralExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGEnumLiteralExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleGEnumLiteralExpression_in_entryRuleGEnumLiteralExpression2621);
            iv_ruleGEnumLiteralExpression=ruleGEnumLiteralExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGEnumLiteralExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleGEnumLiteralExpression2631); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGEnumLiteralExpression"


    // $ANTLR start "ruleGEnumLiteralExpression"
    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1213:1: ruleGEnumLiteralExpression returns [EObject current=null] : ( () otherlv_1= '#' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleGEnumLiteralExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1216:28: ( ( () otherlv_1= '#' ( ( ruleQualifiedName ) ) ) )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1217:1: ( () otherlv_1= '#' ( ( ruleQualifiedName ) ) )
            {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1217:1: ( () otherlv_1= '#' ( ( ruleQualifiedName ) ) )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1217:2: () otherlv_1= '#' ( ( ruleQualifiedName ) )
            {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1217:2: ()
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1218:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getGEnumLiteralExpressionAccess().getGEnumLiteralExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,15,FOLLOW_15_in_ruleGEnumLiteralExpression2677); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getGEnumLiteralExpressionAccess().getNumberSignKeyword_1());
                  
            }
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1227:1: ( ( ruleQualifiedName ) )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1228:1: ( ruleQualifiedName )
            {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1228:1: ( ruleQualifiedName )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1229:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getGEnumLiteralExpressionRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getGEnumLiteralExpressionAccess().getValueEEnumLiteralCrossReference_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleGEnumLiteralExpression2700);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGEnumLiteralExpression"


    // $ANTLR start "entryRuleGIfExpression"
    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1250:1: entryRuleGIfExpression returns [EObject current=null] : iv_ruleGIfExpression= ruleGIfExpression EOF ;
    public final EObject entryRuleGIfExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGIfExpression = null;


        try {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1251:2: (iv_ruleGIfExpression= ruleGIfExpression EOF )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1252:2: iv_ruleGIfExpression= ruleGIfExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGIfExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleGIfExpression_in_entryRuleGIfExpression2736);
            iv_ruleGIfExpression=ruleGIfExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGIfExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleGIfExpression2746); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGIfExpression"


    // $ANTLR start "ruleGIfExpression"
    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1259:1: ruleGIfExpression returns [EObject current=null] : ( () otherlv_1= 'if' ( (lv_condition_2_0= ruleGExpression ) ) otherlv_3= 'then' ( (lv_thenExpression_4_0= ruleGExpression ) ) otherlv_5= 'else' ( (lv_elseExpression_6_0= ruleGExpression ) ) otherlv_7= 'endif' ) ;
    public final EObject ruleGIfExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_condition_2_0 = null;

        EObject lv_thenExpression_4_0 = null;

        EObject lv_elseExpression_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1262:28: ( ( () otherlv_1= 'if' ( (lv_condition_2_0= ruleGExpression ) ) otherlv_3= 'then' ( (lv_thenExpression_4_0= ruleGExpression ) ) otherlv_5= 'else' ( (lv_elseExpression_6_0= ruleGExpression ) ) otherlv_7= 'endif' ) )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1263:1: ( () otherlv_1= 'if' ( (lv_condition_2_0= ruleGExpression ) ) otherlv_3= 'then' ( (lv_thenExpression_4_0= ruleGExpression ) ) otherlv_5= 'else' ( (lv_elseExpression_6_0= ruleGExpression ) ) otherlv_7= 'endif' )
            {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1263:1: ( () otherlv_1= 'if' ( (lv_condition_2_0= ruleGExpression ) ) otherlv_3= 'then' ( (lv_thenExpression_4_0= ruleGExpression ) ) otherlv_5= 'else' ( (lv_elseExpression_6_0= ruleGExpression ) ) otherlv_7= 'endif' )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1263:2: () otherlv_1= 'if' ( (lv_condition_2_0= ruleGExpression ) ) otherlv_3= 'then' ( (lv_thenExpression_4_0= ruleGExpression ) ) otherlv_5= 'else' ( (lv_elseExpression_6_0= ruleGExpression ) ) otherlv_7= 'endif'
            {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1263:2: ()
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1264:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getGIfExpressionAccess().getGIfExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,16,FOLLOW_16_in_ruleGIfExpression2792); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getGIfExpressionAccess().getIfKeyword_1());
                  
            }
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1273:1: ( (lv_condition_2_0= ruleGExpression ) )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1274:1: (lv_condition_2_0= ruleGExpression )
            {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1274:1: (lv_condition_2_0= ruleGExpression )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1275:3: lv_condition_2_0= ruleGExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getGIfExpressionAccess().getConditionGExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleGExpression_in_ruleGIfExpression2813);
            lv_condition_2_0=ruleGExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getGIfExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"condition",
                      		lv_condition_2_0, 
                      		"GExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,17,FOLLOW_17_in_ruleGIfExpression2825); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getGIfExpressionAccess().getThenKeyword_3());
                  
            }
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1295:1: ( (lv_thenExpression_4_0= ruleGExpression ) )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1296:1: (lv_thenExpression_4_0= ruleGExpression )
            {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1296:1: (lv_thenExpression_4_0= ruleGExpression )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1297:3: lv_thenExpression_4_0= ruleGExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getGIfExpressionAccess().getThenExpressionGExpressionParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleGExpression_in_ruleGIfExpression2846);
            lv_thenExpression_4_0=ruleGExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getGIfExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"thenExpression",
                      		lv_thenExpression_4_0, 
                      		"GExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_5=(Token)match(input,18,FOLLOW_18_in_ruleGIfExpression2858); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getGIfExpressionAccess().getElseKeyword_5());
                  
            }
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1317:1: ( (lv_elseExpression_6_0= ruleGExpression ) )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1318:1: (lv_elseExpression_6_0= ruleGExpression )
            {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1318:1: (lv_elseExpression_6_0= ruleGExpression )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1319:3: lv_elseExpression_6_0= ruleGExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getGIfExpressionAccess().getElseExpressionGExpressionParserRuleCall_6_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleGExpression_in_ruleGIfExpression2879);
            lv_elseExpression_6_0=ruleGExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getGIfExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"elseExpression",
                      		lv_elseExpression_6_0, 
                      		"GExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_7=(Token)match(input,19,FOLLOW_19_in_ruleGIfExpression2891); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getGIfExpressionAccess().getEndifKeyword_7());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGIfExpression"


    // $ANTLR start "entryRuleGBraceExpression"
    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1347:1: entryRuleGBraceExpression returns [EObject current=null] : iv_ruleGBraceExpression= ruleGBraceExpression EOF ;
    public final EObject entryRuleGBraceExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGBraceExpression = null;


        try {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1348:2: (iv_ruleGBraceExpression= ruleGBraceExpression EOF )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1349:2: iv_ruleGBraceExpression= ruleGBraceExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGBraceExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleGBraceExpression_in_entryRuleGBraceExpression2927);
            iv_ruleGBraceExpression=ruleGBraceExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGBraceExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleGBraceExpression2937); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGBraceExpression"


    // $ANTLR start "ruleGBraceExpression"
    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1356:1: ruleGBraceExpression returns [EObject current=null] : ( () otherlv_1= '(' ( (lv_innerExpression_2_0= ruleGExpression ) ) otherlv_3= ')' ) ;
    public final EObject ruleGBraceExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_innerExpression_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1359:28: ( ( () otherlv_1= '(' ( (lv_innerExpression_2_0= ruleGExpression ) ) otherlv_3= ')' ) )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1360:1: ( () otherlv_1= '(' ( (lv_innerExpression_2_0= ruleGExpression ) ) otherlv_3= ')' )
            {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1360:1: ( () otherlv_1= '(' ( (lv_innerExpression_2_0= ruleGExpression ) ) otherlv_3= ')' )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1360:2: () otherlv_1= '(' ( (lv_innerExpression_2_0= ruleGExpression ) ) otherlv_3= ')'
            {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1360:2: ()
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1361:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getGBraceExpressionAccess().getGBraceExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,20,FOLLOW_20_in_ruleGBraceExpression2983); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getGBraceExpressionAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1370:1: ( (lv_innerExpression_2_0= ruleGExpression ) )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1371:1: (lv_innerExpression_2_0= ruleGExpression )
            {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1371:1: (lv_innerExpression_2_0= ruleGExpression )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1372:3: lv_innerExpression_2_0= ruleGExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getGBraceExpressionAccess().getInnerExpressionGExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleGExpression_in_ruleGBraceExpression3004);
            lv_innerExpression_2_0=ruleGExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getGBraceExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"innerExpression",
                      		lv_innerExpression_2_0, 
                      		"GExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,21,FOLLOW_21_in_ruleGBraceExpression3016); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getGBraceExpressionAccess().getRightParenthesisKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGBraceExpression"


    // $ANTLR start "entryRuleNavigationOperator"
    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1400:1: entryRuleNavigationOperator returns [String current=null] : iv_ruleNavigationOperator= ruleNavigationOperator EOF ;
    public final String entryRuleNavigationOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNavigationOperator = null;


        try {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1401:2: (iv_ruleNavigationOperator= ruleNavigationOperator EOF )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1402:2: iv_ruleNavigationOperator= ruleNavigationOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigationOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleNavigationOperator_in_entryRuleNavigationOperator3053);
            iv_ruleNavigationOperator=ruleNavigationOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigationOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNavigationOperator3064); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNavigationOperator"


    // $ANTLR start "ruleNavigationOperator"
    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1409:1: ruleNavigationOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '.' | kw= '->' ) ;
    public final AntlrDatatypeRuleToken ruleNavigationOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1412:28: ( (kw= '.' | kw= '->' ) )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1413:1: (kw= '.' | kw= '->' )
            {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1413:1: (kw= '.' | kw= '->' )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==22) ) {
                alt17=1;
            }
            else if ( (LA17_0==23) ) {
                alt17=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1414:2: kw= '.'
                    {
                    kw=(Token)match(input,22,FOLLOW_22_in_ruleNavigationOperator3102); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getNavigationOperatorAccess().getFullStopKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1421:2: kw= '->'
                    {
                    kw=(Token)match(input,23,FOLLOW_23_in_ruleNavigationOperator3121); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getNavigationOperatorAccess().getHyphenMinusGreaterThanSignKeyword_1()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNavigationOperator"


    // $ANTLR start "entryRuleQualifiedName"
    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1434:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1435:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1436:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName3162);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName3173); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1443:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID ( ( ( '.' )=>kw= '.' ) this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1446:28: ( (this_ID_0= RULE_ID ( ( ( '.' )=>kw= '.' ) this_ID_2= RULE_ID )* ) )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1447:1: (this_ID_0= RULE_ID ( ( ( '.' )=>kw= '.' ) this_ID_2= RULE_ID )* )
            {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1447:1: (this_ID_0= RULE_ID ( ( ( '.' )=>kw= '.' ) this_ID_2= RULE_ID )* )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1447:6: this_ID_0= RULE_ID ( ( ( '.' )=>kw= '.' ) this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName3213); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
                  
            }
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1454:1: ( ( ( '.' )=>kw= '.' ) this_ID_2= RULE_ID )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==22) ) {
                    int LA18_1 = input.LA(2);

                    if ( (LA18_1==RULE_ID) ) {
                        int LA18_3 = input.LA(3);

                        if ( (synpred1_InternalGExpressions()) ) {
                            alt18=1;
                        }


                    }


                }


                switch (alt18) {
            	case 1 :
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1454:2: ( ( '.' )=>kw= '.' ) this_ID_2= RULE_ID
            	    {
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1454:2: ( ( '.' )=>kw= '.' )
            	    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1454:3: ( '.' )=>kw= '.'
            	    {
            	    kw=(Token)match(input,22,FOLLOW_22_in_ruleQualifiedName3241); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	          
            	    }

            	    }

            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName3257); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ID_2);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "ruleGAndOperator"
    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1477:1: ruleGAndOperator returns [Enumerator current=null] : (enumLiteral_0= 'and' ) ;
    public final Enumerator ruleGAndOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;

         enterRule(); 
        try {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1479:28: ( (enumLiteral_0= 'and' ) )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1480:1: (enumLiteral_0= 'and' )
            {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1480:1: (enumLiteral_0= 'and' )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1480:3: enumLiteral_0= 'and'
            {
            enumLiteral_0=(Token)match(input,24,FOLLOW_24_in_ruleGAndOperator3317); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current = grammarAccess.getGAndOperatorAccess().getANDEnumLiteralDeclaration().getEnumLiteral().getInstance();
                      newLeafNode(enumLiteral_0, grammarAccess.getGAndOperatorAccess().getANDEnumLiteralDeclaration()); 
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGAndOperator"


    // $ANTLR start "ruleGXorOperator"
    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1490:1: ruleGXorOperator returns [Enumerator current=null] : (enumLiteral_0= 'xor' ) ;
    public final Enumerator ruleGXorOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;

         enterRule(); 
        try {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1492:28: ( (enumLiteral_0= 'xor' ) )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1493:1: (enumLiteral_0= 'xor' )
            {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1493:1: (enumLiteral_0= 'xor' )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1493:3: enumLiteral_0= 'xor'
            {
            enumLiteral_0=(Token)match(input,25,FOLLOW_25_in_ruleGXorOperator3360); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current = grammarAccess.getGXorOperatorAccess().getXOREnumLiteralDeclaration().getEnumLiteral().getInstance();
                      newLeafNode(enumLiteral_0, grammarAccess.getGXorOperatorAccess().getXOREnumLiteralDeclaration()); 
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGXorOperator"


    // $ANTLR start "ruleGOrOperator"
    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1503:1: ruleGOrOperator returns [Enumerator current=null] : (enumLiteral_0= 'or' ) ;
    public final Enumerator ruleGOrOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;

         enterRule(); 
        try {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1505:28: ( (enumLiteral_0= 'or' ) )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1506:1: (enumLiteral_0= 'or' )
            {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1506:1: (enumLiteral_0= 'or' )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1506:3: enumLiteral_0= 'or'
            {
            enumLiteral_0=(Token)match(input,26,FOLLOW_26_in_ruleGOrOperator3403); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current = grammarAccess.getGOrOperatorAccess().getOREnumLiteralDeclaration().getEnumLiteral().getInstance();
                      newLeafNode(enumLiteral_0, grammarAccess.getGOrOperatorAccess().getOREnumLiteralDeclaration()); 
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGOrOperator"


    // $ANTLR start "ruleGEqualityOperator"
    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1516:1: ruleGEqualityOperator returns [Enumerator current=null] : ( (enumLiteral_0= '=' ) | (enumLiteral_1= '<>' ) ) ;
    public final Enumerator ruleGEqualityOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1518:28: ( ( (enumLiteral_0= '=' ) | (enumLiteral_1= '<>' ) ) )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1519:1: ( (enumLiteral_0= '=' ) | (enumLiteral_1= '<>' ) )
            {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1519:1: ( (enumLiteral_0= '=' ) | (enumLiteral_1= '<>' ) )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==27) ) {
                alt19=1;
            }
            else if ( (LA19_0==28) ) {
                alt19=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1519:2: (enumLiteral_0= '=' )
                    {
                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1519:2: (enumLiteral_0= '=' )
                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1519:4: enumLiteral_0= '='
                    {
                    enumLiteral_0=(Token)match(input,27,FOLLOW_27_in_ruleGEqualityOperator3447); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getGEqualityOperatorAccess().getEQUALEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getGEqualityOperatorAccess().getEQUALEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1525:6: (enumLiteral_1= '<>' )
                    {
                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1525:6: (enumLiteral_1= '<>' )
                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1525:8: enumLiteral_1= '<>'
                    {
                    enumLiteral_1=(Token)match(input,28,FOLLOW_28_in_ruleGEqualityOperator3464); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getGEqualityOperatorAccess().getNOTEQUALEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getGEqualityOperatorAccess().getNOTEQUALEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGEqualityOperator"


    // $ANTLR start "ruleGRelationOperator"
    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1535:1: ruleGRelationOperator returns [Enumerator current=null] : ( (enumLiteral_0= '<' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '<=' ) | (enumLiteral_3= '>=' ) ) ;
    public final Enumerator ruleGRelationOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1537:28: ( ( (enumLiteral_0= '<' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '<=' ) | (enumLiteral_3= '>=' ) ) )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1538:1: ( (enumLiteral_0= '<' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '<=' ) | (enumLiteral_3= '>=' ) )
            {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1538:1: ( (enumLiteral_0= '<' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '<=' ) | (enumLiteral_3= '>=' ) )
            int alt20=4;
            switch ( input.LA(1) ) {
            case 29:
                {
                alt20=1;
                }
                break;
            case 30:
                {
                alt20=2;
                }
                break;
            case 31:
                {
                alt20=3;
                }
                break;
            case 32:
                {
                alt20=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1538:2: (enumLiteral_0= '<' )
                    {
                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1538:2: (enumLiteral_0= '<' )
                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1538:4: enumLiteral_0= '<'
                    {
                    enumLiteral_0=(Token)match(input,29,FOLLOW_29_in_ruleGRelationOperator3509); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getGRelationOperatorAccess().getLESSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getGRelationOperatorAccess().getLESSEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1544:6: (enumLiteral_1= '>' )
                    {
                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1544:6: (enumLiteral_1= '>' )
                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1544:8: enumLiteral_1= '>'
                    {
                    enumLiteral_1=(Token)match(input,30,FOLLOW_30_in_ruleGRelationOperator3526); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getGRelationOperatorAccess().getGREATEREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getGRelationOperatorAccess().getGREATEREnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1550:6: (enumLiteral_2= '<=' )
                    {
                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1550:6: (enumLiteral_2= '<=' )
                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1550:8: enumLiteral_2= '<='
                    {
                    enumLiteral_2=(Token)match(input,31,FOLLOW_31_in_ruleGRelationOperator3543); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getGRelationOperatorAccess().getLESSEQUALEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getGRelationOperatorAccess().getLESSEQUALEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1556:6: (enumLiteral_3= '>=' )
                    {
                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1556:6: (enumLiteral_3= '>=' )
                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1556:8: enumLiteral_3= '>='
                    {
                    enumLiteral_3=(Token)match(input,32,FOLLOW_32_in_ruleGRelationOperator3560); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getGRelationOperatorAccess().getGREATEREQUALEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getGRelationOperatorAccess().getGREATEREQUALEnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGRelationOperator"


    // $ANTLR start "ruleGAdditionOperator"
    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1566:1: ruleGAdditionOperator returns [Enumerator current=null] : ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) ;
    public final Enumerator ruleGAdditionOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1568:28: ( ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1569:1: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1569:1: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==33) ) {
                alt21=1;
            }
            else if ( (LA21_0==34) ) {
                alt21=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1569:2: (enumLiteral_0= '+' )
                    {
                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1569:2: (enumLiteral_0= '+' )
                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1569:4: enumLiteral_0= '+'
                    {
                    enumLiteral_0=(Token)match(input,33,FOLLOW_33_in_ruleGAdditionOperator3605); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getGAdditionOperatorAccess().getADDITIONEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getGAdditionOperatorAccess().getADDITIONEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1575:6: (enumLiteral_1= '-' )
                    {
                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1575:6: (enumLiteral_1= '-' )
                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1575:8: enumLiteral_1= '-'
                    {
                    enumLiteral_1=(Token)match(input,34,FOLLOW_34_in_ruleGAdditionOperator3622); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getGAdditionOperatorAccess().getSUBTRACTIONEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getGAdditionOperatorAccess().getSUBTRACTIONEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGAdditionOperator"


    // $ANTLR start "ruleGMultiplicationOperator"
    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1585:1: ruleGMultiplicationOperator returns [Enumerator current=null] : ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) ) ;
    public final Enumerator ruleGMultiplicationOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1587:28: ( ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) ) )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1588:1: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) )
            {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1588:1: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==35) ) {
                alt22=1;
            }
            else if ( (LA22_0==36) ) {
                alt22=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1588:2: (enumLiteral_0= '*' )
                    {
                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1588:2: (enumLiteral_0= '*' )
                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1588:4: enumLiteral_0= '*'
                    {
                    enumLiteral_0=(Token)match(input,35,FOLLOW_35_in_ruleGMultiplicationOperator3667); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getGMultiplicationOperatorAccess().getMULTIPLICATIONEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getGMultiplicationOperatorAccess().getMULTIPLICATIONEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1594:6: (enumLiteral_1= '/' )
                    {
                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1594:6: (enumLiteral_1= '/' )
                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1594:8: enumLiteral_1= '/'
                    {
                    enumLiteral_1=(Token)match(input,36,FOLLOW_36_in_ruleGMultiplicationOperator3684); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getGMultiplicationOperatorAccess().getDIVISIONEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getGMultiplicationOperatorAccess().getDIVISIONEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGMultiplicationOperator"


    // $ANTLR start "ruleGNegationOperator"
    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1604:1: ruleGNegationOperator returns [Enumerator current=null] : ( (enumLiteral_0= 'not' ) | (enumLiteral_1= '~' ) ) ;
    public final Enumerator ruleGNegationOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1606:28: ( ( (enumLiteral_0= 'not' ) | (enumLiteral_1= '~' ) ) )
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1607:1: ( (enumLiteral_0= 'not' ) | (enumLiteral_1= '~' ) )
            {
            // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1607:1: ( (enumLiteral_0= 'not' ) | (enumLiteral_1= '~' ) )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==37) ) {
                alt23=1;
            }
            else if ( (LA23_0==38) ) {
                alt23=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1607:2: (enumLiteral_0= 'not' )
                    {
                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1607:2: (enumLiteral_0= 'not' )
                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1607:4: enumLiteral_0= 'not'
                    {
                    enumLiteral_0=(Token)match(input,37,FOLLOW_37_in_ruleGNegationOperator3729); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getGNegationOperatorAccess().getNEGATIONEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getGNegationOperatorAccess().getNEGATIONEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1613:6: (enumLiteral_1= '~' )
                    {
                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1613:6: (enumLiteral_1= '~' )
                    // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1613:8: enumLiteral_1= '~'
                    {
                    enumLiteral_1=(Token)match(input,38,FOLLOW_38_in_ruleGNegationOperator3746); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getGNegationOperatorAccess().getMINUSEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getGNegationOperatorAccess().getMINUSEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGNegationOperator"

    // $ANTLR start synpred1_InternalGExpressions
    public final void synpred1_InternalGExpressions_fragment() throws RecognitionException {   
        // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1454:3: ( '.' )
        // ../org.gemoc.gexpressions.xtext/src-gen/org/gemoc/gexpressions/xtext/parser/antlr/internal/InternalGExpressions.g:1455:2: '.'
        {
        match(input,22,FOLLOW_22_in_synpred1_InternalGExpressions3232); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_InternalGExpressions

    // Delegated rules

    public final boolean synpred1_InternalGExpressions() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalGExpressions_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_ruleGProgram_in_entryRuleGProgram75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGProgram85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGImportStatement_in_ruleGProgram131 = new BitSet(new long[]{0x000000600011C1F2L});
    public static final BitSet FOLLOW_ruleGExpression_in_ruleGProgram154 = new BitSet(new long[]{0x000000600011A1F2L});
    public static final BitSet FOLLOW_13_in_ruleGProgram168 = new BitSet(new long[]{0x00000060001181F0L});
    public static final BitSet FOLLOW_ruleGExpression_in_ruleGProgram191 = new BitSet(new long[]{0x000000600011A1F2L});
    public static final BitSet FOLLOW_ruleGImportStatement_in_entryRuleGImportStatement231 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGImportStatement241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleGImportStatement278 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleGImportStatement295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGExpression_in_entryRuleGExpression336 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGExpression346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGOrExpression_in_ruleGExpression392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGOrExpression_in_entryRuleGOrExpression426 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGOrExpression436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGXorExpression_in_ruleGOrExpression483 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_ruleGOrOperator_in_ruleGOrExpression513 = new BitSet(new long[]{0x00000060001181F0L});
    public static final BitSet FOLLOW_ruleGXorExpression_in_ruleGOrExpression534 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_ruleGXorExpression_in_entryRuleGXorExpression572 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGXorExpression582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGAndExpression_in_ruleGXorExpression629 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_ruleGXorOperator_in_ruleGXorExpression659 = new BitSet(new long[]{0x00000060001181F0L});
    public static final BitSet FOLLOW_ruleGAndExpression_in_ruleGXorExpression680 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_ruleGAndExpression_in_entryRuleGAndExpression718 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGAndExpression728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGEqualityExpression_in_ruleGAndExpression775 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_ruleGAndOperator_in_ruleGAndExpression805 = new BitSet(new long[]{0x00000060001181F0L});
    public static final BitSet FOLLOW_ruleGEqualityExpression_in_ruleGAndExpression826 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_ruleGEqualityExpression_in_entryRuleGEqualityExpression864 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGEqualityExpression874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGRelationExpression_in_ruleGEqualityExpression921 = new BitSet(new long[]{0x0000000018000002L});
    public static final BitSet FOLLOW_ruleGEqualityOperator_in_ruleGEqualityExpression951 = new BitSet(new long[]{0x00000060001181F0L});
    public static final BitSet FOLLOW_ruleGRelationExpression_in_ruleGEqualityExpression972 = new BitSet(new long[]{0x0000000018000002L});
    public static final BitSet FOLLOW_ruleGRelationExpression_in_entryRuleGRelationExpression1010 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGRelationExpression1020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGAdditionExpression_in_ruleGRelationExpression1067 = new BitSet(new long[]{0x00000001E0000002L});
    public static final BitSet FOLLOW_ruleGRelationOperator_in_ruleGRelationExpression1097 = new BitSet(new long[]{0x00000060001181F0L});
    public static final BitSet FOLLOW_ruleGAdditionExpression_in_ruleGRelationExpression1118 = new BitSet(new long[]{0x00000001E0000002L});
    public static final BitSet FOLLOW_ruleGAdditionExpression_in_entryRuleGAdditionExpression1156 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGAdditionExpression1166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGMultiplicationExpression_in_ruleGAdditionExpression1213 = new BitSet(new long[]{0x0000000600000002L});
    public static final BitSet FOLLOW_ruleGAdditionOperator_in_ruleGAdditionExpression1243 = new BitSet(new long[]{0x00000060001181F0L});
    public static final BitSet FOLLOW_ruleGMultiplicationExpression_in_ruleGAdditionExpression1264 = new BitSet(new long[]{0x0000000600000002L});
    public static final BitSet FOLLOW_ruleGMultiplicationExpression_in_entryRuleGMultiplicationExpression1302 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGMultiplicationExpression1312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGNegationExpression_in_ruleGMultiplicationExpression1359 = new BitSet(new long[]{0x0000001800000002L});
    public static final BitSet FOLLOW_ruleGMultiplicationOperator_in_ruleGMultiplicationExpression1389 = new BitSet(new long[]{0x00000060001181F0L});
    public static final BitSet FOLLOW_ruleGNegationExpression_in_ruleGMultiplicationExpression1410 = new BitSet(new long[]{0x0000001800000002L});
    public static final BitSet FOLLOW_ruleGNegationExpression_in_entryRuleGNegationExpression1448 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGNegationExpression1458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGNavigationExpression_in_ruleGNegationExpression1505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGNegationOperator_in_ruleGNegationExpression1541 = new BitSet(new long[]{0x00000000001181F0L});
    public static final BitSet FOLLOW_ruleGNavigationExpression_in_ruleGNegationExpression1562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGNavigationExpression_in_entryRuleGNavigationExpression1599 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGNavigationExpression1609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGReferenceExpression_in_ruleGNavigationExpression1656 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_ruleNavigationOperator_in_ruleGNavigationExpression1681 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGNavigationExpression1700 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_ruleGReferenceExpression_in_entryRuleGReferenceExpression1738 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGReferenceExpression1748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGPrimaryExpression_in_ruleGReferenceExpression1795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGReferenceExpression1830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGPrimaryExpression_in_entryRuleGPrimaryExpression1867 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGPrimaryExpression1877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGStringExpression_in_ruleGPrimaryExpression1924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGBooleanExpression_in_ruleGPrimaryExpression1951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGNumericExpression_in_ruleGPrimaryExpression1978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGEnumLiteralExpression_in_ruleGPrimaryExpression2005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGIfExpression_in_ruleGPrimaryExpression2032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGBraceExpression_in_ruleGPrimaryExpression2059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGStringExpression_in_entryRuleGStringExpression2094 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGStringExpression2104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleGStringExpression2155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGBooleanExpression_in_entryRuleGBooleanExpression2196 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGBooleanExpression2206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BOOLEAN_in_ruleGBooleanExpression2257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGNumericExpression_in_entryRuleGNumericExpression2298 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGNumericExpression2308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGIntegerExpression_in_ruleGNumericExpression2355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGDoubleExpression_in_ruleGNumericExpression2382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGIntegerExpression_in_entryRuleGIntegerExpression2417 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGIntegerExpression2427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleGIntegerExpression2478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGDoubleExpression_in_entryRuleGDoubleExpression2519 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGDoubleExpression2529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DOUBLE_in_ruleGDoubleExpression2580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGEnumLiteralExpression_in_entryRuleGEnumLiteralExpression2621 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGEnumLiteralExpression2631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleGEnumLiteralExpression2677 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGEnumLiteralExpression2700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGIfExpression_in_entryRuleGIfExpression2736 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGIfExpression2746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleGIfExpression2792 = new BitSet(new long[]{0x00000060001181F0L});
    public static final BitSet FOLLOW_ruleGExpression_in_ruleGIfExpression2813 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleGIfExpression2825 = new BitSet(new long[]{0x00000060001181F0L});
    public static final BitSet FOLLOW_ruleGExpression_in_ruleGIfExpression2846 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleGIfExpression2858 = new BitSet(new long[]{0x00000060001181F0L});
    public static final BitSet FOLLOW_ruleGExpression_in_ruleGIfExpression2879 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleGIfExpression2891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGBraceExpression_in_entryRuleGBraceExpression2927 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGBraceExpression2937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleGBraceExpression2983 = new BitSet(new long[]{0x00000060001181F0L});
    public static final BitSet FOLLOW_ruleGExpression_in_ruleGBraceExpression3004 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleGBraceExpression3016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNavigationOperator_in_entryRuleNavigationOperator3053 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNavigationOperator3064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleNavigationOperator3102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleNavigationOperator3121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName3162 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName3173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName3213 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_22_in_ruleQualifiedName3241 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName3257 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_24_in_ruleGAndOperator3317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleGXorOperator3360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleGOrOperator3403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleGEqualityOperator3447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleGEqualityOperator3464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleGRelationOperator3509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleGRelationOperator3526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleGRelationOperator3543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleGRelationOperator3560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleGAdditionOperator3605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleGAdditionOperator3622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleGMultiplicationOperator3667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleGMultiplicationOperator3684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleGNegationOperator3729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleGNegationOperator3746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_synpred1_InternalGExpressions3232 = new BitSet(new long[]{0x0000000000000002L});

}