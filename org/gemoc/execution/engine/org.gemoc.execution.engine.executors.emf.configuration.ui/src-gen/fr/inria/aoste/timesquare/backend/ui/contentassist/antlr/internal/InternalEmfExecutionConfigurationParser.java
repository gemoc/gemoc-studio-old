package fr.inria.aoste.timesquare.backend.ui.contentassist.antlr.internal;

import org.antlr.runtime.BitSet;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import fr.inria.aoste.timesquare.backend.services.EmfExecutionConfigurationGrammarAccess;

@SuppressWarnings("all")
public class InternalEmfExecutionConfigurationParser extends AbstractInternalContentAssistParser {
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleEMFExecutionConfiguration_in_entryRuleEMFExecutionConfiguration61 = new BitSet(
                new long[] { 0x0000000000000000L });
        public static final BitSet FOLLOW_EOF_in_entryRuleEMFExecutionConfiguration68 = new BitSet(
                new long[] { 0x0000000000000002L });
        public static final BitSet FOLLOW_rule__EMFExecutionConfiguration__Group__0_in_ruleEMFExecutionConfiguration94 = new BitSet(
                new long[] { 0x0000000000000002L });
        public static final BitSet FOLLOW_ruleForcedClockMapping_in_entryRuleForcedClockMapping121 = new BitSet(
                new long[] { 0x0000000000000000L });
        public static final BitSet FOLLOW_EOF_in_entryRuleForcedClockMapping128 = new BitSet(
                new long[] { 0x0000000000000002L });
        public static final BitSet FOLLOW_rule__ForcedClockMapping__Group__0_in_ruleForcedClockMapping154 = new BitSet(
                new long[] { 0x0000000000000002L });
        public static final BitSet FOLLOW_ruleImportStatement_in_entryRuleImportStatement181 = new BitSet(
                new long[] { 0x0000000000000000L });
        public static final BitSet FOLLOW_EOF_in_entryRuleImportStatement188 = new BitSet(
                new long[] { 0x0000000000000002L });
        public static final BitSet FOLLOW_rule__ImportStatement__Group__0_in_ruleImportStatement214 = new BitSet(
                new long[] { 0x0000000000000002L });
        public static final BitSet FOLLOW_ruleJarImportStatement_in_entryRuleJarImportStatement241 = new BitSet(
                new long[] { 0x0000000000000000L });
        public static final BitSet FOLLOW_EOF_in_entryRuleJarImportStatement248 = new BitSet(
                new long[] { 0x0000000000000002L });
        public static final BitSet FOLLOW_rule__JarImportStatement__Group__0_in_ruleJarImportStatement274 = new BitSet(
                new long[] { 0x0000000000000002L });
        public static final BitSet FOLLOW_rule__EMFExecutionConfiguration__Group__0__Impl_in_rule__EMFExecutionConfiguration__Group__0308 = new BitSet(
                new long[] { 0x0000000000040000L });
        public static final BitSet FOLLOW_rule__EMFExecutionConfiguration__Group__1_in_rule__EMFExecutionConfiguration__Group__0311 = new BitSet(
                new long[] { 0x0000000000000002L });
        public static final BitSet FOLLOW_rule__EMFExecutionConfiguration__ImportsAssignment_0_in_rule__EMFExecutionConfiguration__Group__0__Impl340 = new BitSet(
                new long[] { 0x0000000000020002L });
        public static final BitSet FOLLOW_rule__EMFExecutionConfiguration__ImportsAssignment_0_in_rule__EMFExecutionConfiguration__Group__0__Impl352 = new BitSet(
                new long[] { 0x0000000000020002L });
        public static final BitSet FOLLOW_rule__EMFExecutionConfiguration__Group__1__Impl_in_rule__EMFExecutionConfiguration__Group__1385 = new BitSet(
                new long[] { 0x0000000000000800L });
        public static final BitSet FOLLOW_rule__EMFExecutionConfiguration__Group__2_in_rule__EMFExecutionConfiguration__Group__1388 = new BitSet(
                new long[] { 0x0000000000000002L });
        public static final BitSet FOLLOW_rule__EMFExecutionConfiguration__JarImportStatementAssignment_1_in_rule__EMFExecutionConfiguration__Group__1__Impl415 = new BitSet(
                new long[] { 0x0000000000000002L });
        public static final BitSet FOLLOW_rule__EMFExecutionConfiguration__Group__2__Impl_in_rule__EMFExecutionConfiguration__Group__2445 = new BitSet(
                new long[] { 0x0000000000000002L });
        public static final BitSet FOLLOW_rule__EMFExecutionConfiguration__ForcedClockMappingsAssignment_2_in_rule__EMFExecutionConfiguration__Group__2__Impl472 = new BitSet(
                new long[] { 0x0000000000000802L });
        public static final BitSet FOLLOW_rule__ForcedClockMapping__Group__0__Impl_in_rule__ForcedClockMapping__Group__0509 = new BitSet(
                new long[] { 0x0000000000000010L });
        public static final BitSet FOLLOW_rule__ForcedClockMapping__Group__1_in_rule__ForcedClockMapping__Group__0512 = new BitSet(
                new long[] { 0x0000000000000002L });
        public static final BitSet FOLLOW_11_in_rule__ForcedClockMapping__Group__0__Impl540 = new BitSet(
                new long[] { 0x0000000000000002L });
        public static final BitSet FOLLOW_rule__ForcedClockMapping__Group__1__Impl_in_rule__ForcedClockMapping__Group__1571 = new BitSet(
                new long[] { 0x0000000000001000L });
        public static final BitSet FOLLOW_rule__ForcedClockMapping__Group__2_in_rule__ForcedClockMapping__Group__1574 = new BitSet(
                new long[] { 0x0000000000000002L });
        public static final BitSet FOLLOW_rule__ForcedClockMapping__ClockAssignment_1_in_rule__ForcedClockMapping__Group__1__Impl601 = new BitSet(
                new long[] { 0x0000000000000002L });
        public static final BitSet FOLLOW_rule__ForcedClockMapping__Group__2__Impl_in_rule__ForcedClockMapping__Group__2631 = new BitSet(
                new long[] { 0x0000000000002000L });
        public static final BitSet FOLLOW_rule__ForcedClockMapping__Group__3_in_rule__ForcedClockMapping__Group__2634 = new BitSet(
                new long[] { 0x0000000000000002L });
        public static final BitSet FOLLOW_12_in_rule__ForcedClockMapping__Group__2__Impl662 = new BitSet(
                new long[] { 0x0000000000000002L });
        public static final BitSet FOLLOW_rule__ForcedClockMapping__Group__3__Impl_in_rule__ForcedClockMapping__Group__3693 = new BitSet(
                new long[] { 0x0000000000004000L });
        public static final BitSet FOLLOW_rule__ForcedClockMapping__Group__4_in_rule__ForcedClockMapping__Group__3696 = new BitSet(
                new long[] { 0x0000000000000002L });
        public static final BitSet FOLLOW_13_in_rule__ForcedClockMapping__Group__3__Impl724 = new BitSet(
                new long[] { 0x0000000000000002L });
        public static final BitSet FOLLOW_rule__ForcedClockMapping__Group__4__Impl_in_rule__ForcedClockMapping__Group__4755 = new BitSet(
                new long[] { 0x0000000000008000L });
        public static final BitSet FOLLOW_rule__ForcedClockMapping__Group__5_in_rule__ForcedClockMapping__Group__4758 = new BitSet(
                new long[] { 0x0000000000000002L });
        public static final BitSet FOLLOW_14_in_rule__ForcedClockMapping__Group__4__Impl786 = new BitSet(
                new long[] { 0x0000000000000002L });
        public static final BitSet FOLLOW_rule__ForcedClockMapping__Group__5__Impl_in_rule__ForcedClockMapping__Group__5817 = new BitSet(
                new long[] { 0x0000000000000010L });
        public static final BitSet FOLLOW_rule__ForcedClockMapping__Group__6_in_rule__ForcedClockMapping__Group__5820 = new BitSet(
                new long[] { 0x0000000000000002L });
        public static final BitSet FOLLOW_15_in_rule__ForcedClockMapping__Group__5__Impl848 = new BitSet(
                new long[] { 0x0000000000000002L });
        public static final BitSet FOLLOW_rule__ForcedClockMapping__Group__6__Impl_in_rule__ForcedClockMapping__Group__6879 = new BitSet(
                new long[] { 0x0000000000010000L });
        public static final BitSet FOLLOW_rule__ForcedClockMapping__Group__7_in_rule__ForcedClockMapping__Group__6882 = new BitSet(
                new long[] { 0x0000000000000002L });
        public static final BitSet FOLLOW_rule__ForcedClockMapping__ClockToAvoidWhenTrueAssignment_6_in_rule__ForcedClockMapping__Group__6__Impl909 = new BitSet(
                new long[] { 0x0000000000000002L });
        public static final BitSet FOLLOW_rule__ForcedClockMapping__Group__7__Impl_in_rule__ForcedClockMapping__Group__7939 = new BitSet(
                new long[] { 0x0000000000000002L });
        public static final BitSet FOLLOW_16_in_rule__ForcedClockMapping__Group__7__Impl967 = new BitSet(
                new long[] { 0x0000000000000002L });
        public static final BitSet FOLLOW_rule__ImportStatement__Group__0__Impl_in_rule__ImportStatement__Group__01014 = new BitSet(
                new long[] { 0x0000000000000020L });
        public static final BitSet FOLLOW_rule__ImportStatement__Group__1_in_rule__ImportStatement__Group__01017 = new BitSet(
                new long[] { 0x0000000000000002L });
        public static final BitSet FOLLOW_17_in_rule__ImportStatement__Group__0__Impl1045 = new BitSet(
                new long[] { 0x0000000000000002L });
        public static final BitSet FOLLOW_rule__ImportStatement__Group__1__Impl_in_rule__ImportStatement__Group__11076 = new BitSet(
                new long[] { 0x0000000000010000L });
        public static final BitSet FOLLOW_rule__ImportStatement__Group__2_in_rule__ImportStatement__Group__11079 = new BitSet(
                new long[] { 0x0000000000000002L });
        public static final BitSet FOLLOW_rule__ImportStatement__ImportURIAssignment_1_in_rule__ImportStatement__Group__1__Impl1106 = new BitSet(
                new long[] { 0x0000000000000002L });
        public static final BitSet FOLLOW_rule__ImportStatement__Group__2__Impl_in_rule__ImportStatement__Group__21136 = new BitSet(
                new long[] { 0x0000000000000002L });
        public static final BitSet FOLLOW_16_in_rule__ImportStatement__Group__2__Impl1164 = new BitSet(
                new long[] { 0x0000000000000002L });
        public static final BitSet FOLLOW_rule__JarImportStatement__Group__0__Impl_in_rule__JarImportStatement__Group__01201 = new BitSet(
                new long[] { 0x0000000000000020L });
        public static final BitSet FOLLOW_rule__JarImportStatement__Group__1_in_rule__JarImportStatement__Group__01204 = new BitSet(
                new long[] { 0x0000000000000002L });
        public static final BitSet FOLLOW_18_in_rule__JarImportStatement__Group__0__Impl1232 = new BitSet(
                new long[] { 0x0000000000000002L });
        public static final BitSet FOLLOW_rule__JarImportStatement__Group__1__Impl_in_rule__JarImportStatement__Group__11263 = new BitSet(
                new long[] { 0x0000000000010000L });
        public static final BitSet FOLLOW_rule__JarImportStatement__Group__2_in_rule__JarImportStatement__Group__11266 = new BitSet(
                new long[] { 0x0000000000000002L });
        public static final BitSet FOLLOW_rule__JarImportStatement__PathToJarAssignment_1_in_rule__JarImportStatement__Group__1__Impl1293 = new BitSet(
                new long[] { 0x0000000000000002L });
        public static final BitSet FOLLOW_rule__JarImportStatement__Group__2__Impl_in_rule__JarImportStatement__Group__21323 = new BitSet(
                new long[] { 0x0000000000000002L });
        public static final BitSet FOLLOW_16_in_rule__JarImportStatement__Group__2__Impl1351 = new BitSet(
                new long[] { 0x0000000000000002L });
        public static final BitSet FOLLOW_ruleImportStatement_in_rule__EMFExecutionConfiguration__ImportsAssignment_01393 = new BitSet(
                new long[] { 0x0000000000000002L });
        public static final BitSet FOLLOW_ruleJarImportStatement_in_rule__EMFExecutionConfiguration__JarImportStatementAssignment_11424 = new BitSet(
                new long[] { 0x0000000000000002L });
        public static final BitSet FOLLOW_ruleForcedClockMapping_in_rule__EMFExecutionConfiguration__ForcedClockMappingsAssignment_21455 = new BitSet(
                new long[] { 0x0000000000000002L });
        public static final BitSet FOLLOW_RULE_ID_in_rule__ForcedClockMapping__ClockAssignment_11490 = new BitSet(
                new long[] { 0x0000000000000002L });
        public static final BitSet FOLLOW_RULE_ID_in_rule__ForcedClockMapping__ClockToAvoidWhenTrueAssignment_61529 = new BitSet(
                new long[] { 0x0000000000000002L });
        public static final BitSet FOLLOW_RULE_STRING_in_rule__ImportStatement__ImportURIAssignment_11564 = new BitSet(
                new long[] { 0x0000000000000002L });
        public static final BitSet FOLLOW_RULE_STRING_in_rule__JarImportStatement__PathToJarAssignment_11595 = new BitSet(
                new long[] { 0x0000000000000002L });
    }

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

    // delegates
    // delegators

    public static final int RULE_ML_COMMENT = 7;
    private EmfExecutionConfigurationGrammarAccess grammarAccess;

    public InternalEmfExecutionConfigurationParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }

    public InternalEmfExecutionConfigurationParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);

    }

    // $ANTLR start "entryRuleEMFExecutionConfiguration"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:60:1:
    // entryRuleEMFExecutionConfiguration : ruleEMFExecutionConfiguration EOF ;
    public final void entryRuleEMFExecutionConfiguration() throws RecognitionException {
        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:61:1:
            // ( ruleEMFExecutionConfiguration EOF )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:62:1:
            // ruleEMFExecutionConfiguration EOF
            {
                this.before(this.grammarAccess.getEMFExecutionConfigurationRule());
                this.pushFollow(FollowSets000.FOLLOW_ruleEMFExecutionConfiguration_in_entryRuleEMFExecutionConfiguration61);
                this.ruleEMFExecutionConfiguration();

                this.state._fsp--;

                this.after(this.grammarAccess.getEMFExecutionConfigurationRule());
                this.match(this.input, InternalEmfExecutionConfigurationParser.EOF,
                        FollowSets000.FOLLOW_EOF_in_entryRuleEMFExecutionConfiguration68);

            }

        } catch (RecognitionException re) {
            this.reportError(re);
            this.recover(this.input, re);
        } finally {
        }
        return;
    }

    // $ANTLR end "entryRuleEMFExecutionConfiguration"

    // $ANTLR start "entryRuleForcedClockMapping"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:88:1:
    // entryRuleForcedClockMapping : ruleForcedClockMapping EOF ;
    public final void entryRuleForcedClockMapping() throws RecognitionException {
        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:89:1:
            // ( ruleForcedClockMapping EOF )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:90:1:
            // ruleForcedClockMapping EOF
            {
                this.before(this.grammarAccess.getForcedClockMappingRule());
                this.pushFollow(FollowSets000.FOLLOW_ruleForcedClockMapping_in_entryRuleForcedClockMapping121);
                this.ruleForcedClockMapping();

                this.state._fsp--;

                this.after(this.grammarAccess.getForcedClockMappingRule());
                this.match(this.input, InternalEmfExecutionConfigurationParser.EOF,
                        FollowSets000.FOLLOW_EOF_in_entryRuleForcedClockMapping128);

            }

        } catch (RecognitionException re) {
            this.reportError(re);
            this.recover(this.input, re);
        } finally {
        }
        return;
    }

    // $ANTLR end "entryRuleForcedClockMapping"

    // $ANTLR start "entryRuleImportStatement"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:116:1:
    // entryRuleImportStatement : ruleImportStatement EOF ;
    public final void entryRuleImportStatement() throws RecognitionException {
        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:117:1:
            // ( ruleImportStatement EOF )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:118:1:
            // ruleImportStatement EOF
            {
                this.before(this.grammarAccess.getImportStatementRule());
                this.pushFollow(FollowSets000.FOLLOW_ruleImportStatement_in_entryRuleImportStatement181);
                this.ruleImportStatement();

                this.state._fsp--;

                this.after(this.grammarAccess.getImportStatementRule());
                this.match(this.input, InternalEmfExecutionConfigurationParser.EOF,
                        FollowSets000.FOLLOW_EOF_in_entryRuleImportStatement188);

            }

        } catch (RecognitionException re) {
            this.reportError(re);
            this.recover(this.input, re);
        } finally {
        }
        return;
    }

    // $ANTLR end "entryRuleImportStatement"

    // $ANTLR start "entryRuleJarImportStatement"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:144:1:
    // entryRuleJarImportStatement : ruleJarImportStatement EOF ;
    public final void entryRuleJarImportStatement() throws RecognitionException {
        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:145:1:
            // ( ruleJarImportStatement EOF )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:146:1:
            // ruleJarImportStatement EOF
            {
                this.before(this.grammarAccess.getJarImportStatementRule());
                this.pushFollow(FollowSets000.FOLLOW_ruleJarImportStatement_in_entryRuleJarImportStatement241);
                this.ruleJarImportStatement();

                this.state._fsp--;

                this.after(this.grammarAccess.getJarImportStatementRule());
                this.match(this.input, InternalEmfExecutionConfigurationParser.EOF,
                        FollowSets000.FOLLOW_EOF_in_entryRuleJarImportStatement248);

            }

        } catch (RecognitionException re) {
            this.reportError(re);
            this.recover(this.input, re);
        } finally {
        }
        return;
    }

    // $ANTLR end "entryRuleJarImportStatement"

    @Override
    protected Grammar getGrammar() {
        return this.grammarAccess.getGrammar();
    }

    public String getGrammarFileName() {
        return "../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g";
    }

    public String[] getTokenNames() {
        return InternalEmfExecutionConfigurationParser.tokenNames;
    }

    @Override
    protected String getValueForTokenName(String tokenName) {
        return tokenName;
    }

    // $ANTLR start
    // "rule__EMFExecutionConfiguration__ForcedClockMappingsAssignment_2"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:755:1:
    // rule__EMFExecutionConfiguration__ForcedClockMappingsAssignment_2 : (
    // ruleForcedClockMapping ) ;
    public final void rule__EMFExecutionConfiguration__ForcedClockMappingsAssignment_2() throws RecognitionException {

        int stackSize = this.keepStackSize();

        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:759:1:
            // ( ( ruleForcedClockMapping ) )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:760:1:
            // ( ruleForcedClockMapping )
            {
                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:760:1:
                // ( ruleForcedClockMapping )
                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:761:1:
                // ruleForcedClockMapping
                {
                    this.before(this.grammarAccess.getEMFExecutionConfigurationAccess()
                            .getForcedClockMappingsForcedClockMappingParserRuleCall_2_0());
                    this.pushFollow(FollowSets000.FOLLOW_ruleForcedClockMapping_in_rule__EMFExecutionConfiguration__ForcedClockMappingsAssignment_21455);
                    this.ruleForcedClockMapping();

                    this.state._fsp--;

                    this.after(this.grammarAccess.getEMFExecutionConfigurationAccess()
                            .getForcedClockMappingsForcedClockMappingParserRuleCall_2_0());

                }

            }

        } catch (RecognitionException re) {
            this.reportError(re);
            this.recover(this.input, re);
        } finally {

            this.restoreStackSize(stackSize);

        }
        return;
    }

    // $ANTLR end
    // "rule__EMFExecutionConfiguration__ForcedClockMappingsAssignment_2"

    // $ANTLR start "rule__EMFExecutionConfiguration__Group__0"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:174:1:
    // rule__EMFExecutionConfiguration__Group__0 :
    // rule__EMFExecutionConfiguration__Group__0__Impl
    // rule__EMFExecutionConfiguration__Group__1 ;
    public final void rule__EMFExecutionConfiguration__Group__0() throws RecognitionException {

        int stackSize = this.keepStackSize();

        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:178:1:
            // ( rule__EMFExecutionConfiguration__Group__0__Impl
            // rule__EMFExecutionConfiguration__Group__1 )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:179:2:
            // rule__EMFExecutionConfiguration__Group__0__Impl
            // rule__EMFExecutionConfiguration__Group__1
            {
                this.pushFollow(FollowSets000.FOLLOW_rule__EMFExecutionConfiguration__Group__0__Impl_in_rule__EMFExecutionConfiguration__Group__0308);
                this.rule__EMFExecutionConfiguration__Group__0__Impl();

                this.state._fsp--;

                this.pushFollow(FollowSets000.FOLLOW_rule__EMFExecutionConfiguration__Group__1_in_rule__EMFExecutionConfiguration__Group__0311);
                this.rule__EMFExecutionConfiguration__Group__1();

                this.state._fsp--;

            }

        } catch (RecognitionException re) {
            this.reportError(re);
            this.recover(this.input, re);
        } finally {

            this.restoreStackSize(stackSize);

        }
        return;
    }

    // $ANTLR end "rule__EMFExecutionConfiguration__Group__0"

    // $ANTLR start "rule__EMFExecutionConfiguration__Group__0__Impl"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:186:1:
    // rule__EMFExecutionConfiguration__Group__0__Impl : ( ( (
    // rule__EMFExecutionConfiguration__ImportsAssignment_0 ) ) ( (
    // rule__EMFExecutionConfiguration__ImportsAssignment_0 )* ) ) ;
    public final void rule__EMFExecutionConfiguration__Group__0__Impl() throws RecognitionException {

        int stackSize = this.keepStackSize();

        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:190:1:
            // ( ( ( ( rule__EMFExecutionConfiguration__ImportsAssignment_0 ) )
            // ( ( rule__EMFExecutionConfiguration__ImportsAssignment_0 )* ) ) )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:191:1:
            // ( ( ( rule__EMFExecutionConfiguration__ImportsAssignment_0 ) ) (
            // ( rule__EMFExecutionConfiguration__ImportsAssignment_0 )* ) )
            {
                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:191:1:
                // ( ( ( rule__EMFExecutionConfiguration__ImportsAssignment_0 )
                // ) ( ( rule__EMFExecutionConfiguration__ImportsAssignment_0 )*
                // ) )
                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:192:1:
                // ( ( rule__EMFExecutionConfiguration__ImportsAssignment_0 ) )
                // ( ( rule__EMFExecutionConfiguration__ImportsAssignment_0 )* )
                {
                    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:192:1:
                    // ( ( rule__EMFExecutionConfiguration__ImportsAssignment_0
                    // ) )
                    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:193:1:
                    // ( rule__EMFExecutionConfiguration__ImportsAssignment_0 )
                    {
                        this.before(this.grammarAccess.getEMFExecutionConfigurationAccess().getImportsAssignment_0());
                        // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:194:1:
                        // (
                        // rule__EMFExecutionConfiguration__ImportsAssignment_0
                        // )
                        // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:194:2:
                        // rule__EMFExecutionConfiguration__ImportsAssignment_0
                        {
                            this.pushFollow(FollowSets000.FOLLOW_rule__EMFExecutionConfiguration__ImportsAssignment_0_in_rule__EMFExecutionConfiguration__Group__0__Impl340);
                            this.rule__EMFExecutionConfiguration__ImportsAssignment_0();

                            this.state._fsp--;

                        }

                        this.after(this.grammarAccess.getEMFExecutionConfigurationAccess().getImportsAssignment_0());

                    }

                    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:197:1:
                    // ( ( rule__EMFExecutionConfiguration__ImportsAssignment_0
                    // )* )
                    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:198:1:
                    // ( rule__EMFExecutionConfiguration__ImportsAssignment_0 )*
                    {
                        this.before(this.grammarAccess.getEMFExecutionConfigurationAccess().getImportsAssignment_0());
                        // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:199:1:
                        // (
                        // rule__EMFExecutionConfiguration__ImportsAssignment_0
                        // )*
                        loop1: do {
                            int alt1 = 2;
                            int LA1_0 = this.input.LA(1);

                            if ((LA1_0 == 17)) {
                                alt1 = 1;
                            }

                            switch (alt1) {
                                case 1:
                                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:199:2:
                                // rule__EMFExecutionConfiguration__ImportsAssignment_0
                                {
                                    this.pushFollow(FollowSets000.FOLLOW_rule__EMFExecutionConfiguration__ImportsAssignment_0_in_rule__EMFExecutionConfiguration__Group__0__Impl352);
                                    this.rule__EMFExecutionConfiguration__ImportsAssignment_0();

                                    this.state._fsp--;

                                }
                                    break;

                                default:
                                    break loop1;
                            }
                        } while (true);

                        this.after(this.grammarAccess.getEMFExecutionConfigurationAccess().getImportsAssignment_0());

                    }

                }

            }

        } catch (RecognitionException re) {
            this.reportError(re);
            this.recover(this.input, re);
        } finally {

            this.restoreStackSize(stackSize);

        }
        return;
    }

    // $ANTLR end "rule__EMFExecutionConfiguration__Group__0__Impl"

    // $ANTLR start "rule__EMFExecutionConfiguration__Group__1"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:210:1:
    // rule__EMFExecutionConfiguration__Group__1 :
    // rule__EMFExecutionConfiguration__Group__1__Impl
    // rule__EMFExecutionConfiguration__Group__2 ;
    public final void rule__EMFExecutionConfiguration__Group__1() throws RecognitionException {

        int stackSize = this.keepStackSize();

        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:214:1:
            // ( rule__EMFExecutionConfiguration__Group__1__Impl
            // rule__EMFExecutionConfiguration__Group__2 )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:215:2:
            // rule__EMFExecutionConfiguration__Group__1__Impl
            // rule__EMFExecutionConfiguration__Group__2
            {
                this.pushFollow(FollowSets000.FOLLOW_rule__EMFExecutionConfiguration__Group__1__Impl_in_rule__EMFExecutionConfiguration__Group__1385);
                this.rule__EMFExecutionConfiguration__Group__1__Impl();

                this.state._fsp--;

                this.pushFollow(FollowSets000.FOLLOW_rule__EMFExecutionConfiguration__Group__2_in_rule__EMFExecutionConfiguration__Group__1388);
                this.rule__EMFExecutionConfiguration__Group__2();

                this.state._fsp--;

            }

        } catch (RecognitionException re) {
            this.reportError(re);
            this.recover(this.input, re);
        } finally {

            this.restoreStackSize(stackSize);

        }
        return;
    }

    // $ANTLR end "rule__EMFExecutionConfiguration__Group__1"

    // $ANTLR start "rule__EMFExecutionConfiguration__Group__1__Impl"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:222:1:
    // rule__EMFExecutionConfiguration__Group__1__Impl : ( (
    // rule__EMFExecutionConfiguration__JarImportStatementAssignment_1 ) ) ;
    public final void rule__EMFExecutionConfiguration__Group__1__Impl() throws RecognitionException {

        int stackSize = this.keepStackSize();

        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:226:1:
            // ( ( (
            // rule__EMFExecutionConfiguration__JarImportStatementAssignment_1 )
            // ) )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:227:1:
            // ( (
            // rule__EMFExecutionConfiguration__JarImportStatementAssignment_1 )
            // )
            {
                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:227:1:
                // ( (
                // rule__EMFExecutionConfiguration__JarImportStatementAssignment_1
                // ) )
                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:228:1:
                // (
                // rule__EMFExecutionConfiguration__JarImportStatementAssignment_1
                // )
                {
                    this.before(this.grammarAccess.getEMFExecutionConfigurationAccess()
                            .getJarImportStatementAssignment_1());
                    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:229:1:
                    // (
                    // rule__EMFExecutionConfiguration__JarImportStatementAssignment_1
                    // )
                    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:229:2:
                    // rule__EMFExecutionConfiguration__JarImportStatementAssignment_1
                    {
                        this.pushFollow(FollowSets000.FOLLOW_rule__EMFExecutionConfiguration__JarImportStatementAssignment_1_in_rule__EMFExecutionConfiguration__Group__1__Impl415);
                        this.rule__EMFExecutionConfiguration__JarImportStatementAssignment_1();

                        this.state._fsp--;

                    }

                    this.after(this.grammarAccess.getEMFExecutionConfigurationAccess()
                            .getJarImportStatementAssignment_1());

                }

            }

        } catch (RecognitionException re) {
            this.reportError(re);
            this.recover(this.input, re);
        } finally {

            this.restoreStackSize(stackSize);

        }
        return;
    }

    // $ANTLR end "rule__EMFExecutionConfiguration__Group__1__Impl"

    // $ANTLR start "rule__EMFExecutionConfiguration__Group__2"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:239:1:
    // rule__EMFExecutionConfiguration__Group__2 :
    // rule__EMFExecutionConfiguration__Group__2__Impl ;
    public final void rule__EMFExecutionConfiguration__Group__2() throws RecognitionException {

        int stackSize = this.keepStackSize();

        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:243:1:
            // ( rule__EMFExecutionConfiguration__Group__2__Impl )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:244:2:
            // rule__EMFExecutionConfiguration__Group__2__Impl
            {
                this.pushFollow(FollowSets000.FOLLOW_rule__EMFExecutionConfiguration__Group__2__Impl_in_rule__EMFExecutionConfiguration__Group__2445);
                this.rule__EMFExecutionConfiguration__Group__2__Impl();

                this.state._fsp--;

            }

        } catch (RecognitionException re) {
            this.reportError(re);
            this.recover(this.input, re);
        } finally {

            this.restoreStackSize(stackSize);

        }
        return;
    }

    // $ANTLR end "rule__EMFExecutionConfiguration__Group__2"

    // $ANTLR start "rule__EMFExecutionConfiguration__Group__2__Impl"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:250:1:
    // rule__EMFExecutionConfiguration__Group__2__Impl : ( (
    // rule__EMFExecutionConfiguration__ForcedClockMappingsAssignment_2 )* ) ;
    public final void rule__EMFExecutionConfiguration__Group__2__Impl() throws RecognitionException {

        int stackSize = this.keepStackSize();

        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:254:1:
            // ( ( (
            // rule__EMFExecutionConfiguration__ForcedClockMappingsAssignment_2
            // )* ) )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:255:1:
            // ( (
            // rule__EMFExecutionConfiguration__ForcedClockMappingsAssignment_2
            // )* )
            {
                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:255:1:
                // ( (
                // rule__EMFExecutionConfiguration__ForcedClockMappingsAssignment_2
                // )* )
                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:256:1:
                // (
                // rule__EMFExecutionConfiguration__ForcedClockMappingsAssignment_2
                // )*
                {
                    this.before(this.grammarAccess.getEMFExecutionConfigurationAccess()
                            .getForcedClockMappingsAssignment_2());
                    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:257:1:
                    // (
                    // rule__EMFExecutionConfiguration__ForcedClockMappingsAssignment_2
                    // )*
                    loop2: do {
                        int alt2 = 2;
                        int LA2_0 = this.input.LA(1);

                        if ((LA2_0 == 11)) {
                            alt2 = 1;
                        }

                        switch (alt2) {
                            case 1:
                            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:257:2:
                            // rule__EMFExecutionConfiguration__ForcedClockMappingsAssignment_2
                            {
                                this.pushFollow(FollowSets000.FOLLOW_rule__EMFExecutionConfiguration__ForcedClockMappingsAssignment_2_in_rule__EMFExecutionConfiguration__Group__2__Impl472);
                                this.rule__EMFExecutionConfiguration__ForcedClockMappingsAssignment_2();

                                this.state._fsp--;

                            }
                                break;

                            default:
                                break loop2;
                        }
                    } while (true);

                    this.after(this.grammarAccess.getEMFExecutionConfigurationAccess()
                            .getForcedClockMappingsAssignment_2());

                }

            }

        } catch (RecognitionException re) {
            this.reportError(re);
            this.recover(this.input, re);
        } finally {

            this.restoreStackSize(stackSize);

        }
        return;
    }

    // $ANTLR end "rule__EMFExecutionConfiguration__Group__2__Impl"

    // $ANTLR start "rule__EMFExecutionConfiguration__ImportsAssignment_0"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:725:1:
    // rule__EMFExecutionConfiguration__ImportsAssignment_0 : (
    // ruleImportStatement ) ;
    public final void rule__EMFExecutionConfiguration__ImportsAssignment_0() throws RecognitionException {

        int stackSize = this.keepStackSize();

        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:729:1:
            // ( ( ruleImportStatement ) )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:730:1:
            // ( ruleImportStatement )
            {
                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:730:1:
                // ( ruleImportStatement )
                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:731:1:
                // ruleImportStatement
                {
                    this.before(this.grammarAccess.getEMFExecutionConfigurationAccess()
                            .getImportsImportStatementParserRuleCall_0_0());
                    this.pushFollow(FollowSets000.FOLLOW_ruleImportStatement_in_rule__EMFExecutionConfiguration__ImportsAssignment_01393);
                    this.ruleImportStatement();

                    this.state._fsp--;

                    this.after(this.grammarAccess.getEMFExecutionConfigurationAccess()
                            .getImportsImportStatementParserRuleCall_0_0());

                }

            }

        } catch (RecognitionException re) {
            this.reportError(re);
            this.recover(this.input, re);
        } finally {

            this.restoreStackSize(stackSize);

        }
        return;
    }

    // $ANTLR end "rule__EMFExecutionConfiguration__ImportsAssignment_0"

    // $ANTLR start
    // "rule__EMFExecutionConfiguration__JarImportStatementAssignment_1"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:740:1:
    // rule__EMFExecutionConfiguration__JarImportStatementAssignment_1 : (
    // ruleJarImportStatement ) ;
    public final void rule__EMFExecutionConfiguration__JarImportStatementAssignment_1() throws RecognitionException {

        int stackSize = this.keepStackSize();

        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:744:1:
            // ( ( ruleJarImportStatement ) )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:745:1:
            // ( ruleJarImportStatement )
            {
                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:745:1:
                // ( ruleJarImportStatement )
                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:746:1:
                // ruleJarImportStatement
                {
                    this.before(this.grammarAccess.getEMFExecutionConfigurationAccess()
                            .getJarImportStatementJarImportStatementParserRuleCall_1_0());
                    this.pushFollow(FollowSets000.FOLLOW_ruleJarImportStatement_in_rule__EMFExecutionConfiguration__JarImportStatementAssignment_11424);
                    this.ruleJarImportStatement();

                    this.state._fsp--;

                    this.after(this.grammarAccess.getEMFExecutionConfigurationAccess()
                            .getJarImportStatementJarImportStatementParserRuleCall_1_0());

                }

            }

        } catch (RecognitionException re) {
            this.reportError(re);
            this.recover(this.input, re);
        } finally {

            this.restoreStackSize(stackSize);

        }
        return;
    }

    // $ANTLR end
    // "rule__EMFExecutionConfiguration__JarImportStatementAssignment_1"

    // $ANTLR start "rule__ForcedClockMapping__ClockAssignment_1"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:770:1:
    // rule__ForcedClockMapping__ClockAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__ForcedClockMapping__ClockAssignment_1() throws RecognitionException {

        int stackSize = this.keepStackSize();

        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:774:1:
            // ( ( ( RULE_ID ) ) )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:775:1:
            // ( ( RULE_ID ) )
            {
                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:775:1:
                // ( ( RULE_ID ) )
                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:776:1:
                // ( RULE_ID )
                {
                    this.before(this.grammarAccess.getForcedClockMappingAccess().getClockClockCrossReference_1_0());
                    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:777:1:
                    // ( RULE_ID )
                    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:778:1:
                    // RULE_ID
                    {
                        this.before(this.grammarAccess.getForcedClockMappingAccess()
                                .getClockClockIDTerminalRuleCall_1_0_1());
                        this.match(this.input, InternalEmfExecutionConfigurationParser.RULE_ID,
                                FollowSets000.FOLLOW_RULE_ID_in_rule__ForcedClockMapping__ClockAssignment_11490);
                        this.after(this.grammarAccess.getForcedClockMappingAccess()
                                .getClockClockIDTerminalRuleCall_1_0_1());

                    }

                    this.after(this.grammarAccess.getForcedClockMappingAccess().getClockClockCrossReference_1_0());

                }

            }

        } catch (RecognitionException re) {
            this.reportError(re);
            this.recover(this.input, re);
        } finally {

            this.restoreStackSize(stackSize);

        }
        return;
    }

    // $ANTLR end "rule__ForcedClockMapping__ClockAssignment_1"

    // $ANTLR start "rule__ForcedClockMapping__ClockToAvoidWhenTrueAssignment_6"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:789:1:
    // rule__ForcedClockMapping__ClockToAvoidWhenTrueAssignment_6 : ( ( RULE_ID
    // ) ) ;
    public final void rule__ForcedClockMapping__ClockToAvoidWhenTrueAssignment_6() throws RecognitionException {

        int stackSize = this.keepStackSize();

        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:793:1:
            // ( ( ( RULE_ID ) ) )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:794:1:
            // ( ( RULE_ID ) )
            {
                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:794:1:
                // ( ( RULE_ID ) )
                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:795:1:
                // ( RULE_ID )
                {
                    this.before(this.grammarAccess.getForcedClockMappingAccess()
                            .getClockToAvoidWhenTrueClockCrossReference_6_0());
                    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:796:1:
                    // ( RULE_ID )
                    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:797:1:
                    // RULE_ID
                    {
                        this.before(this.grammarAccess.getForcedClockMappingAccess()
                                .getClockToAvoidWhenTrueClockIDTerminalRuleCall_6_0_1());
                        this.match(
                                this.input,
                                InternalEmfExecutionConfigurationParser.RULE_ID,
                                FollowSets000.FOLLOW_RULE_ID_in_rule__ForcedClockMapping__ClockToAvoidWhenTrueAssignment_61529);
                        this.after(this.grammarAccess.getForcedClockMappingAccess()
                                .getClockToAvoidWhenTrueClockIDTerminalRuleCall_6_0_1());

                    }

                    this.after(this.grammarAccess.getForcedClockMappingAccess()
                            .getClockToAvoidWhenTrueClockCrossReference_6_0());

                }

            }

        } catch (RecognitionException re) {
            this.reportError(re);
            this.recover(this.input, re);
        } finally {

            this.restoreStackSize(stackSize);

        }
        return;
    }

    // $ANTLR end "rule__ForcedClockMapping__ClockToAvoidWhenTrueAssignment_6"

    // $ANTLR start "rule__ForcedClockMapping__Group__0"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:273:1:
    // rule__ForcedClockMapping__Group__0 :
    // rule__ForcedClockMapping__Group__0__Impl
    // rule__ForcedClockMapping__Group__1 ;
    public final void rule__ForcedClockMapping__Group__0() throws RecognitionException {

        int stackSize = this.keepStackSize();

        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:277:1:
            // ( rule__ForcedClockMapping__Group__0__Impl
            // rule__ForcedClockMapping__Group__1 )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:278:2:
            // rule__ForcedClockMapping__Group__0__Impl
            // rule__ForcedClockMapping__Group__1
            {
                this.pushFollow(FollowSets000.FOLLOW_rule__ForcedClockMapping__Group__0__Impl_in_rule__ForcedClockMapping__Group__0509);
                this.rule__ForcedClockMapping__Group__0__Impl();

                this.state._fsp--;

                this.pushFollow(FollowSets000.FOLLOW_rule__ForcedClockMapping__Group__1_in_rule__ForcedClockMapping__Group__0512);
                this.rule__ForcedClockMapping__Group__1();

                this.state._fsp--;

            }

        } catch (RecognitionException re) {
            this.reportError(re);
            this.recover(this.input, re);
        } finally {

            this.restoreStackSize(stackSize);

        }
        return;
    }

    // $ANTLR end "rule__ForcedClockMapping__Group__0"

    // $ANTLR start "rule__ForcedClockMapping__Group__0__Impl"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:285:1:
    // rule__ForcedClockMapping__Group__0__Impl : ( 'When' ) ;
    public final void rule__ForcedClockMapping__Group__0__Impl() throws RecognitionException {

        int stackSize = this.keepStackSize();

        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:289:1:
            // ( ( 'When' ) )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:290:1:
            // ( 'When' )
            {
                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:290:1:
                // ( 'When' )
                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:291:1:
                // 'When'
                {
                    this.before(this.grammarAccess.getForcedClockMappingAccess().getWhenKeyword_0());
                    this.match(this.input, 11, FollowSets000.FOLLOW_11_in_rule__ForcedClockMapping__Group__0__Impl540);
                    this.after(this.grammarAccess.getForcedClockMappingAccess().getWhenKeyword_0());

                }

            }

        } catch (RecognitionException re) {
            this.reportError(re);
            this.recover(this.input, re);
        } finally {

            this.restoreStackSize(stackSize);

        }
        return;
    }

    // $ANTLR end "rule__ForcedClockMapping__Group__0__Impl"

    // $ANTLR start "rule__ForcedClockMapping__Group__1"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:304:1:
    // rule__ForcedClockMapping__Group__1 :
    // rule__ForcedClockMapping__Group__1__Impl
    // rule__ForcedClockMapping__Group__2 ;
    public final void rule__ForcedClockMapping__Group__1() throws RecognitionException {

        int stackSize = this.keepStackSize();

        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:308:1:
            // ( rule__ForcedClockMapping__Group__1__Impl
            // rule__ForcedClockMapping__Group__2 )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:309:2:
            // rule__ForcedClockMapping__Group__1__Impl
            // rule__ForcedClockMapping__Group__2
            {
                this.pushFollow(FollowSets000.FOLLOW_rule__ForcedClockMapping__Group__1__Impl_in_rule__ForcedClockMapping__Group__1571);
                this.rule__ForcedClockMapping__Group__1__Impl();

                this.state._fsp--;

                this.pushFollow(FollowSets000.FOLLOW_rule__ForcedClockMapping__Group__2_in_rule__ForcedClockMapping__Group__1574);
                this.rule__ForcedClockMapping__Group__2();

                this.state._fsp--;

            }

        } catch (RecognitionException re) {
            this.reportError(re);
            this.recover(this.input, re);
        } finally {

            this.restoreStackSize(stackSize);

        }
        return;
    }

    // $ANTLR end "rule__ForcedClockMapping__Group__1"

    // $ANTLR start "rule__ForcedClockMapping__Group__1__Impl"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:316:1:
    // rule__ForcedClockMapping__Group__1__Impl : ( (
    // rule__ForcedClockMapping__ClockAssignment_1 ) ) ;
    public final void rule__ForcedClockMapping__Group__1__Impl() throws RecognitionException {

        int stackSize = this.keepStackSize();

        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:320:1:
            // ( ( ( rule__ForcedClockMapping__ClockAssignment_1 ) ) )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:321:1:
            // ( ( rule__ForcedClockMapping__ClockAssignment_1 ) )
            {
                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:321:1:
                // ( ( rule__ForcedClockMapping__ClockAssignment_1 ) )
                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:322:1:
                // ( rule__ForcedClockMapping__ClockAssignment_1 )
                {
                    this.before(this.grammarAccess.getForcedClockMappingAccess().getClockAssignment_1());
                    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:323:1:
                    // ( rule__ForcedClockMapping__ClockAssignment_1 )
                    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:323:2:
                    // rule__ForcedClockMapping__ClockAssignment_1
                    {
                        this.pushFollow(FollowSets000.FOLLOW_rule__ForcedClockMapping__ClockAssignment_1_in_rule__ForcedClockMapping__Group__1__Impl601);
                        this.rule__ForcedClockMapping__ClockAssignment_1();

                        this.state._fsp--;

                    }

                    this.after(this.grammarAccess.getForcedClockMappingAccess().getClockAssignment_1());

                }

            }

        } catch (RecognitionException re) {
            this.reportError(re);
            this.recover(this.input, re);
        } finally {

            this.restoreStackSize(stackSize);

        }
        return;
    }

    // $ANTLR end "rule__ForcedClockMapping__Group__1__Impl"

    // $ANTLR start "rule__ForcedClockMapping__Group__2"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:333:1:
    // rule__ForcedClockMapping__Group__2 :
    // rule__ForcedClockMapping__Group__2__Impl
    // rule__ForcedClockMapping__Group__3 ;
    public final void rule__ForcedClockMapping__Group__2() throws RecognitionException {

        int stackSize = this.keepStackSize();

        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:337:1:
            // ( rule__ForcedClockMapping__Group__2__Impl
            // rule__ForcedClockMapping__Group__3 )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:338:2:
            // rule__ForcedClockMapping__Group__2__Impl
            // rule__ForcedClockMapping__Group__3
            {
                this.pushFollow(FollowSets000.FOLLOW_rule__ForcedClockMapping__Group__2__Impl_in_rule__ForcedClockMapping__Group__2631);
                this.rule__ForcedClockMapping__Group__2__Impl();

                this.state._fsp--;

                this.pushFollow(FollowSets000.FOLLOW_rule__ForcedClockMapping__Group__3_in_rule__ForcedClockMapping__Group__2634);
                this.rule__ForcedClockMapping__Group__3();

                this.state._fsp--;

            }

        } catch (RecognitionException re) {
            this.reportError(re);
            this.recover(this.input, re);
        } finally {

            this.restoreStackSize(stackSize);

        }
        return;
    }

    // $ANTLR end "rule__ForcedClockMapping__Group__2"

    // $ANTLR start "rule__ForcedClockMapping__Group__2__Impl"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:345:1:
    // rule__ForcedClockMapping__Group__2__Impl : ( 'DSA' ) ;
    public final void rule__ForcedClockMapping__Group__2__Impl() throws RecognitionException {

        int stackSize = this.keepStackSize();

        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:349:1:
            // ( ( 'DSA' ) )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:350:1:
            // ( 'DSA' )
            {
                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:350:1:
                // ( 'DSA' )
                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:351:1:
                // 'DSA'
                {
                    this.before(this.grammarAccess.getForcedClockMappingAccess().getDSAKeyword_2());
                    this.match(this.input, 12, FollowSets000.FOLLOW_12_in_rule__ForcedClockMapping__Group__2__Impl662);
                    this.after(this.grammarAccess.getForcedClockMappingAccess().getDSAKeyword_2());

                }

            }

        } catch (RecognitionException re) {
            this.reportError(re);
            this.recover(this.input, re);
        } finally {

            this.restoreStackSize(stackSize);

        }
        return;
    }

    // $ANTLR end "rule__ForcedClockMapping__Group__2__Impl"

    // $ANTLR start "rule__ForcedClockMapping__Group__3"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:364:1:
    // rule__ForcedClockMapping__Group__3 :
    // rule__ForcedClockMapping__Group__3__Impl
    // rule__ForcedClockMapping__Group__4 ;
    public final void rule__ForcedClockMapping__Group__3() throws RecognitionException {

        int stackSize = this.keepStackSize();

        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:368:1:
            // ( rule__ForcedClockMapping__Group__3__Impl
            // rule__ForcedClockMapping__Group__4 )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:369:2:
            // rule__ForcedClockMapping__Group__3__Impl
            // rule__ForcedClockMapping__Group__4
            {
                this.pushFollow(FollowSets000.FOLLOW_rule__ForcedClockMapping__Group__3__Impl_in_rule__ForcedClockMapping__Group__3693);
                this.rule__ForcedClockMapping__Group__3__Impl();

                this.state._fsp--;

                this.pushFollow(FollowSets000.FOLLOW_rule__ForcedClockMapping__Group__4_in_rule__ForcedClockMapping__Group__3696);
                this.rule__ForcedClockMapping__Group__4();

                this.state._fsp--;

            }

        } catch (RecognitionException re) {
            this.reportError(re);
            this.recover(this.input, re);
        } finally {

            this.restoreStackSize(stackSize);

        }
        return;
    }

    // $ANTLR end "rule__ForcedClockMapping__Group__3"

    // $ANTLR start "rule__ForcedClockMapping__Group__3__Impl"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:376:1:
    // rule__ForcedClockMapping__Group__3__Impl : ( 'returns' ) ;
    public final void rule__ForcedClockMapping__Group__3__Impl() throws RecognitionException {

        int stackSize = this.keepStackSize();

        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:380:1:
            // ( ( 'returns' ) )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:381:1:
            // ( 'returns' )
            {
                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:381:1:
                // ( 'returns' )
                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:382:1:
                // 'returns'
                {
                    this.before(this.grammarAccess.getForcedClockMappingAccess().getReturnsKeyword_3());
                    this.match(this.input, 13, FollowSets000.FOLLOW_13_in_rule__ForcedClockMapping__Group__3__Impl724);
                    this.after(this.grammarAccess.getForcedClockMappingAccess().getReturnsKeyword_3());

                }

            }

        } catch (RecognitionException re) {
            this.reportError(re);
            this.recover(this.input, re);
        } finally {

            this.restoreStackSize(stackSize);

        }
        return;
    }

    // $ANTLR end "rule__ForcedClockMapping__Group__3__Impl"

    // $ANTLR start "rule__ForcedClockMapping__Group__4"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:395:1:
    // rule__ForcedClockMapping__Group__4 :
    // rule__ForcedClockMapping__Group__4__Impl
    // rule__ForcedClockMapping__Group__5 ;
    public final void rule__ForcedClockMapping__Group__4() throws RecognitionException {

        int stackSize = this.keepStackSize();

        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:399:1:
            // ( rule__ForcedClockMapping__Group__4__Impl
            // rule__ForcedClockMapping__Group__5 )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:400:2:
            // rule__ForcedClockMapping__Group__4__Impl
            // rule__ForcedClockMapping__Group__5
            {
                this.pushFollow(FollowSets000.FOLLOW_rule__ForcedClockMapping__Group__4__Impl_in_rule__ForcedClockMapping__Group__4755);
                this.rule__ForcedClockMapping__Group__4__Impl();

                this.state._fsp--;

                this.pushFollow(FollowSets000.FOLLOW_rule__ForcedClockMapping__Group__5_in_rule__ForcedClockMapping__Group__4758);
                this.rule__ForcedClockMapping__Group__5();

                this.state._fsp--;

            }

        } catch (RecognitionException re) {
            this.reportError(re);
            this.recover(this.input, re);
        } finally {

            this.restoreStackSize(stackSize);

        }
        return;
    }

    // $ANTLR end "rule__ForcedClockMapping__Group__4"

    // $ANTLR start "rule__ForcedClockMapping__Group__4__Impl"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:407:1:
    // rule__ForcedClockMapping__Group__4__Impl : ( 'true' ) ;
    public final void rule__ForcedClockMapping__Group__4__Impl() throws RecognitionException {

        int stackSize = this.keepStackSize();

        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:411:1:
            // ( ( 'true' ) )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:412:1:
            // ( 'true' )
            {
                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:412:1:
                // ( 'true' )
                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:413:1:
                // 'true'
                {
                    this.before(this.grammarAccess.getForcedClockMappingAccess().getTrueKeyword_4());
                    this.match(this.input, 14, FollowSets000.FOLLOW_14_in_rule__ForcedClockMapping__Group__4__Impl786);
                    this.after(this.grammarAccess.getForcedClockMappingAccess().getTrueKeyword_4());

                }

            }

        } catch (RecognitionException re) {
            this.reportError(re);
            this.recover(this.input, re);
        } finally {

            this.restoreStackSize(stackSize);

        }
        return;
    }

    // $ANTLR end "rule__ForcedClockMapping__Group__4__Impl"

    // $ANTLR start "rule__ForcedClockMapping__Group__5"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:426:1:
    // rule__ForcedClockMapping__Group__5 :
    // rule__ForcedClockMapping__Group__5__Impl
    // rule__ForcedClockMapping__Group__6 ;
    public final void rule__ForcedClockMapping__Group__5() throws RecognitionException {

        int stackSize = this.keepStackSize();

        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:430:1:
            // ( rule__ForcedClockMapping__Group__5__Impl
            // rule__ForcedClockMapping__Group__6 )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:431:2:
            // rule__ForcedClockMapping__Group__5__Impl
            // rule__ForcedClockMapping__Group__6
            {
                this.pushFollow(FollowSets000.FOLLOW_rule__ForcedClockMapping__Group__5__Impl_in_rule__ForcedClockMapping__Group__5817);
                this.rule__ForcedClockMapping__Group__5__Impl();

                this.state._fsp--;

                this.pushFollow(FollowSets000.FOLLOW_rule__ForcedClockMapping__Group__6_in_rule__ForcedClockMapping__Group__5820);
                this.rule__ForcedClockMapping__Group__6();

                this.state._fsp--;

            }

        } catch (RecognitionException re) {
            this.reportError(re);
            this.recover(this.input, re);
        } finally {

            this.restoreStackSize(stackSize);

        }
        return;
    }

    // $ANTLR end "rule__ForcedClockMapping__Group__5"

    // $ANTLR start "rule__ForcedClockMapping__Group__5__Impl"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:438:1:
    // rule__ForcedClockMapping__Group__5__Impl : ( 'avoid' ) ;
    public final void rule__ForcedClockMapping__Group__5__Impl() throws RecognitionException {

        int stackSize = this.keepStackSize();

        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:442:1:
            // ( ( 'avoid' ) )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:443:1:
            // ( 'avoid' )
            {
                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:443:1:
                // ( 'avoid' )
                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:444:1:
                // 'avoid'
                {
                    this.before(this.grammarAccess.getForcedClockMappingAccess().getAvoidKeyword_5());
                    this.match(this.input, 15, FollowSets000.FOLLOW_15_in_rule__ForcedClockMapping__Group__5__Impl848);
                    this.after(this.grammarAccess.getForcedClockMappingAccess().getAvoidKeyword_5());

                }

            }

        } catch (RecognitionException re) {
            this.reportError(re);
            this.recover(this.input, re);
        } finally {

            this.restoreStackSize(stackSize);

        }
        return;
    }

    // $ANTLR end "rule__ForcedClockMapping__Group__5__Impl"

    // $ANTLR start "rule__ForcedClockMapping__Group__6"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:457:1:
    // rule__ForcedClockMapping__Group__6 :
    // rule__ForcedClockMapping__Group__6__Impl
    // rule__ForcedClockMapping__Group__7 ;
    public final void rule__ForcedClockMapping__Group__6() throws RecognitionException {

        int stackSize = this.keepStackSize();

        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:461:1:
            // ( rule__ForcedClockMapping__Group__6__Impl
            // rule__ForcedClockMapping__Group__7 )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:462:2:
            // rule__ForcedClockMapping__Group__6__Impl
            // rule__ForcedClockMapping__Group__7
            {
                this.pushFollow(FollowSets000.FOLLOW_rule__ForcedClockMapping__Group__6__Impl_in_rule__ForcedClockMapping__Group__6879);
                this.rule__ForcedClockMapping__Group__6__Impl();

                this.state._fsp--;

                this.pushFollow(FollowSets000.FOLLOW_rule__ForcedClockMapping__Group__7_in_rule__ForcedClockMapping__Group__6882);
                this.rule__ForcedClockMapping__Group__7();

                this.state._fsp--;

            }

        } catch (RecognitionException re) {
            this.reportError(re);
            this.recover(this.input, re);
        } finally {

            this.restoreStackSize(stackSize);

        }
        return;
    }

    // $ANTLR end "rule__ForcedClockMapping__Group__6"

    // $ANTLR start "rule__ForcedClockMapping__Group__6__Impl"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:469:1:
    // rule__ForcedClockMapping__Group__6__Impl : ( (
    // rule__ForcedClockMapping__ClockToAvoidWhenTrueAssignment_6 ) ) ;
    public final void rule__ForcedClockMapping__Group__6__Impl() throws RecognitionException {

        int stackSize = this.keepStackSize();

        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:473:1:
            // ( ( ( rule__ForcedClockMapping__ClockToAvoidWhenTrueAssignment_6
            // ) ) )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:474:1:
            // ( ( rule__ForcedClockMapping__ClockToAvoidWhenTrueAssignment_6 )
            // )
            {
                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:474:1:
                // ( (
                // rule__ForcedClockMapping__ClockToAvoidWhenTrueAssignment_6 )
                // )
                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:475:1:
                // ( rule__ForcedClockMapping__ClockToAvoidWhenTrueAssignment_6
                // )
                {
                    this.before(this.grammarAccess.getForcedClockMappingAccess().getClockToAvoidWhenTrueAssignment_6());
                    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:476:1:
                    // (
                    // rule__ForcedClockMapping__ClockToAvoidWhenTrueAssignment_6
                    // )
                    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:476:2:
                    // rule__ForcedClockMapping__ClockToAvoidWhenTrueAssignment_6
                    {
                        this.pushFollow(FollowSets000.FOLLOW_rule__ForcedClockMapping__ClockToAvoidWhenTrueAssignment_6_in_rule__ForcedClockMapping__Group__6__Impl909);
                        this.rule__ForcedClockMapping__ClockToAvoidWhenTrueAssignment_6();

                        this.state._fsp--;

                    }

                    this.after(this.grammarAccess.getForcedClockMappingAccess().getClockToAvoidWhenTrueAssignment_6());

                }

            }

        } catch (RecognitionException re) {
            this.reportError(re);
            this.recover(this.input, re);
        } finally {

            this.restoreStackSize(stackSize);

        }
        return;
    }

    // $ANTLR end "rule__ForcedClockMapping__Group__6__Impl"

    // $ANTLR start "rule__ForcedClockMapping__Group__7"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:486:1:
    // rule__ForcedClockMapping__Group__7 :
    // rule__ForcedClockMapping__Group__7__Impl ;
    public final void rule__ForcedClockMapping__Group__7() throws RecognitionException {

        int stackSize = this.keepStackSize();

        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:490:1:
            // ( rule__ForcedClockMapping__Group__7__Impl )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:491:2:
            // rule__ForcedClockMapping__Group__7__Impl
            {
                this.pushFollow(FollowSets000.FOLLOW_rule__ForcedClockMapping__Group__7__Impl_in_rule__ForcedClockMapping__Group__7939);
                this.rule__ForcedClockMapping__Group__7__Impl();

                this.state._fsp--;

            }

        } catch (RecognitionException re) {
            this.reportError(re);
            this.recover(this.input, re);
        } finally {

            this.restoreStackSize(stackSize);

        }
        return;
    }

    // $ANTLR end "rule__ForcedClockMapping__Group__7"

    // $ANTLR start "rule__ForcedClockMapping__Group__7__Impl"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:497:1:
    // rule__ForcedClockMapping__Group__7__Impl : ( ';' ) ;
    public final void rule__ForcedClockMapping__Group__7__Impl() throws RecognitionException {

        int stackSize = this.keepStackSize();

        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:501:1:
            // ( ( ';' ) )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:502:1:
            // ( ';' )
            {
                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:502:1:
                // ( ';' )
                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:503:1:
                // ';'
                {
                    this.before(this.grammarAccess.getForcedClockMappingAccess().getSemicolonKeyword_7());
                    this.match(this.input, 16, FollowSets000.FOLLOW_16_in_rule__ForcedClockMapping__Group__7__Impl967);
                    this.after(this.grammarAccess.getForcedClockMappingAccess().getSemicolonKeyword_7());

                }

            }

        } catch (RecognitionException re) {
            this.reportError(re);
            this.recover(this.input, re);
        } finally {

            this.restoreStackSize(stackSize);

        }
        return;
    }

    // $ANTLR end "rule__ForcedClockMapping__Group__7__Impl"

    // $ANTLR start "rule__ImportStatement__Group__0"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:532:1:
    // rule__ImportStatement__Group__0 : rule__ImportStatement__Group__0__Impl
    // rule__ImportStatement__Group__1 ;
    public final void rule__ImportStatement__Group__0() throws RecognitionException {

        int stackSize = this.keepStackSize();

        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:536:1:
            // ( rule__ImportStatement__Group__0__Impl
            // rule__ImportStatement__Group__1 )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:537:2:
            // rule__ImportStatement__Group__0__Impl
            // rule__ImportStatement__Group__1
            {
                this.pushFollow(FollowSets000.FOLLOW_rule__ImportStatement__Group__0__Impl_in_rule__ImportStatement__Group__01014);
                this.rule__ImportStatement__Group__0__Impl();

                this.state._fsp--;

                this.pushFollow(FollowSets000.FOLLOW_rule__ImportStatement__Group__1_in_rule__ImportStatement__Group__01017);
                this.rule__ImportStatement__Group__1();

                this.state._fsp--;

            }

        } catch (RecognitionException re) {
            this.reportError(re);
            this.recover(this.input, re);
        } finally {

            this.restoreStackSize(stackSize);

        }
        return;
    }

    // $ANTLR end "rule__ImportStatement__Group__0"

    // $ANTLR start "rule__ImportStatement__Group__0__Impl"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:544:1:
    // rule__ImportStatement__Group__0__Impl : ( 'import' ) ;
    public final void rule__ImportStatement__Group__0__Impl() throws RecognitionException {

        int stackSize = this.keepStackSize();

        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:548:1:
            // ( ( 'import' ) )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:549:1:
            // ( 'import' )
            {
                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:549:1:
                // ( 'import' )
                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:550:1:
                // 'import'
                {
                    this.before(this.grammarAccess.getImportStatementAccess().getImportKeyword_0());
                    this.match(this.input, 17, FollowSets000.FOLLOW_17_in_rule__ImportStatement__Group__0__Impl1045);
                    this.after(this.grammarAccess.getImportStatementAccess().getImportKeyword_0());

                }

            }

        } catch (RecognitionException re) {
            this.reportError(re);
            this.recover(this.input, re);
        } finally {

            this.restoreStackSize(stackSize);

        }
        return;
    }

    // $ANTLR end "rule__ImportStatement__Group__0__Impl"

    // $ANTLR start "rule__ImportStatement__Group__1"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:563:1:
    // rule__ImportStatement__Group__1 : rule__ImportStatement__Group__1__Impl
    // rule__ImportStatement__Group__2 ;
    public final void rule__ImportStatement__Group__1() throws RecognitionException {

        int stackSize = this.keepStackSize();

        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:567:1:
            // ( rule__ImportStatement__Group__1__Impl
            // rule__ImportStatement__Group__2 )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:568:2:
            // rule__ImportStatement__Group__1__Impl
            // rule__ImportStatement__Group__2
            {
                this.pushFollow(FollowSets000.FOLLOW_rule__ImportStatement__Group__1__Impl_in_rule__ImportStatement__Group__11076);
                this.rule__ImportStatement__Group__1__Impl();

                this.state._fsp--;

                this.pushFollow(FollowSets000.FOLLOW_rule__ImportStatement__Group__2_in_rule__ImportStatement__Group__11079);
                this.rule__ImportStatement__Group__2();

                this.state._fsp--;

            }

        } catch (RecognitionException re) {
            this.reportError(re);
            this.recover(this.input, re);
        } finally {

            this.restoreStackSize(stackSize);

        }
        return;
    }

    // $ANTLR end "rule__ImportStatement__Group__1"

    // $ANTLR start "rule__ImportStatement__Group__1__Impl"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:575:1:
    // rule__ImportStatement__Group__1__Impl : ( (
    // rule__ImportStatement__ImportURIAssignment_1 ) ) ;
    public final void rule__ImportStatement__Group__1__Impl() throws RecognitionException {

        int stackSize = this.keepStackSize();

        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:579:1:
            // ( ( ( rule__ImportStatement__ImportURIAssignment_1 ) ) )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:580:1:
            // ( ( rule__ImportStatement__ImportURIAssignment_1 ) )
            {
                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:580:1:
                // ( ( rule__ImportStatement__ImportURIAssignment_1 ) )
                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:581:1:
                // ( rule__ImportStatement__ImportURIAssignment_1 )
                {
                    this.before(this.grammarAccess.getImportStatementAccess().getImportURIAssignment_1());
                    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:582:1:
                    // ( rule__ImportStatement__ImportURIAssignment_1 )
                    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:582:2:
                    // rule__ImportStatement__ImportURIAssignment_1
                    {
                        this.pushFollow(FollowSets000.FOLLOW_rule__ImportStatement__ImportURIAssignment_1_in_rule__ImportStatement__Group__1__Impl1106);
                        this.rule__ImportStatement__ImportURIAssignment_1();

                        this.state._fsp--;

                    }

                    this.after(this.grammarAccess.getImportStatementAccess().getImportURIAssignment_1());

                }

            }

        } catch (RecognitionException re) {
            this.reportError(re);
            this.recover(this.input, re);
        } finally {

            this.restoreStackSize(stackSize);

        }
        return;
    }

    // $ANTLR end "rule__ImportStatement__Group__1__Impl"

    // $ANTLR start "rule__ImportStatement__Group__2"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:592:1:
    // rule__ImportStatement__Group__2 : rule__ImportStatement__Group__2__Impl ;
    public final void rule__ImportStatement__Group__2() throws RecognitionException {

        int stackSize = this.keepStackSize();

        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:596:1:
            // ( rule__ImportStatement__Group__2__Impl )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:597:2:
            // rule__ImportStatement__Group__2__Impl
            {
                this.pushFollow(FollowSets000.FOLLOW_rule__ImportStatement__Group__2__Impl_in_rule__ImportStatement__Group__21136);
                this.rule__ImportStatement__Group__2__Impl();

                this.state._fsp--;

            }

        } catch (RecognitionException re) {
            this.reportError(re);
            this.recover(this.input, re);
        } finally {

            this.restoreStackSize(stackSize);

        }
        return;
    }

    // $ANTLR end "rule__ImportStatement__Group__2"

    // $ANTLR start "rule__ImportStatement__Group__2__Impl"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:603:1:
    // rule__ImportStatement__Group__2__Impl : ( ';' ) ;
    public final void rule__ImportStatement__Group__2__Impl() throws RecognitionException {

        int stackSize = this.keepStackSize();

        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:607:1:
            // ( ( ';' ) )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:608:1:
            // ( ';' )
            {
                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:608:1:
                // ( ';' )
                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:609:1:
                // ';'
                {
                    this.before(this.grammarAccess.getImportStatementAccess().getSemicolonKeyword_2());
                    this.match(this.input, 16, FollowSets000.FOLLOW_16_in_rule__ImportStatement__Group__2__Impl1164);
                    this.after(this.grammarAccess.getImportStatementAccess().getSemicolonKeyword_2());

                }

            }

        } catch (RecognitionException re) {
            this.reportError(re);
            this.recover(this.input, re);
        } finally {

            this.restoreStackSize(stackSize);

        }
        return;
    }

    // $ANTLR end "rule__ImportStatement__Group__2__Impl"

    // $ANTLR start "rule__ImportStatement__ImportURIAssignment_1"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:808:1:
    // rule__ImportStatement__ImportURIAssignment_1 : ( RULE_STRING ) ;
    public final void rule__ImportStatement__ImportURIAssignment_1() throws RecognitionException {

        int stackSize = this.keepStackSize();

        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:812:1:
            // ( ( RULE_STRING ) )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:813:1:
            // ( RULE_STRING )
            {
                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:813:1:
                // ( RULE_STRING )
                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:814:1:
                // RULE_STRING
                {
                    this.before(this.grammarAccess.getImportStatementAccess().getImportURISTRINGTerminalRuleCall_1_0());
                    this.match(this.input, InternalEmfExecutionConfigurationParser.RULE_STRING,
                            FollowSets000.FOLLOW_RULE_STRING_in_rule__ImportStatement__ImportURIAssignment_11564);
                    this.after(this.grammarAccess.getImportStatementAccess().getImportURISTRINGTerminalRuleCall_1_0());

                }

            }

        } catch (RecognitionException re) {
            this.reportError(re);
            this.recover(this.input, re);
        } finally {

            this.restoreStackSize(stackSize);

        }
        return;
    }

    // $ANTLR end "rule__ImportStatement__ImportURIAssignment_1"

    // $ANTLR start "rule__JarImportStatement__Group__0"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:628:1:
    // rule__JarImportStatement__Group__0 :
    // rule__JarImportStatement__Group__0__Impl
    // rule__JarImportStatement__Group__1 ;
    public final void rule__JarImportStatement__Group__0() throws RecognitionException {

        int stackSize = this.keepStackSize();

        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:632:1:
            // ( rule__JarImportStatement__Group__0__Impl
            // rule__JarImportStatement__Group__1 )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:633:2:
            // rule__JarImportStatement__Group__0__Impl
            // rule__JarImportStatement__Group__1
            {
                this.pushFollow(FollowSets000.FOLLOW_rule__JarImportStatement__Group__0__Impl_in_rule__JarImportStatement__Group__01201);
                this.rule__JarImportStatement__Group__0__Impl();

                this.state._fsp--;

                this.pushFollow(FollowSets000.FOLLOW_rule__JarImportStatement__Group__1_in_rule__JarImportStatement__Group__01204);
                this.rule__JarImportStatement__Group__1();

                this.state._fsp--;

            }

        } catch (RecognitionException re) {
            this.reportError(re);
            this.recover(this.input, re);
        } finally {

            this.restoreStackSize(stackSize);

        }
        return;
    }

    // $ANTLR end "rule__JarImportStatement__Group__0"

    // $ANTLR start "rule__JarImportStatement__Group__0__Impl"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:640:1:
    // rule__JarImportStatement__Group__0__Impl : ( 'importJar' ) ;
    public final void rule__JarImportStatement__Group__0__Impl() throws RecognitionException {

        int stackSize = this.keepStackSize();

        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:644:1:
            // ( ( 'importJar' ) )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:645:1:
            // ( 'importJar' )
            {
                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:645:1:
                // ( 'importJar' )
                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:646:1:
                // 'importJar'
                {
                    this.before(this.grammarAccess.getJarImportStatementAccess().getImportJarKeyword_0());
                    this.match(this.input, 18, FollowSets000.FOLLOW_18_in_rule__JarImportStatement__Group__0__Impl1232);
                    this.after(this.grammarAccess.getJarImportStatementAccess().getImportJarKeyword_0());

                }

            }

        } catch (RecognitionException re) {
            this.reportError(re);
            this.recover(this.input, re);
        } finally {

            this.restoreStackSize(stackSize);

        }
        return;
    }

    // $ANTLR end "rule__JarImportStatement__Group__0__Impl"

    // $ANTLR start "rule__JarImportStatement__Group__1"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:659:1:
    // rule__JarImportStatement__Group__1 :
    // rule__JarImportStatement__Group__1__Impl
    // rule__JarImportStatement__Group__2 ;
    public final void rule__JarImportStatement__Group__1() throws RecognitionException {

        int stackSize = this.keepStackSize();

        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:663:1:
            // ( rule__JarImportStatement__Group__1__Impl
            // rule__JarImportStatement__Group__2 )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:664:2:
            // rule__JarImportStatement__Group__1__Impl
            // rule__JarImportStatement__Group__2
            {
                this.pushFollow(FollowSets000.FOLLOW_rule__JarImportStatement__Group__1__Impl_in_rule__JarImportStatement__Group__11263);
                this.rule__JarImportStatement__Group__1__Impl();

                this.state._fsp--;

                this.pushFollow(FollowSets000.FOLLOW_rule__JarImportStatement__Group__2_in_rule__JarImportStatement__Group__11266);
                this.rule__JarImportStatement__Group__2();

                this.state._fsp--;

            }

        } catch (RecognitionException re) {
            this.reportError(re);
            this.recover(this.input, re);
        } finally {

            this.restoreStackSize(stackSize);

        }
        return;
    }

    // $ANTLR end "rule__JarImportStatement__Group__1"

    // $ANTLR start "rule__JarImportStatement__Group__1__Impl"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:671:1:
    // rule__JarImportStatement__Group__1__Impl : ( (
    // rule__JarImportStatement__PathToJarAssignment_1 ) ) ;
    public final void rule__JarImportStatement__Group__1__Impl() throws RecognitionException {

        int stackSize = this.keepStackSize();

        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:675:1:
            // ( ( ( rule__JarImportStatement__PathToJarAssignment_1 ) ) )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:676:1:
            // ( ( rule__JarImportStatement__PathToJarAssignment_1 ) )
            {
                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:676:1:
                // ( ( rule__JarImportStatement__PathToJarAssignment_1 ) )
                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:677:1:
                // ( rule__JarImportStatement__PathToJarAssignment_1 )
                {
                    this.before(this.grammarAccess.getJarImportStatementAccess().getPathToJarAssignment_1());
                    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:678:1:
                    // ( rule__JarImportStatement__PathToJarAssignment_1 )
                    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:678:2:
                    // rule__JarImportStatement__PathToJarAssignment_1
                    {
                        this.pushFollow(FollowSets000.FOLLOW_rule__JarImportStatement__PathToJarAssignment_1_in_rule__JarImportStatement__Group__1__Impl1293);
                        this.rule__JarImportStatement__PathToJarAssignment_1();

                        this.state._fsp--;

                    }

                    this.after(this.grammarAccess.getJarImportStatementAccess().getPathToJarAssignment_1());

                }

            }

        } catch (RecognitionException re) {
            this.reportError(re);
            this.recover(this.input, re);
        } finally {

            this.restoreStackSize(stackSize);

        }
        return;
    }

    // $ANTLR end "rule__JarImportStatement__Group__1__Impl"

    // $ANTLR start "rule__JarImportStatement__Group__2"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:688:1:
    // rule__JarImportStatement__Group__2 :
    // rule__JarImportStatement__Group__2__Impl ;
    public final void rule__JarImportStatement__Group__2() throws RecognitionException {

        int stackSize = this.keepStackSize();

        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:692:1:
            // ( rule__JarImportStatement__Group__2__Impl )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:693:2:
            // rule__JarImportStatement__Group__2__Impl
            {
                this.pushFollow(FollowSets000.FOLLOW_rule__JarImportStatement__Group__2__Impl_in_rule__JarImportStatement__Group__21323);
                this.rule__JarImportStatement__Group__2__Impl();

                this.state._fsp--;

            }

        } catch (RecognitionException re) {
            this.reportError(re);
            this.recover(this.input, re);
        } finally {

            this.restoreStackSize(stackSize);

        }
        return;
    }

    // $ANTLR end "rule__JarImportStatement__Group__2"

    // $ANTLR start "rule__JarImportStatement__Group__2__Impl"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:699:1:
    // rule__JarImportStatement__Group__2__Impl : ( ';' ) ;
    public final void rule__JarImportStatement__Group__2__Impl() throws RecognitionException {

        int stackSize = this.keepStackSize();

        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:703:1:
            // ( ( ';' ) )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:704:1:
            // ( ';' )
            {
                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:704:1:
                // ( ';' )
                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:705:1:
                // ';'
                {
                    this.before(this.grammarAccess.getJarImportStatementAccess().getSemicolonKeyword_2());
                    this.match(this.input, 16, FollowSets000.FOLLOW_16_in_rule__JarImportStatement__Group__2__Impl1351);
                    this.after(this.grammarAccess.getJarImportStatementAccess().getSemicolonKeyword_2());

                }

            }

        } catch (RecognitionException re) {
            this.reportError(re);
            this.recover(this.input, re);
        } finally {

            this.restoreStackSize(stackSize);

        }
        return;
    }

    // $ANTLR end "rule__JarImportStatement__Group__2__Impl"

    // $ANTLR start "rule__JarImportStatement__PathToJarAssignment_1"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:823:1:
    // rule__JarImportStatement__PathToJarAssignment_1 : ( RULE_STRING ) ;
    public final void rule__JarImportStatement__PathToJarAssignment_1() throws RecognitionException {

        int stackSize = this.keepStackSize();

        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:827:1:
            // ( ( RULE_STRING ) )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:828:1:
            // ( RULE_STRING )
            {
                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:828:1:
                // ( RULE_STRING )
                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:829:1:
                // RULE_STRING
                {
                    this.before(this.grammarAccess.getJarImportStatementAccess()
                            .getPathToJarSTRINGTerminalRuleCall_1_0());
                    this.match(this.input, InternalEmfExecutionConfigurationParser.RULE_STRING,
                            FollowSets000.FOLLOW_RULE_STRING_in_rule__JarImportStatement__PathToJarAssignment_11595);
                    this.after(this.grammarAccess.getJarImportStatementAccess()
                            .getPathToJarSTRINGTerminalRuleCall_1_0());

                }

            }

        } catch (RecognitionException re) {
            this.reportError(re);
            this.recover(this.input, re);
        } finally {

            this.restoreStackSize(stackSize);

        }
        return;
    }

    // $ANTLR end "rule__JarImportStatement__PathToJarAssignment_1"

    // $ANTLR start "ruleEMFExecutionConfiguration"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:69:1:
    // ruleEMFExecutionConfiguration : ( (
    // rule__EMFExecutionConfiguration__Group__0 ) ) ;
    public final void ruleEMFExecutionConfiguration() throws RecognitionException {

        int stackSize = this.keepStackSize();

        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:73:2:
            // ( ( ( rule__EMFExecutionConfiguration__Group__0 ) ) )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:74:1:
            // ( ( rule__EMFExecutionConfiguration__Group__0 ) )
            {
                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:74:1:
                // ( ( rule__EMFExecutionConfiguration__Group__0 ) )
                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:75:1:
                // ( rule__EMFExecutionConfiguration__Group__0 )
                {
                    this.before(this.grammarAccess.getEMFExecutionConfigurationAccess().getGroup());
                    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:76:1:
                    // ( rule__EMFExecutionConfiguration__Group__0 )
                    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:76:2:
                    // rule__EMFExecutionConfiguration__Group__0
                    {
                        this.pushFollow(FollowSets000.FOLLOW_rule__EMFExecutionConfiguration__Group__0_in_ruleEMFExecutionConfiguration94);
                        this.rule__EMFExecutionConfiguration__Group__0();

                        this.state._fsp--;

                    }

                    this.after(this.grammarAccess.getEMFExecutionConfigurationAccess().getGroup());

                }

            }

        } catch (RecognitionException re) {
            this.reportError(re);
            this.recover(this.input, re);
        } finally {

            this.restoreStackSize(stackSize);

        }
        return;
    }

    // $ANTLR end "ruleEMFExecutionConfiguration"

    // $ANTLR start "ruleForcedClockMapping"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:97:1:
    // ruleForcedClockMapping : ( ( rule__ForcedClockMapping__Group__0 ) ) ;
    public final void ruleForcedClockMapping() throws RecognitionException {

        int stackSize = this.keepStackSize();

        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:101:2:
            // ( ( ( rule__ForcedClockMapping__Group__0 ) ) )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:102:1:
            // ( ( rule__ForcedClockMapping__Group__0 ) )
            {
                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:102:1:
                // ( ( rule__ForcedClockMapping__Group__0 ) )
                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:103:1:
                // ( rule__ForcedClockMapping__Group__0 )
                {
                    this.before(this.grammarAccess.getForcedClockMappingAccess().getGroup());
                    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:104:1:
                    // ( rule__ForcedClockMapping__Group__0 )
                    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:104:2:
                    // rule__ForcedClockMapping__Group__0
                    {
                        this.pushFollow(FollowSets000.FOLLOW_rule__ForcedClockMapping__Group__0_in_ruleForcedClockMapping154);
                        this.rule__ForcedClockMapping__Group__0();

                        this.state._fsp--;

                    }

                    this.after(this.grammarAccess.getForcedClockMappingAccess().getGroup());

                }

            }

        } catch (RecognitionException re) {
            this.reportError(re);
            this.recover(this.input, re);
        } finally {

            this.restoreStackSize(stackSize);

        }
        return;
    }

    // $ANTLR end "ruleForcedClockMapping"

    // $ANTLR start "ruleImportStatement"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:125:1:
    // ruleImportStatement : ( ( rule__ImportStatement__Group__0 ) ) ;
    public final void ruleImportStatement() throws RecognitionException {

        int stackSize = this.keepStackSize();

        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:129:2:
            // ( ( ( rule__ImportStatement__Group__0 ) ) )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:130:1:
            // ( ( rule__ImportStatement__Group__0 ) )
            {
                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:130:1:
                // ( ( rule__ImportStatement__Group__0 ) )
                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:131:1:
                // ( rule__ImportStatement__Group__0 )
                {
                    this.before(this.grammarAccess.getImportStatementAccess().getGroup());
                    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:132:1:
                    // ( rule__ImportStatement__Group__0 )
                    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:132:2:
                    // rule__ImportStatement__Group__0
                    {
                        this.pushFollow(FollowSets000.FOLLOW_rule__ImportStatement__Group__0_in_ruleImportStatement214);
                        this.rule__ImportStatement__Group__0();

                        this.state._fsp--;

                    }

                    this.after(this.grammarAccess.getImportStatementAccess().getGroup());

                }

            }

        } catch (RecognitionException re) {
            this.reportError(re);
            this.recover(this.input, re);
        } finally {

            this.restoreStackSize(stackSize);

        }
        return;
    }

    // $ANTLR end "ruleImportStatement"

    // $ANTLR start "ruleJarImportStatement"
    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:153:1:
    // ruleJarImportStatement : ( ( rule__JarImportStatement__Group__0 ) ) ;
    public final void ruleJarImportStatement() throws RecognitionException {

        int stackSize = this.keepStackSize();

        try {
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:157:2:
            // ( ( ( rule__JarImportStatement__Group__0 ) ) )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:158:1:
            // ( ( rule__JarImportStatement__Group__0 ) )
            {
                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:158:1:
                // ( ( rule__JarImportStatement__Group__0 ) )
                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:159:1:
                // ( rule__JarImportStatement__Group__0 )
                {
                    this.before(this.grammarAccess.getJarImportStatementAccess().getGroup());
                    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:160:1:
                    // ( rule__JarImportStatement__Group__0 )
                    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration.ui/src-gen/fr/inria/aoste/timesquare/backend/ui/contentassist/antlr/internal/InternalEmfExecutionConfiguration.g:160:2:
                    // rule__JarImportStatement__Group__0
                    {
                        this.pushFollow(FollowSets000.FOLLOW_rule__JarImportStatement__Group__0_in_ruleJarImportStatement274);
                        this.rule__JarImportStatement__Group__0();

                        this.state._fsp--;

                    }

                    this.after(this.grammarAccess.getJarImportStatementAccess().getGroup());

                }

            }

        } catch (RecognitionException re) {
            this.reportError(re);
            this.recover(this.input, re);
        } finally {

            this.restoreStackSize(stackSize);

        }
        return;
    }

    // $ANTLR end "ruleJarImportStatement"

    // Delegated rules

    public void setGrammarAccess(EmfExecutionConfigurationGrammarAccess grammarAccess) {
        this.grammarAccess = grammarAccess;
    }

}