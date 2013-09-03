package fr.inria.aoste.timesquare.backend.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import.
// Currently there is no other way to specify the superclass for the lexer.
import org.antlr.runtime.BaseRecognizer;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.DFA;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.IntStream;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.eclipse.xtext.parser.antlr.Lexer;

@SuppressWarnings("all")
public class InternalEmfExecutionConfigurationLexer extends Lexer {
    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = InternalEmfExecutionConfigurationLexer.DFA12_eot;
            this.eof = InternalEmfExecutionConfigurationLexer.DFA12_eof;
            this.min = InternalEmfExecutionConfigurationLexer.DFA12_min;
            this.max = InternalEmfExecutionConfigurationLexer.DFA12_max;
            this.accept = InternalEmfExecutionConfigurationLexer.DFA12_accept;
            this.special = InternalEmfExecutionConfigurationLexer.DFA12_special;
            this.transition = InternalEmfExecutionConfigurationLexer.DFA12_transition;
        }

        public String getDescription() {
            return "1:1: Tokens : ( T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }

        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
            int _s = s;
            switch (s) {
                case 0:
                    int LA12_12 = input.LA(1);

                    s = -1;
                    if (((LA12_12 >= '\u0000' && LA12_12 <= '\uFFFF'))) {
                        s = 25;
                    } else {
                        s = 15;
                    }

                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 1:
                    int LA12_11 = input.LA(1);

                    s = -1;
                    if (((LA12_11 >= '\u0000' && LA12_11 <= '\uFFFF'))) {
                        s = 25;
                    } else {
                        s = 15;
                    }

                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 2:
                    int LA12_0 = input.LA(1);

                    s = -1;
                    if ((LA12_0 == 'W')) {
                        s = 1;
                    }

                    else if ((LA12_0 == 'D')) {
                        s = 2;
                    }

                    else if ((LA12_0 == 'r')) {
                        s = 3;
                    }

                    else if ((LA12_0 == 't')) {
                        s = 4;
                    }

                    else if ((LA12_0 == 'a')) {
                        s = 5;
                    }

                    else if ((LA12_0 == ';')) {
                        s = 6;
                    }

                    else if ((LA12_0 == 'i')) {
                        s = 7;
                    }

                    else if ((LA12_0 == '^')) {
                        s = 8;
                    }

                    else if (((LA12_0 >= 'A' && LA12_0 <= 'C') || (LA12_0 >= 'E' && LA12_0 <= 'V')
                            || (LA12_0 >= 'X' && LA12_0 <= 'Z') || LA12_0 == '_' || (LA12_0 >= 'b' && LA12_0 <= 'h')
                            || (LA12_0 >= 'j' && LA12_0 <= 'q') || LA12_0 == 's' || (LA12_0 >= 'u' && LA12_0 <= 'z'))) {
                        s = 9;
                    }

                    else if (((LA12_0 >= '0' && LA12_0 <= '9'))) {
                        s = 10;
                    }

                    else if ((LA12_0 == '\"')) {
                        s = 11;
                    }

                    else if ((LA12_0 == '\'')) {
                        s = 12;
                    }

                    else if ((LA12_0 == '/')) {
                        s = 13;
                    }

                    else if (((LA12_0 >= '\t' && LA12_0 <= '\n') || LA12_0 == '\r' || LA12_0 == ' ')) {
                        s = 14;
                    }

                    else if (((LA12_0 >= '\u0000' && LA12_0 <= '\b') || (LA12_0 >= '\u000B' && LA12_0 <= '\f')
                            || (LA12_0 >= '\u000E' && LA12_0 <= '\u001F') || LA12_0 == '!'
                            || (LA12_0 >= '#' && LA12_0 <= '&') || (LA12_0 >= '(' && LA12_0 <= '.') || LA12_0 == ':'
                            || (LA12_0 >= '<' && LA12_0 <= '@') || (LA12_0 >= '[' && LA12_0 <= ']') || LA12_0 == '`' || (LA12_0 >= '{' && LA12_0 <= '\uFFFF'))) {
                        s = 15;
                    }

                    if (s >= 0) {
                        return s;
                    }
                    break;
            }
            NoViableAltException nvae = new NoViableAltException(this.getDescription(), 12, _s, input);
            this.error(nvae);
            throw nvae;
        }
    }

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
    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA12_eotS = "\1\uffff\5\21\1\uffff\1\21\1\17\2\uffff\3\17\2\uffff\1\21\1\uffff"
            + "\4\21\1\uffff\1\21\5\uffff\1\21\1\44\4\21\1\51\1\uffff\1\21\1\53"
            + "\2\21\1\uffff\1\21\1\uffff\1\57\2\21\1\uffff\1\63\1\64\1\21\2\uffff" + "\1\21\1\67\1\uffff";
    static final String DFA12_eofS = "\70\uffff";

    static final String DFA12_minS = "\1\0\1\150\1\123\1\145\1\162\1\166\1\uffff\1\155\1\101\2\uffff\2"
            + "\0\1\52\2\uffff\1\145\1\uffff\1\101\1\164\1\165\1\157\1\uffff\1"
            + "\160\5\uffff\1\156\1\60\1\165\1\145\1\151\1\157\1\60\1\uffff\1\162"
            + "\1\60\1\144\1\162\1\uffff\1\156\1\uffff\1\60\1\164\1\163\1\uffff"
            + "\2\60\1\141\2\uffff\1\162\1\60\1\uffff";

    static final String DFA12_maxS = "\1\uffff\1\150\1\123\1\145\1\162\1\166\1\uffff\1\155\1\172\2\uffff"
            + "\2\uffff\1\57\2\uffff\1\145\1\uffff\1\101\1\164\1\165\1\157\1\uffff"
            + "\1\160\5\uffff\1\156\1\172\1\165\1\145\1\151\1\157\1\172\1\uffff"
            + "\1\162\1\172\1\144\1\162\1\uffff\1\156\1\uffff\1\172\1\164\1\163"
            + "\1\uffff\2\172\1\141\2\uffff\1\162\1\172\1\uffff";

    static final String DFA12_acceptS = "\6\uffff\1\6\2\uffff\1\11\1\12\3\uffff\1\16\1\17\1\uffff\1\11\4"
            + "\uffff\1\6\1\uffff\1\12\1\13\1\14\1\15\1\16\7\uffff\1\2\4\uffff"
            + "\1\1\1\uffff\1\4\3\uffff\1\5\3\uffff\1\7\1\3\2\uffff\1\10";

    static final String DFA12_specialS = "\1\2\12\uffff\1\1\1\0\53\uffff}>";

    static final String[] DFA12_transitionS = {
            "\11\17\2\16\2\17\1\16\22\17\1\16\1\17\1\13\4\17\1\14\7\17\1"
                    + "\15\12\12\1\17\1\6\5\17\3\11\1\2\22\11\1\1\3\11\3\17\1\10\1"
                    + "\11\1\17\1\5\7\11\1\7\10\11\1\3\1\11\1\4\6\11\uff85\17", "\1\20", "\1\22", "\1\23", "\1\24",
            "\1\25", "", "\1\27", "\32\21\4\uffff\1\21\1\uffff\32\21", "", "", "\0\31", "\0\31", "\1\32\4\uffff\1\33",
            "", "", "\1\35", "", "\1\36", "\1\37", "\1\40", "\1\41", "", "\1\42", "", "", "", "", "", "\1\43",
            "\12\21\7\uffff\32\21\4\uffff\1\21\1\uffff\32\21", "\1\45", "\1\46", "\1\47", "\1\50",
            "\12\21\7\uffff\32\21\4\uffff\1\21\1\uffff\32\21", "", "\1\52",
            "\12\21\7\uffff\32\21\4\uffff\1\21\1\uffff\32\21", "\1\54", "\1\55", "", "\1\56", "",
            "\12\21\7\uffff\32\21\4\uffff\1\21\1\uffff\32\21", "\1\60", "\1\61", "",
            "\12\21\7\uffff\11\21\1\62\20\21\4\uffff\1\21\1\uffff\32\21",
            "\12\21\7\uffff\32\21\4\uffff\1\21\1\uffff\32\21", "\1\65", "", "", "\1\66",
            "\12\21\7\uffff\32\21\4\uffff\1\21\1\uffff\32\21", "" };

    static final short[] DFA12_eot = DFA.unpackEncodedString(InternalEmfExecutionConfigurationLexer.DFA12_eotS);

    static final short[] DFA12_eof = DFA.unpackEncodedString(InternalEmfExecutionConfigurationLexer.DFA12_eofS);

    static final char[] DFA12_min = DFA
            .unpackEncodedStringToUnsignedChars(InternalEmfExecutionConfigurationLexer.DFA12_minS);

    static final char[] DFA12_max = DFA
            .unpackEncodedStringToUnsignedChars(InternalEmfExecutionConfigurationLexer.DFA12_maxS);

    static final short[] DFA12_accept = DFA.unpackEncodedString(InternalEmfExecutionConfigurationLexer.DFA12_acceptS);

    static final short[] DFA12_special = DFA.unpackEncodedString(InternalEmfExecutionConfigurationLexer.DFA12_specialS);

    static final short[][] DFA12_transition;

    static {
        int numStates = InternalEmfExecutionConfigurationLexer.DFA12_transitionS.length;
        DFA12_transition = new short[numStates][];
        for (int i = 0; i < numStates; i++) {
            InternalEmfExecutionConfigurationLexer.DFA12_transition[i] = DFA
                    .unpackEncodedString(InternalEmfExecutionConfigurationLexer.DFA12_transitionS[i]);
        }
    }

    public InternalEmfExecutionConfigurationLexer() {
        ;
    }

    public InternalEmfExecutionConfigurationLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }

    public InternalEmfExecutionConfigurationLexer(CharStream input, RecognizerSharedState state) {
        super(input, state);

    }

    public String getGrammarFileName() {
        return "../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g";
    }

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = InternalEmfExecutionConfigurationLexer.RULE_ANY_OTHER;
            int _channel = BaseRecognizer.DEFAULT_TOKEN_CHANNEL;
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:330:16:
            // ( . )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:330:18:
            // .
            {
                this.matchAny();

            }

            this.state.type = _type;
            this.state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "RULE_ANY_OTHER"
    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = InternalEmfExecutionConfigurationLexer.RULE_ID;
            int _channel = BaseRecognizer.DEFAULT_TOKEN_CHANNEL;
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:318:9:
            // ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A'
            // .. 'Z' | '_' | '0' .. '9' )* )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:318:11:
            // ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' ..
            // 'Z' | '_' | '0' .. '9' )*
            {
                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:318:11:
                // ( '^' )?
                int alt1 = 2;
                int LA1_0 = this.input.LA(1);

                if ((LA1_0 == '^')) {
                    alt1 = 1;
                }
                switch (alt1) {
                    case 1:
                    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:318:11:
                    // '^'
                    {
                        this.match('^');

                    }
                        break;

                }

                if ((this.input.LA(1) >= 'A' && this.input.LA(1) <= 'Z') || this.input.LA(1) == '_'
                        || (this.input.LA(1) >= 'a' && this.input.LA(1) <= 'z')) {
                    this.input.consume();

                } else {
                    MismatchedSetException mse = new MismatchedSetException(null, this.input);
                    this.recover(mse);
                    throw mse;
                }

                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:318:40:
                // ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
                loop2: do {
                    int alt2 = 2;
                    int LA2_0 = this.input.LA(1);

                    if (((LA2_0 >= '0' && LA2_0 <= '9') || (LA2_0 >= 'A' && LA2_0 <= 'Z') || LA2_0 == '_' || (LA2_0 >= 'a' && LA2_0 <= 'z'))) {
                        alt2 = 1;
                    }

                    switch (alt2) {
                        case 1:
                        // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:
                        {
                            if ((this.input.LA(1) >= '0' && this.input.LA(1) <= '9')
                                    || (this.input.LA(1) >= 'A' && this.input.LA(1) <= 'Z') || this.input.LA(1) == '_'
                                    || (this.input.LA(1) >= 'a' && this.input.LA(1) <= 'z')) {
                                this.input.consume();

                            } else {
                                MismatchedSetException mse = new MismatchedSetException(null, this.input);
                                this.recover(mse);
                                throw mse;
                            }

                        }
                            break;

                        default:
                            break loop2;
                    }
                } while (true);

            }

            this.state.type = _type;
            this.state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "RULE_ID"
    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = InternalEmfExecutionConfigurationLexer.RULE_INT;
            int _channel = BaseRecognizer.DEFAULT_TOKEN_CHANNEL;
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:320:10:
            // ( ( '0' .. '9' )+ )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:320:12:
            // ( '0' .. '9' )+
            {
                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:320:12:
                // ( '0' .. '9' )+
                int cnt3 = 0;
                loop3: do {
                    int alt3 = 2;
                    int LA3_0 = this.input.LA(1);

                    if (((LA3_0 >= '0' && LA3_0 <= '9'))) {
                        alt3 = 1;
                    }

                    switch (alt3) {
                        case 1:
                        // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:320:13:
                        // '0' .. '9'
                        {
                            this.matchRange('0', '9');

                        }
                            break;

                        default:
                            if (cnt3 >= 1) {
                                break loop3;
                            }
                            EarlyExitException eee = new EarlyExitException(3, this.input);
                            throw eee;
                    }
                    cnt3++;
                } while (true);

            }

            this.state.type = _type;
            this.state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "RULE_INT"
    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = InternalEmfExecutionConfigurationLexer.RULE_ML_COMMENT;
            int _channel = BaseRecognizer.DEFAULT_TOKEN_CHANNEL;
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:324:17:
            // ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:324:19:
            // '/*' ( options {greedy=false; } : . )* '*/'
            {
                this.match("/*");

                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:324:24:
                // ( options {greedy=false; } : . )*
                loop7: do {
                    int alt7 = 2;
                    int LA7_0 = this.input.LA(1);

                    if ((LA7_0 == '*')) {
                        int LA7_1 = this.input.LA(2);

                        if ((LA7_1 == '/')) {
                            alt7 = 2;
                        } else if (((LA7_1 >= '\u0000' && LA7_1 <= '.') || (LA7_1 >= '0' && LA7_1 <= '\uFFFF'))) {
                            alt7 = 1;
                        }

                    } else if (((LA7_0 >= '\u0000' && LA7_0 <= ')') || (LA7_0 >= '+' && LA7_0 <= '\uFFFF'))) {
                        alt7 = 1;
                    }

                    switch (alt7) {
                        case 1:
                        // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:324:52:
                        // .
                        {
                            this.matchAny();

                        }
                            break;

                        default:
                            break loop7;
                    }
                } while (true);

                this.match("*/");

            }

            this.state.type = _type;
            this.state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "RULE_ML_COMMENT"
    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = InternalEmfExecutionConfigurationLexer.RULE_SL_COMMENT;
            int _channel = BaseRecognizer.DEFAULT_TOKEN_CHANNEL;
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:326:17:
            // ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:326:19:
            // '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
                this.match("//");

                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:326:24:
                // (~ ( ( '\\n' | '\\r' ) ) )*
                loop8: do {
                    int alt8 = 2;
                    int LA8_0 = this.input.LA(1);

                    if (((LA8_0 >= '\u0000' && LA8_0 <= '\t') || (LA8_0 >= '\u000B' && LA8_0 <= '\f') || (LA8_0 >= '\u000E' && LA8_0 <= '\uFFFF'))) {
                        alt8 = 1;
                    }

                    switch (alt8) {
                        case 1:
                        // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:326:24:
                        // ~ ( ( '\\n' | '\\r' ) )
                        {
                            if ((this.input.LA(1) >= '\u0000' && this.input.LA(1) <= '\t')
                                    || (this.input.LA(1) >= '\u000B' && this.input.LA(1) <= '\f')
                                    || (this.input.LA(1) >= '\u000E' && this.input.LA(1) <= '\uFFFF')) {
                                this.input.consume();

                            } else {
                                MismatchedSetException mse = new MismatchedSetException(null, this.input);
                                this.recover(mse);
                                throw mse;
                            }

                        }
                            break;

                        default:
                            break loop8;
                    }
                } while (true);

                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:326:40:
                // ( ( '\\r' )? '\\n' )?
                int alt10 = 2;
                int LA10_0 = this.input.LA(1);

                if ((LA10_0 == '\n' || LA10_0 == '\r')) {
                    alt10 = 1;
                }
                switch (alt10) {
                    case 1:
                    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:326:41:
                    // ( '\\r' )? '\\n'
                    {
                        // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:326:41:
                        // ( '\\r' )?
                        int alt9 = 2;
                        int LA9_0 = this.input.LA(1);

                        if ((LA9_0 == '\r')) {
                            alt9 = 1;
                        }
                        switch (alt9) {
                            case 1:
                            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:326:41:
                            // '\\r'
                            {
                                this.match('\r');

                            }
                                break;

                        }

                        this.match('\n');

                    }
                        break;

                }

            }

            this.state.type = _type;
            this.state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "RULE_SL_COMMENT"
    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = InternalEmfExecutionConfigurationLexer.RULE_STRING;
            int _channel = BaseRecognizer.DEFAULT_TOKEN_CHANNEL;
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:322:13:
            // ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' |
            // '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' (
            // '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' |
            // '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:322:15:
            // ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' |
            // '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' (
            // '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' |
            // '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:322:15:
                // ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' |
                // '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' (
                // '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' |
                // '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
                int alt6 = 2;
                int LA6_0 = this.input.LA(1);

                if ((LA6_0 == '\"')) {
                    alt6 = 1;
                } else if ((LA6_0 == '\'')) {
                    alt6 = 2;
                } else {
                    NoViableAltException nvae = new NoViableAltException("", 6, 0, this.input);

                    throw nvae;
                }
                switch (alt6) {
                    case 1:
                    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:322:16:
                    // '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"'
                    // | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                        this.match('\"');
                        // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:322:20:
                        // ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' |
                        // '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
                        loop4: do {
                            int alt4 = 3;
                            int LA4_0 = this.input.LA(1);

                            if ((LA4_0 == '\\')) {
                                alt4 = 1;
                            } else if (((LA4_0 >= '\u0000' && LA4_0 <= '!') || (LA4_0 >= '#' && LA4_0 <= '[') || (LA4_0 >= ']' && LA4_0 <= '\uFFFF'))) {
                                alt4 = 2;
                            }

                            switch (alt4) {
                                case 1:
                                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:322:21:
                                // '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' |
                                // '\"' | '\\'' | '\\\\' )
                                {
                                    this.match('\\');
                                    if (this.input.LA(1) == '\"' || this.input.LA(1) == '\''
                                            || this.input.LA(1) == '\\' || this.input.LA(1) == 'b'
                                            || this.input.LA(1) == 'f' || this.input.LA(1) == 'n'
                                            || this.input.LA(1) == 'r'
                                            || (this.input.LA(1) >= 't' && this.input.LA(1) <= 'u')) {
                                        this.input.consume();

                                    } else {
                                        MismatchedSetException mse = new MismatchedSetException(null, this.input);
                                        this.recover(mse);
                                        throw mse;
                                    }

                                }
                                    break;
                                case 2:
                                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:322:66:
                                // ~ ( ( '\\\\' | '\"' ) )
                                {
                                    if ((this.input.LA(1) >= '\u0000' && this.input.LA(1) <= '!')
                                            || (this.input.LA(1) >= '#' && this.input.LA(1) <= '[')
                                            || (this.input.LA(1) >= ']' && this.input.LA(1) <= '\uFFFF')) {
                                        this.input.consume();

                                    } else {
                                        MismatchedSetException mse = new MismatchedSetException(null, this.input);
                                        this.recover(mse);
                                        throw mse;
                                    }

                                }
                                    break;

                                default:
                                    break loop4;
                            }
                        } while (true);

                        this.match('\"');

                    }
                        break;
                    case 2:
                    // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:322:86:
                    // '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"'
                    // | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                        this.match('\'');
                        // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:322:91:
                        // ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' |
                        // '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
                        loop5: do {
                            int alt5 = 3;
                            int LA5_0 = this.input.LA(1);

                            if ((LA5_0 == '\\')) {
                                alt5 = 1;
                            } else if (((LA5_0 >= '\u0000' && LA5_0 <= '&') || (LA5_0 >= '(' && LA5_0 <= '[') || (LA5_0 >= ']' && LA5_0 <= '\uFFFF'))) {
                                alt5 = 2;
                            }

                            switch (alt5) {
                                case 1:
                                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:322:92:
                                // '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' |
                                // '\"' | '\\'' | '\\\\' )
                                {
                                    this.match('\\');
                                    if (this.input.LA(1) == '\"' || this.input.LA(1) == '\''
                                            || this.input.LA(1) == '\\' || this.input.LA(1) == 'b'
                                            || this.input.LA(1) == 'f' || this.input.LA(1) == 'n'
                                            || this.input.LA(1) == 'r'
                                            || (this.input.LA(1) >= 't' && this.input.LA(1) <= 'u')) {
                                        this.input.consume();

                                    } else {
                                        MismatchedSetException mse = new MismatchedSetException(null, this.input);
                                        this.recover(mse);
                                        throw mse;
                                    }

                                }
                                    break;
                                case 2:
                                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:322:137:
                                // ~ ( ( '\\\\' | '\\'' ) )
                                {
                                    if ((this.input.LA(1) >= '\u0000' && this.input.LA(1) <= '&')
                                            || (this.input.LA(1) >= '(' && this.input.LA(1) <= '[')
                                            || (this.input.LA(1) >= ']' && this.input.LA(1) <= '\uFFFF')) {
                                        this.input.consume();

                                    } else {
                                        MismatchedSetException mse = new MismatchedSetException(null, this.input);
                                        this.recover(mse);
                                        throw mse;
                                    }

                                }
                                    break;

                                default:
                                    break loop5;
                            }
                        } while (true);

                        this.match('\'');

                    }
                        break;

                }

            }

            this.state.type = _type;
            this.state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "RULE_STRING"
    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = InternalEmfExecutionConfigurationLexer.RULE_WS;
            int _channel = BaseRecognizer.DEFAULT_TOKEN_CHANNEL;
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:328:9:
            // ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:328:11:
            // ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
                // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:328:11:
                // ( ' ' | '\\t' | '\\r' | '\\n' )+
                int cnt11 = 0;
                loop11: do {
                    int alt11 = 2;
                    int LA11_0 = this.input.LA(1);

                    if (((LA11_0 >= '\t' && LA11_0 <= '\n') || LA11_0 == '\r' || LA11_0 == ' ')) {
                        alt11 = 1;
                    }

                    switch (alt11) {
                        case 1:
                        // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:
                        {
                            if ((this.input.LA(1) >= '\t' && this.input.LA(1) <= '\n') || this.input.LA(1) == '\r'
                                    || this.input.LA(1) == ' ') {
                                this.input.consume();

                            } else {
                                MismatchedSetException mse = new MismatchedSetException(null, this.input);
                                this.recover(mse);
                                throw mse;
                            }

                        }
                            break;

                        default:
                            if (cnt11 >= 1) {
                                break loop11;
                            }
                            EarlyExitException eee = new EarlyExitException(11, this.input);
                            throw eee;
                    }
                    cnt11++;
                } while (true);

            }

            this.state.type = _type;
            this.state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "RULE_WS"

    // $ANTLR start "T__11"
    public final void mT__11() throws RecognitionException {
        try {
            int _type = InternalEmfExecutionConfigurationLexer.T__11;
            int _channel = BaseRecognizer.DEFAULT_TOKEN_CHANNEL;
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:11:7:
            // ( 'When' )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:11:9:
            // 'When'
            {
                this.match("When");

            }

            this.state.type = _type;
            this.state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__11"
    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = InternalEmfExecutionConfigurationLexer.T__12;
            int _channel = BaseRecognizer.DEFAULT_TOKEN_CHANNEL;
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:12:7:
            // ( 'DSA' )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:12:9:
            // 'DSA'
            {
                this.match("DSA");

            }

            this.state.type = _type;
            this.state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__12"
    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = InternalEmfExecutionConfigurationLexer.T__13;
            int _channel = BaseRecognizer.DEFAULT_TOKEN_CHANNEL;
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:13:7:
            // ( 'returns' )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:13:9:
            // 'returns'
            {
                this.match("returns");

            }

            this.state.type = _type;
            this.state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__13"
    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = InternalEmfExecutionConfigurationLexer.T__14;
            int _channel = BaseRecognizer.DEFAULT_TOKEN_CHANNEL;
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:14:7:
            // ( 'true' )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:14:9:
            // 'true'
            {
                this.match("true");

            }

            this.state.type = _type;
            this.state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__14"
    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = InternalEmfExecutionConfigurationLexer.T__15;
            int _channel = BaseRecognizer.DEFAULT_TOKEN_CHANNEL;
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:15:7:
            // ( 'avoid' )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:15:9:
            // 'avoid'
            {
                this.match("avoid");

            }

            this.state.type = _type;
            this.state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__15"
    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = InternalEmfExecutionConfigurationLexer.T__16;
            int _channel = BaseRecognizer.DEFAULT_TOKEN_CHANNEL;
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:16:7:
            // ( ';' )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:16:9:
            // ';'
            {
                this.match(';');

            }

            this.state.type = _type;
            this.state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__16"
    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = InternalEmfExecutionConfigurationLexer.T__17;
            int _channel = BaseRecognizer.DEFAULT_TOKEN_CHANNEL;
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:17:7:
            // ( 'import' )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:17:9:
            // 'import'
            {
                this.match("import");

            }

            this.state.type = _type;
            this.state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = InternalEmfExecutionConfigurationLexer.T__18;
            int _channel = BaseRecognizer.DEFAULT_TOKEN_CHANNEL;
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:18:7:
            // ( 'importJar' )
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:18:9:
            // 'importJar'
            {
                this.match("importJar");

            }

            this.state.type = _type;
            this.state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__18"

    public void mTokens() throws RecognitionException {
        // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:1:8:
        // ( T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 |
        // RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT
        // | RULE_WS | RULE_ANY_OTHER )
        int alt12 = 15;
        alt12 = this.dfa12.predict(this.input);
        switch (alt12) {
            case 1:
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:1:10:
            // T__11
            {
                this.mT__11();

            }
                break;
            case 2:
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:1:16:
            // T__12
            {
                this.mT__12();

            }
                break;
            case 3:
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:1:22:
            // T__13
            {
                this.mT__13();

            }
                break;
            case 4:
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:1:28:
            // T__14
            {
                this.mT__14();

            }
                break;
            case 5:
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:1:34:
            // T__15
            {
                this.mT__15();

            }
                break;
            case 6:
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:1:40:
            // T__16
            {
                this.mT__16();

            }
                break;
            case 7:
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:1:46:
            // T__17
            {
                this.mT__17();

            }
                break;
            case 8:
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:1:52:
            // T__18
            {
                this.mT__18();

            }
                break;
            case 9:
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:1:58:
            // RULE_ID
            {
                this.mRULE_ID();

            }
                break;
            case 10:
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:1:66:
            // RULE_INT
            {
                this.mRULE_INT();

            }
                break;
            case 11:
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:1:75:
            // RULE_STRING
            {
                this.mRULE_STRING();

            }
                break;
            case 12:
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:1:87:
            // RULE_ML_COMMENT
            {
                this.mRULE_ML_COMMENT();

            }
                break;
            case 13:
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:1:103:
            // RULE_SL_COMMENT
            {
                this.mRULE_SL_COMMENT();

            }
                break;
            case 14:
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:1:119:
            // RULE_WS
            {
                this.mRULE_WS();

            }
                break;
            case 15:
            // ../fr.inria.aoste.timesquare.backend.emfexecution.configuration/src-gen/fr/inria/aoste/timesquare/backend/parser/antlr/internal/InternalEmfExecutionConfiguration.g:1:127:
            // RULE_ANY_OTHER
            {
                this.mRULE_ANY_OTHER();

            }
                break;

        }

    }

}