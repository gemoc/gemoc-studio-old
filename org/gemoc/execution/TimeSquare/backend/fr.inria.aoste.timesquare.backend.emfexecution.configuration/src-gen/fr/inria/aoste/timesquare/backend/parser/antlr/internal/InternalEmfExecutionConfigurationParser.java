package fr.inria.aoste.timesquare.backend.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import fr.inria.aoste.timesquare.backend.services.EmfExecutionConfigurationGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalEmfExecutionConfigurationParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'When'", "'DSA'", "'returns'", "'true'", "'avoid'", "';'", "'import'", "'importJar'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=5;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=6;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public InternalEmfExecutionConfigurationParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalEmfExecutionConfigurationParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalEmfExecutionConfigurationParser.tokenNames; }
    public String getGrammarFileName() { return "../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */
     
     	private EmfExecutionConfigurationGrammarAccess grammarAccess;
     	
        public InternalEmfExecutionConfigurationParser(TokenStream input, EmfExecutionConfigurationGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "EMFExecutionConfiguration";	
       	}
       	
       	@Override
       	protected EmfExecutionConfigurationGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleEMFExecutionConfiguration"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:73:1: entryRuleEMFExecutionConfiguration returns [EObject current=null] : iv_ruleEMFExecutionConfiguration= ruleEMFExecutionConfiguration EOF ;
    public final EObject entryRuleEMFExecutionConfiguration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEMFExecutionConfiguration = null;


        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:74:2: (iv_ruleEMFExecutionConfiguration= ruleEMFExecutionConfiguration EOF )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:75:2: iv_ruleEMFExecutionConfiguration= ruleEMFExecutionConfiguration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEMFExecutionConfigurationRule()); 
            }
            pushFollow(FOLLOW_ruleEMFExecutionConfiguration_in_entryRuleEMFExecutionConfiguration81);
            iv_ruleEMFExecutionConfiguration=ruleEMFExecutionConfiguration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEMFExecutionConfiguration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEMFExecutionConfiguration91); if (state.failed) return current;

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
    // $ANTLR end "entryRuleEMFExecutionConfiguration"


    // $ANTLR start "ruleEMFExecutionConfiguration"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:82:1: ruleEMFExecutionConfiguration returns [EObject current=null] : ( ( (lv_imports_0_0= ruleImportStatement ) )+ ( (lv_jarImportStatement_1_0= ruleJarImportStatement ) ) ( (lv_forcedClockMappings_2_0= ruleForcedClockMapping ) )* ) ;
    public final EObject ruleEMFExecutionConfiguration() throws RecognitionException {
        EObject current = null;

        EObject lv_imports_0_0 = null;

        EObject lv_jarImportStatement_1_0 = null;

        EObject lv_forcedClockMappings_2_0 = null;


         enterRule(); 
            
        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:85:28: ( ( ( (lv_imports_0_0= ruleImportStatement ) )+ ( (lv_jarImportStatement_1_0= ruleJarImportStatement ) ) ( (lv_forcedClockMappings_2_0= ruleForcedClockMapping ) )* ) )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:86:1: ( ( (lv_imports_0_0= ruleImportStatement ) )+ ( (lv_jarImportStatement_1_0= ruleJarImportStatement ) ) ( (lv_forcedClockMappings_2_0= ruleForcedClockMapping ) )* )
            {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:86:1: ( ( (lv_imports_0_0= ruleImportStatement ) )+ ( (lv_jarImportStatement_1_0= ruleJarImportStatement ) ) ( (lv_forcedClockMappings_2_0= ruleForcedClockMapping ) )* )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:86:2: ( (lv_imports_0_0= ruleImportStatement ) )+ ( (lv_jarImportStatement_1_0= ruleJarImportStatement ) ) ( (lv_forcedClockMappings_2_0= ruleForcedClockMapping ) )*
            {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:86:2: ( (lv_imports_0_0= ruleImportStatement ) )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==17) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:87:1: (lv_imports_0_0= ruleImportStatement )
            	    {
            	    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:87:1: (lv_imports_0_0= ruleImportStatement )
            	    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:88:3: lv_imports_0_0= ruleImportStatement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getEMFExecutionConfigurationAccess().getImportsImportStatementParserRuleCall_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleImportStatement_in_ruleEMFExecutionConfiguration137);
            	    lv_imports_0_0=ruleImportStatement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getEMFExecutionConfigurationRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"imports",
            	              		lv_imports_0_0, 
            	              		"ImportStatement");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);

            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:104:3: ( (lv_jarImportStatement_1_0= ruleJarImportStatement ) )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:105:1: (lv_jarImportStatement_1_0= ruleJarImportStatement )
            {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:105:1: (lv_jarImportStatement_1_0= ruleJarImportStatement )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:106:3: lv_jarImportStatement_1_0= ruleJarImportStatement
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEMFExecutionConfigurationAccess().getJarImportStatementJarImportStatementParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJarImportStatement_in_ruleEMFExecutionConfiguration159);
            lv_jarImportStatement_1_0=ruleJarImportStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getEMFExecutionConfigurationRule());
              	        }
                     		set(
                     			current, 
                     			"jarImportStatement",
                      		lv_jarImportStatement_1_0, 
                      		"JarImportStatement");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:122:2: ( (lv_forcedClockMappings_2_0= ruleForcedClockMapping ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==11) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:123:1: (lv_forcedClockMappings_2_0= ruleForcedClockMapping )
            	    {
            	    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:123:1: (lv_forcedClockMappings_2_0= ruleForcedClockMapping )
            	    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:124:3: lv_forcedClockMappings_2_0= ruleForcedClockMapping
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getEMFExecutionConfigurationAccess().getForcedClockMappingsForcedClockMappingParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleForcedClockMapping_in_ruleEMFExecutionConfiguration180);
            	    lv_forcedClockMappings_2_0=ruleForcedClockMapping();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getEMFExecutionConfigurationRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"forcedClockMappings",
            	              		lv_forcedClockMappings_2_0, 
            	              		"ForcedClockMapping");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
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
    // $ANTLR end "ruleEMFExecutionConfiguration"


    // $ANTLR start "entryRuleForcedClockMapping"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:148:1: entryRuleForcedClockMapping returns [EObject current=null] : iv_ruleForcedClockMapping= ruleForcedClockMapping EOF ;
    public final EObject entryRuleForcedClockMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForcedClockMapping = null;


        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:149:2: (iv_ruleForcedClockMapping= ruleForcedClockMapping EOF )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:150:2: iv_ruleForcedClockMapping= ruleForcedClockMapping EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getForcedClockMappingRule()); 
            }
            pushFollow(FOLLOW_ruleForcedClockMapping_in_entryRuleForcedClockMapping217);
            iv_ruleForcedClockMapping=ruleForcedClockMapping();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleForcedClockMapping; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleForcedClockMapping227); if (state.failed) return current;

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
    // $ANTLR end "entryRuleForcedClockMapping"


    // $ANTLR start "ruleForcedClockMapping"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:157:1: ruleForcedClockMapping returns [EObject current=null] : (otherlv_0= 'When' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'DSA' otherlv_3= 'returns' otherlv_4= 'true' otherlv_5= 'avoid' ( (otherlv_6= RULE_ID ) ) otherlv_7= ';' ) ;
    public final EObject ruleForcedClockMapping() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;

         enterRule(); 
            
        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:160:28: ( (otherlv_0= 'When' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'DSA' otherlv_3= 'returns' otherlv_4= 'true' otherlv_5= 'avoid' ( (otherlv_6= RULE_ID ) ) otherlv_7= ';' ) )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:161:1: (otherlv_0= 'When' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'DSA' otherlv_3= 'returns' otherlv_4= 'true' otherlv_5= 'avoid' ( (otherlv_6= RULE_ID ) ) otherlv_7= ';' )
            {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:161:1: (otherlv_0= 'When' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'DSA' otherlv_3= 'returns' otherlv_4= 'true' otherlv_5= 'avoid' ( (otherlv_6= RULE_ID ) ) otherlv_7= ';' )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:161:3: otherlv_0= 'When' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'DSA' otherlv_3= 'returns' otherlv_4= 'true' otherlv_5= 'avoid' ( (otherlv_6= RULE_ID ) ) otherlv_7= ';'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_11_in_ruleForcedClockMapping264); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getForcedClockMappingAccess().getWhenKeyword_0());
                  
            }
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:165:1: ( (otherlv_1= RULE_ID ) )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:166:1: (otherlv_1= RULE_ID )
            {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:166:1: (otherlv_1= RULE_ID )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:167:3: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getForcedClockMappingRule());
              	        }
                      
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleForcedClockMapping288); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_1, grammarAccess.getForcedClockMappingAccess().getClockClockCrossReference_1_0()); 
              	
            }

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_12_in_ruleForcedClockMapping300); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getForcedClockMappingAccess().getDSAKeyword_2());
                  
            }
            otherlv_3=(Token)match(input,13,FOLLOW_13_in_ruleForcedClockMapping312); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getForcedClockMappingAccess().getReturnsKeyword_3());
                  
            }
            otherlv_4=(Token)match(input,14,FOLLOW_14_in_ruleForcedClockMapping324); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getForcedClockMappingAccess().getTrueKeyword_4());
                  
            }
            otherlv_5=(Token)match(input,15,FOLLOW_15_in_ruleForcedClockMapping336); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getForcedClockMappingAccess().getAvoidKeyword_5());
                  
            }
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:197:1: ( (otherlv_6= RULE_ID ) )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:198:1: (otherlv_6= RULE_ID )
            {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:198:1: (otherlv_6= RULE_ID )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:199:3: otherlv_6= RULE_ID
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getForcedClockMappingRule());
              	        }
                      
            }
            otherlv_6=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleForcedClockMapping360); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_6, grammarAccess.getForcedClockMappingAccess().getClockToAvoidWhenTrueClockCrossReference_6_0()); 
              	
            }

            }


            }

            otherlv_7=(Token)match(input,16,FOLLOW_16_in_ruleForcedClockMapping372); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getForcedClockMappingAccess().getSemicolonKeyword_7());
                  
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
    // $ANTLR end "ruleForcedClockMapping"


    // $ANTLR start "entryRuleImportStatement"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:225:1: entryRuleImportStatement returns [EObject current=null] : iv_ruleImportStatement= ruleImportStatement EOF ;
    public final EObject entryRuleImportStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportStatement = null;


        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:226:2: (iv_ruleImportStatement= ruleImportStatement EOF )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:227:2: iv_ruleImportStatement= ruleImportStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImportStatementRule()); 
            }
            pushFollow(FOLLOW_ruleImportStatement_in_entryRuleImportStatement408);
            iv_ruleImportStatement=ruleImportStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImportStatement; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleImportStatement418); if (state.failed) return current;

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
    // $ANTLR end "entryRuleImportStatement"


    // $ANTLR start "ruleImportStatement"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:234:1: ruleImportStatement returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) otherlv_2= ';' ) ;
    public final EObject ruleImportStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_importURI_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:237:28: ( (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) otherlv_2= ';' ) )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:238:1: (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) otherlv_2= ';' )
            {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:238:1: (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) otherlv_2= ';' )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:238:3: otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,17,FOLLOW_17_in_ruleImportStatement455); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getImportStatementAccess().getImportKeyword_0());
                  
            }
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:242:1: ( (lv_importURI_1_0= RULE_STRING ) )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:243:1: (lv_importURI_1_0= RULE_STRING )
            {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:243:1: (lv_importURI_1_0= RULE_STRING )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:244:3: lv_importURI_1_0= RULE_STRING
            {
            lv_importURI_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleImportStatement472); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_importURI_1_0, grammarAccess.getImportStatementAccess().getImportURISTRINGTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getImportStatementRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"importURI",
                      		lv_importURI_1_0, 
                      		"STRING");
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,16,FOLLOW_16_in_ruleImportStatement489); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getImportStatementAccess().getSemicolonKeyword_2());
                  
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
    // $ANTLR end "ruleImportStatement"


    // $ANTLR start "entryRuleJarImportStatement"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:272:1: entryRuleJarImportStatement returns [EObject current=null] : iv_ruleJarImportStatement= ruleJarImportStatement EOF ;
    public final EObject entryRuleJarImportStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJarImportStatement = null;


        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:273:2: (iv_ruleJarImportStatement= ruleJarImportStatement EOF )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:274:2: iv_ruleJarImportStatement= ruleJarImportStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJarImportStatementRule()); 
            }
            pushFollow(FOLLOW_ruleJarImportStatement_in_entryRuleJarImportStatement525);
            iv_ruleJarImportStatement=ruleJarImportStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJarImportStatement; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJarImportStatement535); if (state.failed) return current;

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
    // $ANTLR end "entryRuleJarImportStatement"


    // $ANTLR start "ruleJarImportStatement"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:281:1: ruleJarImportStatement returns [EObject current=null] : (otherlv_0= 'importJar' ( (lv_pathToJar_1_0= RULE_STRING ) ) otherlv_2= ';' ) ;
    public final EObject ruleJarImportStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_pathToJar_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:284:28: ( (otherlv_0= 'importJar' ( (lv_pathToJar_1_0= RULE_STRING ) ) otherlv_2= ';' ) )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:285:1: (otherlv_0= 'importJar' ( (lv_pathToJar_1_0= RULE_STRING ) ) otherlv_2= ';' )
            {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:285:1: (otherlv_0= 'importJar' ( (lv_pathToJar_1_0= RULE_STRING ) ) otherlv_2= ';' )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:285:3: otherlv_0= 'importJar' ( (lv_pathToJar_1_0= RULE_STRING ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,18,FOLLOW_18_in_ruleJarImportStatement572); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getJarImportStatementAccess().getImportJarKeyword_0());
                  
            }
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:289:1: ( (lv_pathToJar_1_0= RULE_STRING ) )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:290:1: (lv_pathToJar_1_0= RULE_STRING )
            {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:290:1: (lv_pathToJar_1_0= RULE_STRING )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:291:3: lv_pathToJar_1_0= RULE_STRING
            {
            lv_pathToJar_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleJarImportStatement589); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_pathToJar_1_0, grammarAccess.getJarImportStatementAccess().getPathToJarSTRINGTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getJarImportStatementRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"pathToJar",
                      		lv_pathToJar_1_0, 
                      		"STRING");
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,16,FOLLOW_16_in_ruleJarImportStatement606); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getJarImportStatementAccess().getSemicolonKeyword_2());
                  
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
    // $ANTLR end "ruleJarImportStatement"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleEMFExecutionConfiguration_in_entryRuleEMFExecutionConfiguration81 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEMFExecutionConfiguration91 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImportStatement_in_ruleEMFExecutionConfiguration137 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_ruleJarImportStatement_in_ruleEMFExecutionConfiguration159 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_ruleForcedClockMapping_in_ruleEMFExecutionConfiguration180 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_ruleForcedClockMapping_in_entryRuleForcedClockMapping217 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleForcedClockMapping227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleForcedClockMapping264 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleForcedClockMapping288 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleForcedClockMapping300 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleForcedClockMapping312 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleForcedClockMapping324 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleForcedClockMapping336 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleForcedClockMapping360 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleForcedClockMapping372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImportStatement_in_entryRuleImportStatement408 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImportStatement418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleImportStatement455 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleImportStatement472 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleImportStatement489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJarImportStatement_in_entryRuleJarImportStatement525 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJarImportStatement535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleJarImportStatement572 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleJarImportStatement589 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleJarImportStatement606 = new BitSet(new long[]{0x0000000000000002L});

}