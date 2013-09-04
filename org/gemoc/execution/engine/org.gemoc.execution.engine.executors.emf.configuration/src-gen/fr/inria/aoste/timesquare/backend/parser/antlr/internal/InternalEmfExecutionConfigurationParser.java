package fr.inria.aoste.timesquare.backend.parser.antlr.internal;

import org.antlr.runtime.BitSet;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;

import fr.inria.aoste.timesquare.backend.services.EmfExecutionConfigurationGrammarAccess;

@SuppressWarnings("all")
public class InternalEmfExecutionConfigurationParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] { "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID",
            "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'When'",
            "'DSA'", "'returns'", "'true'", "'avoid'", "';'", "'import'", "'importJar'" };
    public static final int RULE_ID = 4;
    public static final int RULE_STRING = 5;
    public static final int T__16 = 16;
    public static final int T__15 = 15;
    public static final int T__18 = 18;
    public static final int T__17 = 17;
    public static final int T__12 = 12;
    public static final int T__11 = 11;
    public static final int T__14 = 14;
    public static final int T__13 = 13;
    public static final int RULE_ANY_OTHER = 10;
    public static final int RULE_INT = 6;
    public static final int RULE_WS = 9;
    public static final int RULE_SL_COMMENT = 8;
    public static final int EOF = -1;
    public static final int RULE_ML_COMMENT = 7;

    // delegates
    // delegators

    private EmfExecutionConfigurationGrammarAccess grammarAccess;
    public static final BitSet FOLLOW_ruleEMFExecutionConfiguration_in_entryRuleEMFExecutionConfiguration81 = new BitSet(
            new long[] { 0x0000000000000000L });

    public static final BitSet FOLLOW_EOF_in_entryRuleEMFExecutionConfiguration91 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_ruleImportStatement_in_ruleEMFExecutionConfiguration137 = new BitSet(
            new long[] { 0x0000000000060000L });

    /*
     * This grammar contains a lot of empty actions to work around a bug in
     * ANTLR. Otherwise the ANTLR tool will create synpreds that cannot be
     * compiled in some rare cases.
     */

    public static final BitSet FOLLOW_ruleJarImportStatement_in_ruleEMFExecutionConfiguration159 = new BitSet(
            new long[] { 0x0000000000000802L });

    public static final BitSet FOLLOW_ruleForcedClockMapping_in_ruleEMFExecutionConfiguration180 = new BitSet(
            new long[] { 0x0000000000000802L });

    public static final BitSet FOLLOW_ruleForcedClockMapping_in_entryRuleForcedClockMapping217 = new BitSet(
            new long[] { 0x0000000000000000L });

    public static final BitSet FOLLOW_EOF_in_entryRuleForcedClockMapping227 = new BitSet(
            new long[] { 0x0000000000000002L });

    public static final BitSet FOLLOW_11_in_ruleForcedClockMapping264 = new BitSet(new long[] { 0x0000000000000010L });

    public static final BitSet FOLLOW_RULE_ID_in_ruleForcedClockMapping288 = new BitSet(
            new long[] { 0x0000000000001000L });

    public static final BitSet FOLLOW_12_in_ruleForcedClockMapping300 = new BitSet(new long[] { 0x0000000000002000L });

    public static final BitSet FOLLOW_13_in_ruleForcedClockMapping312 = new BitSet(new long[] { 0x0000000000004000L });

    public static final BitSet FOLLOW_14_in_ruleForcedClockMapping324 = new BitSet(new long[] { 0x0000000000008000L });

    public static final BitSet FOLLOW_15_in_ruleForcedClockMapping336 = new BitSet(new long[] { 0x0000000000000010L });

    public static final BitSet FOLLOW_RULE_ID_in_ruleForcedClockMapping360 = new BitSet(
            new long[] { 0x0000000000010000L });

    public static final BitSet FOLLOW_16_in_ruleForcedClockMapping372 = new BitSet(new long[] { 0x0000000000000002L });

    // Delegated rules

    public static final BitSet FOLLOW_ruleImportStatement_in_entryRuleImportStatement408 = new BitSet(
            new long[] { 0x0000000000000000L });
    public static final BitSet FOLLOW_EOF_in_entryRuleImportStatement418 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_17_in_ruleImportStatement455 = new BitSet(new long[] { 0x0000000000000020L });
    public static final BitSet FOLLOW_RULE_STRING_in_ruleImportStatement472 = new BitSet(
            new long[] { 0x0000000000010000L });
    public static final BitSet FOLLOW_16_in_ruleImportStatement489 = new BitSet(new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_ruleJarImportStatement_in_entryRuleJarImportStatement525 = new BitSet(
            new long[] { 0x0000000000000000L });
    public static final BitSet FOLLOW_EOF_in_entryRuleJarImportStatement535 = new BitSet(
            new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_18_in_ruleJarImportStatement572 = new BitSet(new long[] { 0x0000000000000020L });
    public static final BitSet FOLLOW_RULE_STRING_in_ruleJarImportStatement589 = new BitSet(
            new long[] { 0x0000000000010000L });
    public static final BitSet FOLLOW_16_in_ruleJarImportStatement606 = new BitSet(new long[] { 0x0000000000000002L });

    public InternalEmfExecutionConfigurationParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }

    public InternalEmfExecutionConfigurationParser(TokenStream input,
            EmfExecutionConfigurationGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        this.registerRules(grammarAccess.getGrammar());
    }

    public InternalEmfExecutionConfigurationParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);

    }

    // $ANTLR start "entryRuleEMFExecutionConfiguration"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:73:1:
    // entryRuleEMFExecutionConfiguration returns [EObject current=null] :
    // iv_ruleEMFExecutionConfiguration= ruleEMFExecutionConfiguration EOF ;
    public final EObject entryRuleEMFExecutionConfiguration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEMFExecutionConfiguration = null;

        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:74:2:
            // (iv_ruleEMFExecutionConfiguration= ruleEMFExecutionConfiguration
            // EOF )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:75:2:
            // iv_ruleEMFExecutionConfiguration= ruleEMFExecutionConfiguration
            // EOF
            {
                if (this.state.backtracking == 0) {
                    this.newCompositeNode(this.grammarAccess.getEMFExecutionConfigurationRule());
                }
                this.pushFollow(InternalEmfExecutionConfigurationParser.FOLLOW_ruleEMFExecutionConfiguration_in_entryRuleEMFExecutionConfiguration81);
                iv_ruleEMFExecutionConfiguration = this.ruleEMFExecutionConfiguration();

                this.state._fsp--;
                if (this.state.failed) {
                    return current;
                }
                if (this.state.backtracking == 0) {
                    current = iv_ruleEMFExecutionConfiguration;
                }
                this.match(this.input, InternalEmfExecutionConfigurationParser.EOF,
                        InternalEmfExecutionConfigurationParser.FOLLOW_EOF_in_entryRuleEMFExecutionConfiguration91);
                if (this.state.failed) {
                    return current;
                }

            }

        }

        catch (RecognitionException re) {
            this.recover(this.input, re);
            this.appendSkippedTokens();
        } finally {
        }
        return current;
    }

    // $ANTLR end "entryRuleEMFExecutionConfiguration"
    // $ANTLR start "entryRuleForcedClockMapping"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:148:1:
    // entryRuleForcedClockMapping returns [EObject current=null] :
    // iv_ruleForcedClockMapping= ruleForcedClockMapping EOF ;
    public final EObject entryRuleForcedClockMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForcedClockMapping = null;

        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:149:2:
            // (iv_ruleForcedClockMapping= ruleForcedClockMapping EOF )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:150:2:
            // iv_ruleForcedClockMapping= ruleForcedClockMapping EOF
            {
                if (this.state.backtracking == 0) {
                    this.newCompositeNode(this.grammarAccess.getForcedClockMappingRule());
                }
                this.pushFollow(InternalEmfExecutionConfigurationParser.FOLLOW_ruleForcedClockMapping_in_entryRuleForcedClockMapping217);
                iv_ruleForcedClockMapping = this.ruleForcedClockMapping();

                this.state._fsp--;
                if (this.state.failed) {
                    return current;
                }
                if (this.state.backtracking == 0) {
                    current = iv_ruleForcedClockMapping;
                }
                this.match(this.input, InternalEmfExecutionConfigurationParser.EOF,
                        InternalEmfExecutionConfigurationParser.FOLLOW_EOF_in_entryRuleForcedClockMapping227);
                if (this.state.failed) {
                    return current;
                }

            }

        }

        catch (RecognitionException re) {
            this.recover(this.input, re);
            this.appendSkippedTokens();
        } finally {
        }
        return current;
    }

    // $ANTLR end "entryRuleForcedClockMapping"
    // $ANTLR start "entryRuleImportStatement"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:225:1:
    // entryRuleImportStatement returns [EObject current=null] :
    // iv_ruleImportStatement= ruleImportStatement EOF ;
    public final EObject entryRuleImportStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportStatement = null;

        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:226:2:
            // (iv_ruleImportStatement= ruleImportStatement EOF )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:227:2:
            // iv_ruleImportStatement= ruleImportStatement EOF
            {
                if (this.state.backtracking == 0) {
                    this.newCompositeNode(this.grammarAccess.getImportStatementRule());
                }
                this.pushFollow(InternalEmfExecutionConfigurationParser.FOLLOW_ruleImportStatement_in_entryRuleImportStatement408);
                iv_ruleImportStatement = this.ruleImportStatement();

                this.state._fsp--;
                if (this.state.failed) {
                    return current;
                }
                if (this.state.backtracking == 0) {
                    current = iv_ruleImportStatement;
                }
                this.match(this.input, InternalEmfExecutionConfigurationParser.EOF,
                        InternalEmfExecutionConfigurationParser.FOLLOW_EOF_in_entryRuleImportStatement418);
                if (this.state.failed) {
                    return current;
                }

            }

        }

        catch (RecognitionException re) {
            this.recover(this.input, re);
            this.appendSkippedTokens();
        } finally {
        }
        return current;
    }

    // $ANTLR end "entryRuleImportStatement"
    // $ANTLR start "entryRuleJarImportStatement"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:272:1:
    // entryRuleJarImportStatement returns [EObject current=null] :
    // iv_ruleJarImportStatement= ruleJarImportStatement EOF ;
    public final EObject entryRuleJarImportStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJarImportStatement = null;

        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:273:2:
            // (iv_ruleJarImportStatement= ruleJarImportStatement EOF )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:274:2:
            // iv_ruleJarImportStatement= ruleJarImportStatement EOF
            {
                if (this.state.backtracking == 0) {
                    this.newCompositeNode(this.grammarAccess.getJarImportStatementRule());
                }
                this.pushFollow(InternalEmfExecutionConfigurationParser.FOLLOW_ruleJarImportStatement_in_entryRuleJarImportStatement525);
                iv_ruleJarImportStatement = this.ruleJarImportStatement();

                this.state._fsp--;
                if (this.state.failed) {
                    return current;
                }
                if (this.state.backtracking == 0) {
                    current = iv_ruleJarImportStatement;
                }
                this.match(this.input, InternalEmfExecutionConfigurationParser.EOF,
                        InternalEmfExecutionConfigurationParser.FOLLOW_EOF_in_entryRuleJarImportStatement535);
                if (this.state.failed) {
                    return current;
                }

            }

        }

        catch (RecognitionException re) {
            this.recover(this.input, re);
            this.appendSkippedTokens();
        } finally {
        }
        return current;
    }

    // $ANTLR end "entryRuleJarImportStatement"
    
    protected String getFirstRuleName() {
        return "EMFExecutionConfiguration";
    }

    
    protected EmfExecutionConfigurationGrammarAccess getGrammarAccess() {
        return this.grammarAccess;
    }

    public String getGrammarFileName() {
        return "../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g";
    }

    public String[] getTokenNames() {
        return InternalEmfExecutionConfigurationParser.tokenNames;
    }

    // $ANTLR start "ruleEMFExecutionConfiguration"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:82:1:
    // ruleEMFExecutionConfiguration returns [EObject current=null] : ( (
    // (lv_imports_0_0= ruleImportStatement ) )+ ( (lv_jarImportStatement_1_0=
    // ruleJarImportStatement ) ) ( (lv_forcedClockMappings_2_0=
    // ruleForcedClockMapping ) )* ) ;
    public final EObject ruleEMFExecutionConfiguration() throws RecognitionException {
        EObject current = null;

        EObject lv_imports_0_0 = null;

        EObject lv_jarImportStatement_1_0 = null;

        EObject lv_forcedClockMappings_2_0 = null;

        this.enterRule();

        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:85:28:
            // ( ( ( (lv_imports_0_0= ruleImportStatement ) )+ (
            // (lv_jarImportStatement_1_0= ruleJarImportStatement ) ) (
            // (lv_forcedClockMappings_2_0= ruleForcedClockMapping ) )* ) )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:86:1:
            // ( ( (lv_imports_0_0= ruleImportStatement ) )+ (
            // (lv_jarImportStatement_1_0= ruleJarImportStatement ) ) (
            // (lv_forcedClockMappings_2_0= ruleForcedClockMapping ) )* )
            {
                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:86:1:
                // ( ( (lv_imports_0_0= ruleImportStatement ) )+ (
                // (lv_jarImportStatement_1_0= ruleJarImportStatement ) ) (
                // (lv_forcedClockMappings_2_0= ruleForcedClockMapping ) )* )
                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:86:2:
                // ( (lv_imports_0_0= ruleImportStatement ) )+ (
                // (lv_jarImportStatement_1_0= ruleJarImportStatement ) ) (
                // (lv_forcedClockMappings_2_0= ruleForcedClockMapping ) )*
                {
                    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:86:2:
                    // ( (lv_imports_0_0= ruleImportStatement ) )+
                    int cnt1 = 0;
                    loop1: do {
                        int alt1 = 2;
                        int LA1_0 = this.input.LA(1);

                        if ((LA1_0 == 17)) {
                            alt1 = 1;
                        }

                        switch (alt1) {
                            case 1:
                            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:87:1:
                            // (lv_imports_0_0= ruleImportStatement )
                            {
                                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:87:1:
                                // (lv_imports_0_0= ruleImportStatement )
                                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:88:3:
                                // lv_imports_0_0= ruleImportStatement
                                {
                                    if (this.state.backtracking == 0) {

                                        this.newCompositeNode(this.grammarAccess.getEMFExecutionConfigurationAccess()
                                                .getImportsImportStatementParserRuleCall_0_0());

                                    }
                                    this.pushFollow(InternalEmfExecutionConfigurationParser.FOLLOW_ruleImportStatement_in_ruleEMFExecutionConfiguration137);
                                    lv_imports_0_0 = this.ruleImportStatement();

                                    this.state._fsp--;
                                    if (this.state.failed) {
                                        return current;
                                    }
                                    if (this.state.backtracking == 0) {

                                        if (current == null) {
                                            current = this.createModelElementForParent(this.grammarAccess
                                                    .getEMFExecutionConfigurationRule());
                                        }
                                        this.add(current, "imports", lv_imports_0_0, "ImportStatement");
                                        this.afterParserOrEnumRuleCall();

                                    }

                                }

                            }
                                break;

                            default:
                                if (cnt1 >= 1) {
                                    break loop1;
                                }
                                if (this.state.backtracking > 0) {
                                    this.state.failed = true;
                                    return current;
                                }
                                EarlyExitException eee = new EarlyExitException(1, this.input);
                                throw eee;
                        }
                        cnt1++;
                    } while (true);

                    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:104:3:
                    // ( (lv_jarImportStatement_1_0= ruleJarImportStatement ) )
                    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:105:1:
                    // (lv_jarImportStatement_1_0= ruleJarImportStatement )
                    {
                        // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:105:1:
                        // (lv_jarImportStatement_1_0= ruleJarImportStatement )
                        // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:106:3:
                        // lv_jarImportStatement_1_0= ruleJarImportStatement
                        {
                            if (this.state.backtracking == 0) {

                                this.newCompositeNode(this.grammarAccess.getEMFExecutionConfigurationAccess()
                                        .getJarImportStatementJarImportStatementParserRuleCall_1_0());

                            }
                            this.pushFollow(InternalEmfExecutionConfigurationParser.FOLLOW_ruleJarImportStatement_in_ruleEMFExecutionConfiguration159);
                            lv_jarImportStatement_1_0 = this.ruleJarImportStatement();

                            this.state._fsp--;
                            if (this.state.failed) {
                                return current;
                            }
                            if (this.state.backtracking == 0) {

                                if (current == null) {
                                    current = this.createModelElementForParent(this.grammarAccess
                                            .getEMFExecutionConfigurationRule());
                                }
                                this.set(current, "jarImportStatement", lv_jarImportStatement_1_0, "JarImportStatement");
                                this.afterParserOrEnumRuleCall();

                            }

                        }

                    }

                    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:122:2:
                    // ( (lv_forcedClockMappings_2_0= ruleForcedClockMapping )
                    // )*
                    loop2: do {
                        int alt2 = 2;
                        int LA2_0 = this.input.LA(1);

                        if ((LA2_0 == 11)) {
                            alt2 = 1;
                        }

                        switch (alt2) {
                            case 1:
                            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:123:1:
                            // (lv_forcedClockMappings_2_0=
                            // ruleForcedClockMapping )
                            {
                                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:123:1:
                                // (lv_forcedClockMappings_2_0=
                                // ruleForcedClockMapping )
                                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:124:3:
                                // lv_forcedClockMappings_2_0=
                                // ruleForcedClockMapping
                                {
                                    if (this.state.backtracking == 0) {

                                        this.newCompositeNode(this.grammarAccess.getEMFExecutionConfigurationAccess()
                                                .getForcedClockMappingsForcedClockMappingParserRuleCall_2_0());

                                    }
                                    this.pushFollow(InternalEmfExecutionConfigurationParser.FOLLOW_ruleForcedClockMapping_in_ruleEMFExecutionConfiguration180);
                                    lv_forcedClockMappings_2_0 = this.ruleForcedClockMapping();

                                    this.state._fsp--;
                                    if (this.state.failed) {
                                        return current;
                                    }
                                    if (this.state.backtracking == 0) {

                                        if (current == null) {
                                            current = this.createModelElementForParent(this.grammarAccess
                                                    .getEMFExecutionConfigurationRule());
                                        }
                                        this.add(current, "forcedClockMappings", lv_forcedClockMappings_2_0,
                                                "ForcedClockMapping");
                                        this.afterParserOrEnumRuleCall();

                                    }

                                }

                            }
                                break;

                            default:
                                break loop2;
                        }
                    } while (true);

                }

            }

            if (this.state.backtracking == 0) {
                this.leaveRule();
            }
        }

        catch (RecognitionException re) {
            this.recover(this.input, re);
            this.appendSkippedTokens();
        } finally {
        }
        return current;
    }

    // $ANTLR end "ruleEMFExecutionConfiguration"
    // $ANTLR start "ruleForcedClockMapping"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:157:1:
    // ruleForcedClockMapping returns [EObject current=null] : (otherlv_0=
    // 'When' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'DSA' otherlv_3= 'returns'
    // otherlv_4= 'true' otherlv_5= 'avoid' ( (otherlv_6= RULE_ID ) ) otherlv_7=
    // ';' ) ;
    public final EObject ruleForcedClockMapping() throws RecognitionException {
        EObject current = null;

        Token otherlv_0 = null;
        Token otherlv_1 = null;
        Token otherlv_2 = null;
        Token otherlv_3 = null;
        Token otherlv_4 = null;
        Token otherlv_5 = null;
        Token otherlv_6 = null;
        Token otherlv_7 = null;

        this.enterRule();

        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:160:28:
            // ( (otherlv_0= 'When' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'DSA'
            // otherlv_3= 'returns' otherlv_4= 'true' otherlv_5= 'avoid' (
            // (otherlv_6= RULE_ID ) ) otherlv_7= ';' ) )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:161:1:
            // (otherlv_0= 'When' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'DSA'
            // otherlv_3= 'returns' otherlv_4= 'true' otherlv_5= 'avoid' (
            // (otherlv_6= RULE_ID ) ) otherlv_7= ';' )
            {
                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:161:1:
                // (otherlv_0= 'When' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'DSA'
                // otherlv_3= 'returns' otherlv_4= 'true' otherlv_5= 'avoid' (
                // (otherlv_6= RULE_ID ) ) otherlv_7= ';' )
                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:161:3:
                // otherlv_0= 'When' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'DSA'
                // otherlv_3= 'returns' otherlv_4= 'true' otherlv_5= 'avoid' (
                // (otherlv_6= RULE_ID ) ) otherlv_7= ';'
                {
                    otherlv_0 = (Token) this.match(this.input, 11,
                            InternalEmfExecutionConfigurationParser.FOLLOW_11_in_ruleForcedClockMapping264);
                    if (this.state.failed) {
                        return current;
                    }
                    if (this.state.backtracking == 0) {

                        this.newLeafNode(otherlv_0, this.grammarAccess.getForcedClockMappingAccess().getWhenKeyword_0());

                    }
                    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:165:1:
                    // ( (otherlv_1= RULE_ID ) )
                    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:166:1:
                    // (otherlv_1= RULE_ID )
                    {
                        // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:166:1:
                        // (otherlv_1= RULE_ID )
                        // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:167:3:
                        // otherlv_1= RULE_ID
                        {
                            if (this.state.backtracking == 0) {

                                /* */

                            }
                            if (this.state.backtracking == 0) {

                                if (current == null) {
                                    current = this.createModelElement(this.grammarAccess.getForcedClockMappingRule());
                                }

                            }
                            otherlv_1 = (Token) this
                                    .match(this.input,
                                            InternalEmfExecutionConfigurationParser.RULE_ID,
                                            InternalEmfExecutionConfigurationParser.FOLLOW_RULE_ID_in_ruleForcedClockMapping288);
                            if (this.state.failed) {
                                return current;
                            }
                            if (this.state.backtracking == 0) {

                                this.newLeafNode(otherlv_1, this.grammarAccess.getForcedClockMappingAccess()
                                        .getClockClockCrossReference_1_0());

                            }

                        }

                    }

                    otherlv_2 = (Token) this.match(this.input, 12,
                            InternalEmfExecutionConfigurationParser.FOLLOW_12_in_ruleForcedClockMapping300);
                    if (this.state.failed) {
                        return current;
                    }
                    if (this.state.backtracking == 0) {

                        this.newLeafNode(otherlv_2, this.grammarAccess.getForcedClockMappingAccess().getDSAKeyword_2());

                    }
                    otherlv_3 = (Token) this.match(this.input, 13,
                            InternalEmfExecutionConfigurationParser.FOLLOW_13_in_ruleForcedClockMapping312);
                    if (this.state.failed) {
                        return current;
                    }
                    if (this.state.backtracking == 0) {

                        this.newLeafNode(otherlv_3, this.grammarAccess.getForcedClockMappingAccess()
                                .getReturnsKeyword_3());

                    }
                    otherlv_4 = (Token) this.match(this.input, 14,
                            InternalEmfExecutionConfigurationParser.FOLLOW_14_in_ruleForcedClockMapping324);
                    if (this.state.failed) {
                        return current;
                    }
                    if (this.state.backtracking == 0) {

                        this.newLeafNode(otherlv_4, this.grammarAccess.getForcedClockMappingAccess().getTrueKeyword_4());

                    }
                    otherlv_5 = (Token) this.match(this.input, 15,
                            InternalEmfExecutionConfigurationParser.FOLLOW_15_in_ruleForcedClockMapping336);
                    if (this.state.failed) {
                        return current;
                    }
                    if (this.state.backtracking == 0) {

                        this.newLeafNode(otherlv_5, this.grammarAccess.getForcedClockMappingAccess()
                                .getAvoidKeyword_5());

                    }
                    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:197:1:
                    // ( (otherlv_6= RULE_ID ) )
                    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:198:1:
                    // (otherlv_6= RULE_ID )
                    {
                        // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:198:1:
                        // (otherlv_6= RULE_ID )
                        // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:199:3:
                        // otherlv_6= RULE_ID
                        {
                            if (this.state.backtracking == 0) {

                                /* */

                            }
                            if (this.state.backtracking == 0) {

                                if (current == null) {
                                    current = this.createModelElement(this.grammarAccess.getForcedClockMappingRule());
                                }

                            }
                            otherlv_6 = (Token) this
                                    .match(this.input,
                                            InternalEmfExecutionConfigurationParser.RULE_ID,
                                            InternalEmfExecutionConfigurationParser.FOLLOW_RULE_ID_in_ruleForcedClockMapping360);
                            if (this.state.failed) {
                                return current;
                            }
                            if (this.state.backtracking == 0) {

                                this.newLeafNode(otherlv_6, this.grammarAccess.getForcedClockMappingAccess()
                                        .getClockToAvoidWhenTrueClockCrossReference_6_0());

                            }

                        }

                    }

                    otherlv_7 = (Token) this.match(this.input, 16,
                            InternalEmfExecutionConfigurationParser.FOLLOW_16_in_ruleForcedClockMapping372);
                    if (this.state.failed) {
                        return current;
                    }
                    if (this.state.backtracking == 0) {

                        this.newLeafNode(otherlv_7, this.grammarAccess.getForcedClockMappingAccess()
                                .getSemicolonKeyword_7());

                    }

                }

            }

            if (this.state.backtracking == 0) {
                this.leaveRule();
            }
        }

        catch (RecognitionException re) {
            this.recover(this.input, re);
            this.appendSkippedTokens();
        } finally {
        }
        return current;
    }

    // $ANTLR end "ruleForcedClockMapping"
    // $ANTLR start "ruleImportStatement"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:234:1:
    // ruleImportStatement returns [EObject current=null] : (otherlv_0= 'import'
    // ( (lv_importURI_1_0= RULE_STRING ) ) otherlv_2= ';' ) ;
    public final EObject ruleImportStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0 = null;
        Token lv_importURI_1_0 = null;
        Token otherlv_2 = null;

        this.enterRule();

        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:237:28:
            // ( (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) )
            // otherlv_2= ';' ) )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:238:1:
            // (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) )
            // otherlv_2= ';' )
            {
                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:238:1:
                // (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) )
                // otherlv_2= ';' )
                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:238:3:
                // otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) )
                // otherlv_2= ';'
                {
                    otherlv_0 = (Token) this.match(this.input, 17,
                            InternalEmfExecutionConfigurationParser.FOLLOW_17_in_ruleImportStatement455);
                    if (this.state.failed) {
                        return current;
                    }
                    if (this.state.backtracking == 0) {

                        this.newLeafNode(otherlv_0, this.grammarAccess.getImportStatementAccess().getImportKeyword_0());

                    }
                    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:242:1:
                    // ( (lv_importURI_1_0= RULE_STRING ) )
                    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:243:1:
                    // (lv_importURI_1_0= RULE_STRING )
                    {
                        // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:243:1:
                        // (lv_importURI_1_0= RULE_STRING )
                        // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:244:3:
                        // lv_importURI_1_0= RULE_STRING
                        {
                            lv_importURI_1_0 = (Token) this
                                    .match(this.input,
                                            InternalEmfExecutionConfigurationParser.RULE_STRING,
                                            InternalEmfExecutionConfigurationParser.FOLLOW_RULE_STRING_in_ruleImportStatement472);
                            if (this.state.failed) {
                                return current;
                            }
                            if (this.state.backtracking == 0) {

                                this.newLeafNode(lv_importURI_1_0, this.grammarAccess.getImportStatementAccess()
                                        .getImportURISTRINGTerminalRuleCall_1_0());

                            }
                            if (this.state.backtracking == 0) {

                                if (current == null) {
                                    current = this.createModelElement(this.grammarAccess.getImportStatementRule());
                                }
                                this.setWithLastConsumed(current, "importURI", lv_importURI_1_0, "STRING");

                            }

                        }

                    }

                    otherlv_2 = (Token) this.match(this.input, 16,
                            InternalEmfExecutionConfigurationParser.FOLLOW_16_in_ruleImportStatement489);
                    if (this.state.failed) {
                        return current;
                    }
                    if (this.state.backtracking == 0) {

                        this.newLeafNode(otherlv_2, this.grammarAccess.getImportStatementAccess()
                                .getSemicolonKeyword_2());

                    }

                }

            }

            if (this.state.backtracking == 0) {
                this.leaveRule();
            }
        }

        catch (RecognitionException re) {
            this.recover(this.input, re);
            this.appendSkippedTokens();
        } finally {
        }
        return current;
    }

    // $ANTLR end "ruleImportStatement"
    // $ANTLR start "ruleJarImportStatement"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:281:1:
    // ruleJarImportStatement returns [EObject current=null] : (otherlv_0=
    // 'importJar' ( (lv_pathToJar_1_0= RULE_STRING ) ) otherlv_2= ';' ) ;
    public final EObject ruleJarImportStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0 = null;
        Token lv_pathToJar_1_0 = null;
        Token otherlv_2 = null;

        this.enterRule();

        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:284:28:
            // ( (otherlv_0= 'importJar' ( (lv_pathToJar_1_0= RULE_STRING ) )
            // otherlv_2= ';' ) )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:285:1:
            // (otherlv_0= 'importJar' ( (lv_pathToJar_1_0= RULE_STRING ) )
            // otherlv_2= ';' )
            {
                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:285:1:
                // (otherlv_0= 'importJar' ( (lv_pathToJar_1_0= RULE_STRING ) )
                // otherlv_2= ';' )
                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:285:3:
                // otherlv_0= 'importJar' ( (lv_pathToJar_1_0= RULE_STRING ) )
                // otherlv_2= ';'
                {
                    otherlv_0 = (Token) this.match(this.input, 18,
                            InternalEmfExecutionConfigurationParser.FOLLOW_18_in_ruleJarImportStatement572);
                    if (this.state.failed) {
                        return current;
                    }
                    if (this.state.backtracking == 0) {

                        this.newLeafNode(otherlv_0, this.grammarAccess.getJarImportStatementAccess()
                                .getImportJarKeyword_0());

                    }
                    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:289:1:
                    // ( (lv_pathToJar_1_0= RULE_STRING ) )
                    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:290:1:
                    // (lv_pathToJar_1_0= RULE_STRING )
                    {
                        // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:290:1:
                        // (lv_pathToJar_1_0= RULE_STRING )
                        // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:291:3:
                        // lv_pathToJar_1_0= RULE_STRING
                        {
                            lv_pathToJar_1_0 = (Token) this
                                    .match(this.input,
                                            InternalEmfExecutionConfigurationParser.RULE_STRING,
                                            InternalEmfExecutionConfigurationParser.FOLLOW_RULE_STRING_in_ruleJarImportStatement589);
                            if (this.state.failed) {
                                return current;
                            }
                            if (this.state.backtracking == 0) {

                                this.newLeafNode(lv_pathToJar_1_0, this.grammarAccess.getJarImportStatementAccess()
                                        .getPathToJarSTRINGTerminalRuleCall_1_0());

                            }
                            if (this.state.backtracking == 0) {

                                if (current == null) {
                                    current = this.createModelElement(this.grammarAccess.getJarImportStatementRule());
                                }
                                this.setWithLastConsumed(current, "pathToJar", lv_pathToJar_1_0, "STRING");

                            }

                        }

                    }

                    otherlv_2 = (Token) this.match(this.input, 16,
                            InternalEmfExecutionConfigurationParser.FOLLOW_16_in_ruleJarImportStatement606);
                    if (this.state.failed) {
                        return current;
                    }
                    if (this.state.backtracking == 0) {

                        this.newLeafNode(otherlv_2, this.grammarAccess.getJarImportStatementAccess()
                                .getSemicolonKeyword_2());

                    }

                }

            }

            if (this.state.backtracking == 0) {
                this.leaveRule();
            }
        }

        catch (RecognitionException re) {
            this.recover(this.input, re);
            this.appendSkippedTokens();
        } finally {
        }
        return current;
    }
    // $ANTLR end "ruleJarImportStatement"

}