package fr.inria.aoste.timesquare.backend.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import fr.inria.aoste.timesquare.backend.services.EmfExecutionConfigurationGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalEmfExecutionConfigurationParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'When'", "'DSA'", "'returns'", "'true'", "'avoid'", "';'", "'import'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=5;
    public static final int T__16=16;
    public static final int T__15=15;
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
    public String getGrammarFileName() { return "../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g"; }


     
     	private EmfExecutionConfigurationGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(EmfExecutionConfigurationGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }
        
        @Override
        protected String getValueForTokenName(String tokenName) {
        	return tokenName;
        }




    // $ANTLR start "entryRuleEMFExecutionConfiguration"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:60:1: entryRuleEMFExecutionConfiguration : ruleEMFExecutionConfiguration EOF ;
    public final void entryRuleEMFExecutionConfiguration() throws RecognitionException {
        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:61:1: ( ruleEMFExecutionConfiguration EOF )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:62:1: ruleEMFExecutionConfiguration EOF
            {
             before(grammarAccess.getEMFExecutionConfigurationRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEMFExecutionConfiguration_in_entryRuleEMFExecutionConfiguration61);
            ruleEMFExecutionConfiguration();

            state._fsp--;

             after(grammarAccess.getEMFExecutionConfigurationRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEMFExecutionConfiguration68); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEMFExecutionConfiguration"


    // $ANTLR start "ruleEMFExecutionConfiguration"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:69:1: ruleEMFExecutionConfiguration : ( ( rule__EMFExecutionConfiguration__Group__0 ) ) ;
    public final void ruleEMFExecutionConfiguration() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:73:2: ( ( ( rule__EMFExecutionConfiguration__Group__0 ) ) )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:74:1: ( ( rule__EMFExecutionConfiguration__Group__0 ) )
            {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:74:1: ( ( rule__EMFExecutionConfiguration__Group__0 ) )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:75:1: ( rule__EMFExecutionConfiguration__Group__0 )
            {
             before(grammarAccess.getEMFExecutionConfigurationAccess().getGroup()); 
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:76:1: ( rule__EMFExecutionConfiguration__Group__0 )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:76:2: rule__EMFExecutionConfiguration__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__EMFExecutionConfiguration__Group__0_in_ruleEMFExecutionConfiguration94);
            rule__EMFExecutionConfiguration__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEMFExecutionConfigurationAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEMFExecutionConfiguration"


    // $ANTLR start "entryRuleForcedClockMapping"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:88:1: entryRuleForcedClockMapping : ruleForcedClockMapping EOF ;
    public final void entryRuleForcedClockMapping() throws RecognitionException {
        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:89:1: ( ruleForcedClockMapping EOF )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:90:1: ruleForcedClockMapping EOF
            {
             before(grammarAccess.getForcedClockMappingRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleForcedClockMapping_in_entryRuleForcedClockMapping121);
            ruleForcedClockMapping();

            state._fsp--;

             after(grammarAccess.getForcedClockMappingRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleForcedClockMapping128); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleForcedClockMapping"


    // $ANTLR start "ruleForcedClockMapping"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:97:1: ruleForcedClockMapping : ( ( rule__ForcedClockMapping__Group__0 ) ) ;
    public final void ruleForcedClockMapping() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:101:2: ( ( ( rule__ForcedClockMapping__Group__0 ) ) )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:102:1: ( ( rule__ForcedClockMapping__Group__0 ) )
            {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:102:1: ( ( rule__ForcedClockMapping__Group__0 ) )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:103:1: ( rule__ForcedClockMapping__Group__0 )
            {
             before(grammarAccess.getForcedClockMappingAccess().getGroup()); 
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:104:1: ( rule__ForcedClockMapping__Group__0 )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:104:2: rule__ForcedClockMapping__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ForcedClockMapping__Group__0_in_ruleForcedClockMapping154);
            rule__ForcedClockMapping__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getForcedClockMappingAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleForcedClockMapping"


    // $ANTLR start "entryRuleImportStatement"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:116:1: entryRuleImportStatement : ruleImportStatement EOF ;
    public final void entryRuleImportStatement() throws RecognitionException {
        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:117:1: ( ruleImportStatement EOF )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:118:1: ruleImportStatement EOF
            {
             before(grammarAccess.getImportStatementRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleImportStatement_in_entryRuleImportStatement181);
            ruleImportStatement();

            state._fsp--;

             after(grammarAccess.getImportStatementRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleImportStatement188); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleImportStatement"


    // $ANTLR start "ruleImportStatement"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:125:1: ruleImportStatement : ( ( rule__ImportStatement__Group__0 ) ) ;
    public final void ruleImportStatement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:129:2: ( ( ( rule__ImportStatement__Group__0 ) ) )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:130:1: ( ( rule__ImportStatement__Group__0 ) )
            {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:130:1: ( ( rule__ImportStatement__Group__0 ) )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:131:1: ( rule__ImportStatement__Group__0 )
            {
             before(grammarAccess.getImportStatementAccess().getGroup()); 
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:132:1: ( rule__ImportStatement__Group__0 )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:132:2: rule__ImportStatement__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ImportStatement__Group__0_in_ruleImportStatement214);
            rule__ImportStatement__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getImportStatementAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleImportStatement"


    // $ANTLR start "rule__EMFExecutionConfiguration__Group__0"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:148:1: rule__EMFExecutionConfiguration__Group__0 : rule__EMFExecutionConfiguration__Group__0__Impl rule__EMFExecutionConfiguration__Group__1 ;
    public final void rule__EMFExecutionConfiguration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:152:1: ( rule__EMFExecutionConfiguration__Group__0__Impl rule__EMFExecutionConfiguration__Group__1 )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:153:2: rule__EMFExecutionConfiguration__Group__0__Impl rule__EMFExecutionConfiguration__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EMFExecutionConfiguration__Group__0__Impl_in_rule__EMFExecutionConfiguration__Group__0250);
            rule__EMFExecutionConfiguration__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__EMFExecutionConfiguration__Group__1_in_rule__EMFExecutionConfiguration__Group__0253);
            rule__EMFExecutionConfiguration__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EMFExecutionConfiguration__Group__0"


    // $ANTLR start "rule__EMFExecutionConfiguration__Group__0__Impl"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:160:1: rule__EMFExecutionConfiguration__Group__0__Impl : ( ( ( rule__EMFExecutionConfiguration__ImportsAssignment_0 ) ) ( ( rule__EMFExecutionConfiguration__ImportsAssignment_0 )* ) ) ;
    public final void rule__EMFExecutionConfiguration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:164:1: ( ( ( ( rule__EMFExecutionConfiguration__ImportsAssignment_0 ) ) ( ( rule__EMFExecutionConfiguration__ImportsAssignment_0 )* ) ) )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:165:1: ( ( ( rule__EMFExecutionConfiguration__ImportsAssignment_0 ) ) ( ( rule__EMFExecutionConfiguration__ImportsAssignment_0 )* ) )
            {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:165:1: ( ( ( rule__EMFExecutionConfiguration__ImportsAssignment_0 ) ) ( ( rule__EMFExecutionConfiguration__ImportsAssignment_0 )* ) )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:166:1: ( ( rule__EMFExecutionConfiguration__ImportsAssignment_0 ) ) ( ( rule__EMFExecutionConfiguration__ImportsAssignment_0 )* )
            {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:166:1: ( ( rule__EMFExecutionConfiguration__ImportsAssignment_0 ) )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:167:1: ( rule__EMFExecutionConfiguration__ImportsAssignment_0 )
            {
             before(grammarAccess.getEMFExecutionConfigurationAccess().getImportsAssignment_0()); 
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:168:1: ( rule__EMFExecutionConfiguration__ImportsAssignment_0 )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:168:2: rule__EMFExecutionConfiguration__ImportsAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__EMFExecutionConfiguration__ImportsAssignment_0_in_rule__EMFExecutionConfiguration__Group__0__Impl282);
            rule__EMFExecutionConfiguration__ImportsAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getEMFExecutionConfigurationAccess().getImportsAssignment_0()); 

            }

            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:171:1: ( ( rule__EMFExecutionConfiguration__ImportsAssignment_0 )* )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:172:1: ( rule__EMFExecutionConfiguration__ImportsAssignment_0 )*
            {
             before(grammarAccess.getEMFExecutionConfigurationAccess().getImportsAssignment_0()); 
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:173:1: ( rule__EMFExecutionConfiguration__ImportsAssignment_0 )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==17) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:173:2: rule__EMFExecutionConfiguration__ImportsAssignment_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__EMFExecutionConfiguration__ImportsAssignment_0_in_rule__EMFExecutionConfiguration__Group__0__Impl294);
            	    rule__EMFExecutionConfiguration__ImportsAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getEMFExecutionConfigurationAccess().getImportsAssignment_0()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EMFExecutionConfiguration__Group__0__Impl"


    // $ANTLR start "rule__EMFExecutionConfiguration__Group__1"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:184:1: rule__EMFExecutionConfiguration__Group__1 : rule__EMFExecutionConfiguration__Group__1__Impl ;
    public final void rule__EMFExecutionConfiguration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:188:1: ( rule__EMFExecutionConfiguration__Group__1__Impl )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:189:2: rule__EMFExecutionConfiguration__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__EMFExecutionConfiguration__Group__1__Impl_in_rule__EMFExecutionConfiguration__Group__1327);
            rule__EMFExecutionConfiguration__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EMFExecutionConfiguration__Group__1"


    // $ANTLR start "rule__EMFExecutionConfiguration__Group__1__Impl"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:195:1: rule__EMFExecutionConfiguration__Group__1__Impl : ( ( rule__EMFExecutionConfiguration__ForcedClockMappingsAssignment_1 )* ) ;
    public final void rule__EMFExecutionConfiguration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:199:1: ( ( ( rule__EMFExecutionConfiguration__ForcedClockMappingsAssignment_1 )* ) )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:200:1: ( ( rule__EMFExecutionConfiguration__ForcedClockMappingsAssignment_1 )* )
            {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:200:1: ( ( rule__EMFExecutionConfiguration__ForcedClockMappingsAssignment_1 )* )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:201:1: ( rule__EMFExecutionConfiguration__ForcedClockMappingsAssignment_1 )*
            {
             before(grammarAccess.getEMFExecutionConfigurationAccess().getForcedClockMappingsAssignment_1()); 
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:202:1: ( rule__EMFExecutionConfiguration__ForcedClockMappingsAssignment_1 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==11) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:202:2: rule__EMFExecutionConfiguration__ForcedClockMappingsAssignment_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__EMFExecutionConfiguration__ForcedClockMappingsAssignment_1_in_rule__EMFExecutionConfiguration__Group__1__Impl354);
            	    rule__EMFExecutionConfiguration__ForcedClockMappingsAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

             after(grammarAccess.getEMFExecutionConfigurationAccess().getForcedClockMappingsAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EMFExecutionConfiguration__Group__1__Impl"


    // $ANTLR start "rule__ForcedClockMapping__Group__0"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:216:1: rule__ForcedClockMapping__Group__0 : rule__ForcedClockMapping__Group__0__Impl rule__ForcedClockMapping__Group__1 ;
    public final void rule__ForcedClockMapping__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:220:1: ( rule__ForcedClockMapping__Group__0__Impl rule__ForcedClockMapping__Group__1 )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:221:2: rule__ForcedClockMapping__Group__0__Impl rule__ForcedClockMapping__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ForcedClockMapping__Group__0__Impl_in_rule__ForcedClockMapping__Group__0389);
            rule__ForcedClockMapping__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ForcedClockMapping__Group__1_in_rule__ForcedClockMapping__Group__0392);
            rule__ForcedClockMapping__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForcedClockMapping__Group__0"


    // $ANTLR start "rule__ForcedClockMapping__Group__0__Impl"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:228:1: rule__ForcedClockMapping__Group__0__Impl : ( 'When' ) ;
    public final void rule__ForcedClockMapping__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:232:1: ( ( 'When' ) )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:233:1: ( 'When' )
            {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:233:1: ( 'When' )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:234:1: 'When'
            {
             before(grammarAccess.getForcedClockMappingAccess().getWhenKeyword_0()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__ForcedClockMapping__Group__0__Impl420); 
             after(grammarAccess.getForcedClockMappingAccess().getWhenKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForcedClockMapping__Group__0__Impl"


    // $ANTLR start "rule__ForcedClockMapping__Group__1"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:247:1: rule__ForcedClockMapping__Group__1 : rule__ForcedClockMapping__Group__1__Impl rule__ForcedClockMapping__Group__2 ;
    public final void rule__ForcedClockMapping__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:251:1: ( rule__ForcedClockMapping__Group__1__Impl rule__ForcedClockMapping__Group__2 )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:252:2: rule__ForcedClockMapping__Group__1__Impl rule__ForcedClockMapping__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__ForcedClockMapping__Group__1__Impl_in_rule__ForcedClockMapping__Group__1451);
            rule__ForcedClockMapping__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ForcedClockMapping__Group__2_in_rule__ForcedClockMapping__Group__1454);
            rule__ForcedClockMapping__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForcedClockMapping__Group__1"


    // $ANTLR start "rule__ForcedClockMapping__Group__1__Impl"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:259:1: rule__ForcedClockMapping__Group__1__Impl : ( ( rule__ForcedClockMapping__ClockAssignment_1 ) ) ;
    public final void rule__ForcedClockMapping__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:263:1: ( ( ( rule__ForcedClockMapping__ClockAssignment_1 ) ) )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:264:1: ( ( rule__ForcedClockMapping__ClockAssignment_1 ) )
            {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:264:1: ( ( rule__ForcedClockMapping__ClockAssignment_1 ) )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:265:1: ( rule__ForcedClockMapping__ClockAssignment_1 )
            {
             before(grammarAccess.getForcedClockMappingAccess().getClockAssignment_1()); 
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:266:1: ( rule__ForcedClockMapping__ClockAssignment_1 )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:266:2: rule__ForcedClockMapping__ClockAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ForcedClockMapping__ClockAssignment_1_in_rule__ForcedClockMapping__Group__1__Impl481);
            rule__ForcedClockMapping__ClockAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getForcedClockMappingAccess().getClockAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForcedClockMapping__Group__1__Impl"


    // $ANTLR start "rule__ForcedClockMapping__Group__2"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:276:1: rule__ForcedClockMapping__Group__2 : rule__ForcedClockMapping__Group__2__Impl rule__ForcedClockMapping__Group__3 ;
    public final void rule__ForcedClockMapping__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:280:1: ( rule__ForcedClockMapping__Group__2__Impl rule__ForcedClockMapping__Group__3 )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:281:2: rule__ForcedClockMapping__Group__2__Impl rule__ForcedClockMapping__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__ForcedClockMapping__Group__2__Impl_in_rule__ForcedClockMapping__Group__2511);
            rule__ForcedClockMapping__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ForcedClockMapping__Group__3_in_rule__ForcedClockMapping__Group__2514);
            rule__ForcedClockMapping__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForcedClockMapping__Group__2"


    // $ANTLR start "rule__ForcedClockMapping__Group__2__Impl"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:288:1: rule__ForcedClockMapping__Group__2__Impl : ( 'DSA' ) ;
    public final void rule__ForcedClockMapping__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:292:1: ( ( 'DSA' ) )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:293:1: ( 'DSA' )
            {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:293:1: ( 'DSA' )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:294:1: 'DSA'
            {
             before(grammarAccess.getForcedClockMappingAccess().getDSAKeyword_2()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__ForcedClockMapping__Group__2__Impl542); 
             after(grammarAccess.getForcedClockMappingAccess().getDSAKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForcedClockMapping__Group__2__Impl"


    // $ANTLR start "rule__ForcedClockMapping__Group__3"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:307:1: rule__ForcedClockMapping__Group__3 : rule__ForcedClockMapping__Group__3__Impl rule__ForcedClockMapping__Group__4 ;
    public final void rule__ForcedClockMapping__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:311:1: ( rule__ForcedClockMapping__Group__3__Impl rule__ForcedClockMapping__Group__4 )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:312:2: rule__ForcedClockMapping__Group__3__Impl rule__ForcedClockMapping__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__ForcedClockMapping__Group__3__Impl_in_rule__ForcedClockMapping__Group__3573);
            rule__ForcedClockMapping__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ForcedClockMapping__Group__4_in_rule__ForcedClockMapping__Group__3576);
            rule__ForcedClockMapping__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForcedClockMapping__Group__3"


    // $ANTLR start "rule__ForcedClockMapping__Group__3__Impl"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:319:1: rule__ForcedClockMapping__Group__3__Impl : ( 'returns' ) ;
    public final void rule__ForcedClockMapping__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:323:1: ( ( 'returns' ) )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:324:1: ( 'returns' )
            {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:324:1: ( 'returns' )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:325:1: 'returns'
            {
             before(grammarAccess.getForcedClockMappingAccess().getReturnsKeyword_3()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__ForcedClockMapping__Group__3__Impl604); 
             after(grammarAccess.getForcedClockMappingAccess().getReturnsKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForcedClockMapping__Group__3__Impl"


    // $ANTLR start "rule__ForcedClockMapping__Group__4"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:338:1: rule__ForcedClockMapping__Group__4 : rule__ForcedClockMapping__Group__4__Impl rule__ForcedClockMapping__Group__5 ;
    public final void rule__ForcedClockMapping__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:342:1: ( rule__ForcedClockMapping__Group__4__Impl rule__ForcedClockMapping__Group__5 )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:343:2: rule__ForcedClockMapping__Group__4__Impl rule__ForcedClockMapping__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__ForcedClockMapping__Group__4__Impl_in_rule__ForcedClockMapping__Group__4635);
            rule__ForcedClockMapping__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ForcedClockMapping__Group__5_in_rule__ForcedClockMapping__Group__4638);
            rule__ForcedClockMapping__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForcedClockMapping__Group__4"


    // $ANTLR start "rule__ForcedClockMapping__Group__4__Impl"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:350:1: rule__ForcedClockMapping__Group__4__Impl : ( 'true' ) ;
    public final void rule__ForcedClockMapping__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:354:1: ( ( 'true' ) )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:355:1: ( 'true' )
            {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:355:1: ( 'true' )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:356:1: 'true'
            {
             before(grammarAccess.getForcedClockMappingAccess().getTrueKeyword_4()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__ForcedClockMapping__Group__4__Impl666); 
             after(grammarAccess.getForcedClockMappingAccess().getTrueKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForcedClockMapping__Group__4__Impl"


    // $ANTLR start "rule__ForcedClockMapping__Group__5"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:369:1: rule__ForcedClockMapping__Group__5 : rule__ForcedClockMapping__Group__5__Impl rule__ForcedClockMapping__Group__6 ;
    public final void rule__ForcedClockMapping__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:373:1: ( rule__ForcedClockMapping__Group__5__Impl rule__ForcedClockMapping__Group__6 )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:374:2: rule__ForcedClockMapping__Group__5__Impl rule__ForcedClockMapping__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__ForcedClockMapping__Group__5__Impl_in_rule__ForcedClockMapping__Group__5697);
            rule__ForcedClockMapping__Group__5__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ForcedClockMapping__Group__6_in_rule__ForcedClockMapping__Group__5700);
            rule__ForcedClockMapping__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForcedClockMapping__Group__5"


    // $ANTLR start "rule__ForcedClockMapping__Group__5__Impl"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:381:1: rule__ForcedClockMapping__Group__5__Impl : ( 'avoid' ) ;
    public final void rule__ForcedClockMapping__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:385:1: ( ( 'avoid' ) )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:386:1: ( 'avoid' )
            {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:386:1: ( 'avoid' )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:387:1: 'avoid'
            {
             before(grammarAccess.getForcedClockMappingAccess().getAvoidKeyword_5()); 
            match(input,15,FollowSets000.FOLLOW_15_in_rule__ForcedClockMapping__Group__5__Impl728); 
             after(grammarAccess.getForcedClockMappingAccess().getAvoidKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForcedClockMapping__Group__5__Impl"


    // $ANTLR start "rule__ForcedClockMapping__Group__6"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:400:1: rule__ForcedClockMapping__Group__6 : rule__ForcedClockMapping__Group__6__Impl rule__ForcedClockMapping__Group__7 ;
    public final void rule__ForcedClockMapping__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:404:1: ( rule__ForcedClockMapping__Group__6__Impl rule__ForcedClockMapping__Group__7 )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:405:2: rule__ForcedClockMapping__Group__6__Impl rule__ForcedClockMapping__Group__7
            {
            pushFollow(FollowSets000.FOLLOW_rule__ForcedClockMapping__Group__6__Impl_in_rule__ForcedClockMapping__Group__6759);
            rule__ForcedClockMapping__Group__6__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ForcedClockMapping__Group__7_in_rule__ForcedClockMapping__Group__6762);
            rule__ForcedClockMapping__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForcedClockMapping__Group__6"


    // $ANTLR start "rule__ForcedClockMapping__Group__6__Impl"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:412:1: rule__ForcedClockMapping__Group__6__Impl : ( ( rule__ForcedClockMapping__ClockToAvoidWhenTrueAssignment_6 ) ) ;
    public final void rule__ForcedClockMapping__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:416:1: ( ( ( rule__ForcedClockMapping__ClockToAvoidWhenTrueAssignment_6 ) ) )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:417:1: ( ( rule__ForcedClockMapping__ClockToAvoidWhenTrueAssignment_6 ) )
            {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:417:1: ( ( rule__ForcedClockMapping__ClockToAvoidWhenTrueAssignment_6 ) )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:418:1: ( rule__ForcedClockMapping__ClockToAvoidWhenTrueAssignment_6 )
            {
             before(grammarAccess.getForcedClockMappingAccess().getClockToAvoidWhenTrueAssignment_6()); 
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:419:1: ( rule__ForcedClockMapping__ClockToAvoidWhenTrueAssignment_6 )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:419:2: rule__ForcedClockMapping__ClockToAvoidWhenTrueAssignment_6
            {
            pushFollow(FollowSets000.FOLLOW_rule__ForcedClockMapping__ClockToAvoidWhenTrueAssignment_6_in_rule__ForcedClockMapping__Group__6__Impl789);
            rule__ForcedClockMapping__ClockToAvoidWhenTrueAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getForcedClockMappingAccess().getClockToAvoidWhenTrueAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForcedClockMapping__Group__6__Impl"


    // $ANTLR start "rule__ForcedClockMapping__Group__7"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:429:1: rule__ForcedClockMapping__Group__7 : rule__ForcedClockMapping__Group__7__Impl ;
    public final void rule__ForcedClockMapping__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:433:1: ( rule__ForcedClockMapping__Group__7__Impl )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:434:2: rule__ForcedClockMapping__Group__7__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ForcedClockMapping__Group__7__Impl_in_rule__ForcedClockMapping__Group__7819);
            rule__ForcedClockMapping__Group__7__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForcedClockMapping__Group__7"


    // $ANTLR start "rule__ForcedClockMapping__Group__7__Impl"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:440:1: rule__ForcedClockMapping__Group__7__Impl : ( ';' ) ;
    public final void rule__ForcedClockMapping__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:444:1: ( ( ';' ) )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:445:1: ( ';' )
            {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:445:1: ( ';' )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:446:1: ';'
            {
             before(grammarAccess.getForcedClockMappingAccess().getSemicolonKeyword_7()); 
            match(input,16,FollowSets000.FOLLOW_16_in_rule__ForcedClockMapping__Group__7__Impl847); 
             after(grammarAccess.getForcedClockMappingAccess().getSemicolonKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForcedClockMapping__Group__7__Impl"


    // $ANTLR start "rule__ImportStatement__Group__0"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:475:1: rule__ImportStatement__Group__0 : rule__ImportStatement__Group__0__Impl rule__ImportStatement__Group__1 ;
    public final void rule__ImportStatement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:479:1: ( rule__ImportStatement__Group__0__Impl rule__ImportStatement__Group__1 )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:480:2: rule__ImportStatement__Group__0__Impl rule__ImportStatement__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ImportStatement__Group__0__Impl_in_rule__ImportStatement__Group__0894);
            rule__ImportStatement__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ImportStatement__Group__1_in_rule__ImportStatement__Group__0897);
            rule__ImportStatement__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportStatement__Group__0"


    // $ANTLR start "rule__ImportStatement__Group__0__Impl"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:487:1: rule__ImportStatement__Group__0__Impl : ( 'import' ) ;
    public final void rule__ImportStatement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:491:1: ( ( 'import' ) )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:492:1: ( 'import' )
            {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:492:1: ( 'import' )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:493:1: 'import'
            {
             before(grammarAccess.getImportStatementAccess().getImportKeyword_0()); 
            match(input,17,FollowSets000.FOLLOW_17_in_rule__ImportStatement__Group__0__Impl925); 
             after(grammarAccess.getImportStatementAccess().getImportKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportStatement__Group__0__Impl"


    // $ANTLR start "rule__ImportStatement__Group__1"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:506:1: rule__ImportStatement__Group__1 : rule__ImportStatement__Group__1__Impl rule__ImportStatement__Group__2 ;
    public final void rule__ImportStatement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:510:1: ( rule__ImportStatement__Group__1__Impl rule__ImportStatement__Group__2 )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:511:2: rule__ImportStatement__Group__1__Impl rule__ImportStatement__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__ImportStatement__Group__1__Impl_in_rule__ImportStatement__Group__1956);
            rule__ImportStatement__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ImportStatement__Group__2_in_rule__ImportStatement__Group__1959);
            rule__ImportStatement__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportStatement__Group__1"


    // $ANTLR start "rule__ImportStatement__Group__1__Impl"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:518:1: rule__ImportStatement__Group__1__Impl : ( ( rule__ImportStatement__ImportURIAssignment_1 ) ) ;
    public final void rule__ImportStatement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:522:1: ( ( ( rule__ImportStatement__ImportURIAssignment_1 ) ) )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:523:1: ( ( rule__ImportStatement__ImportURIAssignment_1 ) )
            {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:523:1: ( ( rule__ImportStatement__ImportURIAssignment_1 ) )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:524:1: ( rule__ImportStatement__ImportURIAssignment_1 )
            {
             before(grammarAccess.getImportStatementAccess().getImportURIAssignment_1()); 
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:525:1: ( rule__ImportStatement__ImportURIAssignment_1 )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:525:2: rule__ImportStatement__ImportURIAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ImportStatement__ImportURIAssignment_1_in_rule__ImportStatement__Group__1__Impl986);
            rule__ImportStatement__ImportURIAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getImportStatementAccess().getImportURIAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportStatement__Group__1__Impl"


    // $ANTLR start "rule__ImportStatement__Group__2"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:535:1: rule__ImportStatement__Group__2 : rule__ImportStatement__Group__2__Impl ;
    public final void rule__ImportStatement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:539:1: ( rule__ImportStatement__Group__2__Impl )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:540:2: rule__ImportStatement__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ImportStatement__Group__2__Impl_in_rule__ImportStatement__Group__21016);
            rule__ImportStatement__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportStatement__Group__2"


    // $ANTLR start "rule__ImportStatement__Group__2__Impl"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:546:1: rule__ImportStatement__Group__2__Impl : ( ';' ) ;
    public final void rule__ImportStatement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:550:1: ( ( ';' ) )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:551:1: ( ';' )
            {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:551:1: ( ';' )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:552:1: ';'
            {
             before(grammarAccess.getImportStatementAccess().getSemicolonKeyword_2()); 
            match(input,16,FollowSets000.FOLLOW_16_in_rule__ImportStatement__Group__2__Impl1044); 
             after(grammarAccess.getImportStatementAccess().getSemicolonKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportStatement__Group__2__Impl"


    // $ANTLR start "rule__EMFExecutionConfiguration__ImportsAssignment_0"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:573:1: rule__EMFExecutionConfiguration__ImportsAssignment_0 : ( ruleImportStatement ) ;
    public final void rule__EMFExecutionConfiguration__ImportsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:577:1: ( ( ruleImportStatement ) )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:578:1: ( ruleImportStatement )
            {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:578:1: ( ruleImportStatement )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:579:1: ruleImportStatement
            {
             before(grammarAccess.getEMFExecutionConfigurationAccess().getImportsImportStatementParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleImportStatement_in_rule__EMFExecutionConfiguration__ImportsAssignment_01087);
            ruleImportStatement();

            state._fsp--;

             after(grammarAccess.getEMFExecutionConfigurationAccess().getImportsImportStatementParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EMFExecutionConfiguration__ImportsAssignment_0"


    // $ANTLR start "rule__EMFExecutionConfiguration__ForcedClockMappingsAssignment_1"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:588:1: rule__EMFExecutionConfiguration__ForcedClockMappingsAssignment_1 : ( ruleForcedClockMapping ) ;
    public final void rule__EMFExecutionConfiguration__ForcedClockMappingsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:592:1: ( ( ruleForcedClockMapping ) )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:593:1: ( ruleForcedClockMapping )
            {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:593:1: ( ruleForcedClockMapping )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:594:1: ruleForcedClockMapping
            {
             before(grammarAccess.getEMFExecutionConfigurationAccess().getForcedClockMappingsForcedClockMappingParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleForcedClockMapping_in_rule__EMFExecutionConfiguration__ForcedClockMappingsAssignment_11118);
            ruleForcedClockMapping();

            state._fsp--;

             after(grammarAccess.getEMFExecutionConfigurationAccess().getForcedClockMappingsForcedClockMappingParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EMFExecutionConfiguration__ForcedClockMappingsAssignment_1"


    // $ANTLR start "rule__ForcedClockMapping__ClockAssignment_1"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:603:1: rule__ForcedClockMapping__ClockAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__ForcedClockMapping__ClockAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:607:1: ( ( ( RULE_ID ) ) )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:608:1: ( ( RULE_ID ) )
            {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:608:1: ( ( RULE_ID ) )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:609:1: ( RULE_ID )
            {
             before(grammarAccess.getForcedClockMappingAccess().getClockClockCrossReference_1_0()); 
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:610:1: ( RULE_ID )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:611:1: RULE_ID
            {
             before(grammarAccess.getForcedClockMappingAccess().getClockClockIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__ForcedClockMapping__ClockAssignment_11153); 
             after(grammarAccess.getForcedClockMappingAccess().getClockClockIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getForcedClockMappingAccess().getClockClockCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForcedClockMapping__ClockAssignment_1"


    // $ANTLR start "rule__ForcedClockMapping__ClockToAvoidWhenTrueAssignment_6"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:622:1: rule__ForcedClockMapping__ClockToAvoidWhenTrueAssignment_6 : ( ( RULE_ID ) ) ;
    public final void rule__ForcedClockMapping__ClockToAvoidWhenTrueAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:626:1: ( ( ( RULE_ID ) ) )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:627:1: ( ( RULE_ID ) )
            {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:627:1: ( ( RULE_ID ) )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:628:1: ( RULE_ID )
            {
             before(grammarAccess.getForcedClockMappingAccess().getClockToAvoidWhenTrueClockCrossReference_6_0()); 
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:629:1: ( RULE_ID )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:630:1: RULE_ID
            {
             before(grammarAccess.getForcedClockMappingAccess().getClockToAvoidWhenTrueClockIDTerminalRuleCall_6_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__ForcedClockMapping__ClockToAvoidWhenTrueAssignment_61192); 
             after(grammarAccess.getForcedClockMappingAccess().getClockToAvoidWhenTrueClockIDTerminalRuleCall_6_0_1()); 

            }

             after(grammarAccess.getForcedClockMappingAccess().getClockToAvoidWhenTrueClockCrossReference_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForcedClockMapping__ClockToAvoidWhenTrueAssignment_6"


    // $ANTLR start "rule__ImportStatement__ImportURIAssignment_1"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:641:1: rule__ImportStatement__ImportURIAssignment_1 : ( RULE_STRING ) ;
    public final void rule__ImportStatement__ImportURIAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:645:1: ( ( RULE_STRING ) )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:646:1: ( RULE_STRING )
            {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:646:1: ( RULE_STRING )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:647:1: RULE_STRING
            {
             before(grammarAccess.getImportStatementAccess().getImportURISTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__ImportStatement__ImportURIAssignment_11227); 
             after(grammarAccess.getImportStatementAccess().getImportURISTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportStatement__ImportURIAssignment_1"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleEMFExecutionConfiguration_in_entryRuleEMFExecutionConfiguration61 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEMFExecutionConfiguration68 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EMFExecutionConfiguration__Group__0_in_ruleEMFExecutionConfiguration94 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleForcedClockMapping_in_entryRuleForcedClockMapping121 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleForcedClockMapping128 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ForcedClockMapping__Group__0_in_ruleForcedClockMapping154 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImportStatement_in_entryRuleImportStatement181 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleImportStatement188 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ImportStatement__Group__0_in_ruleImportStatement214 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EMFExecutionConfiguration__Group__0__Impl_in_rule__EMFExecutionConfiguration__Group__0250 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_rule__EMFExecutionConfiguration__Group__1_in_rule__EMFExecutionConfiguration__Group__0253 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EMFExecutionConfiguration__ImportsAssignment_0_in_rule__EMFExecutionConfiguration__Group__0__Impl282 = new BitSet(new long[]{0x0000000000020002L});
        public static final BitSet FOLLOW_rule__EMFExecutionConfiguration__ImportsAssignment_0_in_rule__EMFExecutionConfiguration__Group__0__Impl294 = new BitSet(new long[]{0x0000000000020002L});
        public static final BitSet FOLLOW_rule__EMFExecutionConfiguration__Group__1__Impl_in_rule__EMFExecutionConfiguration__Group__1327 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EMFExecutionConfiguration__ForcedClockMappingsAssignment_1_in_rule__EMFExecutionConfiguration__Group__1__Impl354 = new BitSet(new long[]{0x0000000000000802L});
        public static final BitSet FOLLOW_rule__ForcedClockMapping__Group__0__Impl_in_rule__ForcedClockMapping__Group__0389 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__ForcedClockMapping__Group__1_in_rule__ForcedClockMapping__Group__0392 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__ForcedClockMapping__Group__0__Impl420 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ForcedClockMapping__Group__1__Impl_in_rule__ForcedClockMapping__Group__1451 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_rule__ForcedClockMapping__Group__2_in_rule__ForcedClockMapping__Group__1454 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ForcedClockMapping__ClockAssignment_1_in_rule__ForcedClockMapping__Group__1__Impl481 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ForcedClockMapping__Group__2__Impl_in_rule__ForcedClockMapping__Group__2511 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__ForcedClockMapping__Group__3_in_rule__ForcedClockMapping__Group__2514 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__ForcedClockMapping__Group__2__Impl542 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ForcedClockMapping__Group__3__Impl_in_rule__ForcedClockMapping__Group__3573 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_rule__ForcedClockMapping__Group__4_in_rule__ForcedClockMapping__Group__3576 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__ForcedClockMapping__Group__3__Impl604 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ForcedClockMapping__Group__4__Impl_in_rule__ForcedClockMapping__Group__4635 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_rule__ForcedClockMapping__Group__5_in_rule__ForcedClockMapping__Group__4638 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__ForcedClockMapping__Group__4__Impl666 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ForcedClockMapping__Group__5__Impl_in_rule__ForcedClockMapping__Group__5697 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__ForcedClockMapping__Group__6_in_rule__ForcedClockMapping__Group__5700 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__ForcedClockMapping__Group__5__Impl728 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ForcedClockMapping__Group__6__Impl_in_rule__ForcedClockMapping__Group__6759 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_rule__ForcedClockMapping__Group__7_in_rule__ForcedClockMapping__Group__6762 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ForcedClockMapping__ClockToAvoidWhenTrueAssignment_6_in_rule__ForcedClockMapping__Group__6__Impl789 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ForcedClockMapping__Group__7__Impl_in_rule__ForcedClockMapping__Group__7819 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__ForcedClockMapping__Group__7__Impl847 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ImportStatement__Group__0__Impl_in_rule__ImportStatement__Group__0894 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__ImportStatement__Group__1_in_rule__ImportStatement__Group__0897 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__ImportStatement__Group__0__Impl925 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ImportStatement__Group__1__Impl_in_rule__ImportStatement__Group__1956 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_rule__ImportStatement__Group__2_in_rule__ImportStatement__Group__1959 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ImportStatement__ImportURIAssignment_1_in_rule__ImportStatement__Group__1__Impl986 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ImportStatement__Group__2__Impl_in_rule__ImportStatement__Group__21016 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__ImportStatement__Group__2__Impl1044 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImportStatement_in_rule__EMFExecutionConfiguration__ImportsAssignment_01087 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleForcedClockMapping_in_rule__EMFExecutionConfiguration__ForcedClockMappingsAssignment_11118 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__ForcedClockMapping__ClockAssignment_11153 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__ForcedClockMapping__ClockToAvoidWhenTrueAssignment_61192 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__ImportStatement__ImportURIAssignment_11227 = new BitSet(new long[]{0x0000000000000002L});
    }


}