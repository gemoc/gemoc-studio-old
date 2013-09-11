%%
%% This is file `gemoc.cls',
%% THALES RESEARCH & TECHNOLOGY FRANCE
%%
\NeedsTeXFormat{LaTeX2e}[1995/12/01]
\ProvidesClass{gemoc}
              [2009/05/15 V1.0]
\typeout{****************************^^J%
         *  GEMOC  Document class  *^^J%
         ****************************}
\LoadClass[letterpaper,10pt,twoside,onecolumn,final,openany]{report}

\RequirePackage{lmodern}
\RequirePackage{fancyhdr}
\RequirePackage{graphicx}
\RequirePackage[english]{babel}
\RequirePackage{ifthen}
\RequirePackage{times}

\renewcommand\sfdefault{phv}
\renewcommand\familydefault{\sfdefault}

\RequirePackage{vmargin} 
\setpapersize{USletter}
\setmarginsrb{2.5cm}%			%leftmargin
%\setmargins{2.5cm}%			%leftmargin
					   {1cm}%     %topmargin
             {2.5cm}%	  	%rightmargin
             {1.5cm}%    %bottommargin
             %{16.5cm}%	  	%textwidth
             %{22.5cm}%    %textheight
             {1.5cm}%			%headheight
             {20pt}%     	%headsep
             {2cm}%				%footheight
             {20pt}%     	%footskip


\gdef\@docrefquery{document number}%
\gdef\@revisionquery{revision}%
\gdef\@revisiontitle{document control}
\gdef\@irevlabtabletitle{Revision index}
\gdef\@mrevlabtabletitle{Modifications}
\gdef\@authorstitle{Written by}
\gdef\@approverstitle{Approved by}
\gdef\@dateslabel{:\,}

\ProcessOptions
          
\newcommand{\subproject}[1]{\gdef\@subproject{#1}}
\newcommand{\task}[1]{\gdef\@task{#1}}
\newcommand{\version}[1]{\gdef\@revision{#1}}
\newcommand{\docnumber}[1]{\gdef\@docref{#1}}
\newcommand{\companycopyright}[1]{\gdef\@companycopyright{#1}}
\gdef\@revision{$<$1.0$>$}
\gdef\@docref{$<$Document Number$>$}
\gdef\@subproject{ANR INS GEMOC}
\gdef\@task{$<$x.y.z$>$}
\gdef\@companycopyright{Consortium GEMOC INS}

%%%%%%%%%%%
%% HEADERS AND FOOTERS
\renewcommand{\headrulewidth}{0.0pt}
\renewcommand{\footrulewidth}{0.0pt}
\lhead{}
\chead{\ifthenelse{\value{page}=1}{}{\centering \begin{tabular}{|p{11cm}|p{5cm}|}%
  \hline%
  \rm \@subproject\ / Task \@task & \rm Version: \hfill \rm \@revision \\ \hline%
  \rm \@title                     & \rm Date: \hfill \today \\ \hline%
  \multicolumn{2}{|l|}{\rm \@docref}\\ \hline
  \end{tabular}}}
\rhead{}
\lfoot[\rm{Page \thepage}]%
      {\rm Confidential}
\cfoot{\rm {\small \copyright} \@companycopyright, 2013 -- 2016}%    Consortium is company, 2009 is current year
\rfoot[\rm Confidential]%
      {\rm Page \thepage}

%%%%%%%%%%%%%
%% TITLEPAGE
  \if@titlepage
  \renewcommand\maketitle{
  
\begin{titlepage}%
	\thispagestyle{fancy}
  %\let\footnotesize\small
  \let\footnoterule\relax
  \let \footnote \thanks
%  \null\vfil
%  \vskip 60\p@

 	\vspace*{-1cm}
  	\hrule
		\medskip
		\centering \includegraphics[width=\textwidth]{gemoc}\\
		\medskip
		\hrule
	
	\vspace*{6cm}
		\hfill\Huge  \bf \@subproject \\
		\bigskip
		\hfill\LARGE \bf \@docref\ - \@title \\
		\hfill\LARGE \bf Task\ \@task \\
		\bigskip
		\hfill\Large \bf Version\ \@revision
	
  \@thanks
  %\vfil %\null
  \end{titlepage}%
 
  \setcounter{footnote}{0}%
	\global\let\thanks\relax
  \global\let\maketitle\relax
  \global\let\@thanks\@empty
  \global\let\@author\@empty
  \global\let\@date\@empty
  \global\let\author\relax
  \global\let\date\relax
  \global\let\and\relax
  \global\let\docref\relax
  \global\let\revision\relax
}

%%%%%%%
%% CHAPTER PAGE STYLE
\renewcommand*\chaptermark[1]{}
\renewcommand\chapter{
                    \global\@topnum\z@
                    \@afterindentfalse
                    \secdef\@chapter\@schapter}
\def\@makechapterhead#1{%
  \vspace*{30\p@}%
  {\parindent \z@ \raggedright \normalfont
    \ifnum \c@secnumdepth >\m@ne
        \large\bfseries
        \thechapter.\space
    \fi
    \interlinepenalty\@M
    \large #1\par\nobreak
    \vskip 20\p@
  }}

\def\@makeschapterhead#1{%
  \vspace*{30\p@}%
  {\parindent \z@ \raggedright
    \normalfont
    \interlinepenalty\@M
    \centering \Large #1 \par\nobreak
    \vskip 20\p@
  }}

\renewcommand\section{\@startsection {section}{1}{\z@}%
                                   {-3.5ex \@plus -1ex \@minus -.2ex}%
                                   {2.3ex \@plus.2ex}%
                                   {\normalfont\normalsize\bfseries}}
\renewcommand\subsection{\@startsection{subsection}{2}{\z@}%
                                     {-3.25ex\@plus -1ex \@minus -.2ex}%
                                     {1.5ex \@plus .2ex}%
                                     {\normalfont\normalsize\itshape}}
\renewcommand\subsubsection{\@startsection{subsubsection}{2}{\z@}%
                                     {-3.25ex\@plus -1ex \@minus -.2ex}%
                                     {1.5ex \@plus .2ex}%
                                     {\normalfont\normalsize}}


%%%%%%
%% BIBLIOGRAPHY PAGE STYLE
\renewenvironment{thebibliography}[1]
     {\@mkboth{\MakeUppercase\bibname}{\MakeUppercase\bibname}%
      \list{\@biblabel{\@arabic\c@enumiv}}%
           {\settowidth\labelwidth{\@biblabel{#1}}%
            \leftmargin\labelwidth
            \advance\leftmargin\labelsep
            \@openbib@code
            \usecounter{enumiv}%
            \let\p@enumiv\@empty
            \renewcommand\theenumiv{\@arabic\c@enumiv}}%
      \sloppy
      \clubpenalty4000
      \@clubpenalty \clubpenalty
      \widowpenalty4000%
      \sfcode`\.\@m}
     {\def\@noitemerr
       {\@latex@warning{Empty `thebibliography' environment}}%
      \endlist}



%%%%%%%%
%% BIBLIO REF ENVIRONNEMENTS
\newcommand{\references}[1]{%
	\section{References}%
		\ifthenelse{\equal{#1}{}}%
		   {\textit{Volontary left blank}}%
		   {\bibliographystyle{unsrt}\bibliography{#1}}%
%
%\newpage%
}

%%%%%%%%
%% REVISION FOLLOW UP
\newcounter{revisionvalue}
\newcounter{revlabvalue}
\newenvironment{revisions}{%
     \setcounter{revisionvalue}{0}
     \setcounter{revlabvalue}{0}

     \begin{center}
     		%\vspace*{0.3cm}
        \textbf{{\Large \MakeUppercase{\@revisiontitle}}}
      	\vspace{2,5cm}

}{\end{center}}

\newenvironment{revtable}{
	      %\hspace{-1cm}
	      \begin{tabular}{|p{2,2cm}|p{2,5cm}|p{2,5cm}|p{2,5cm}|p{2,5cm}|p{2,5cm}|}
		         \hline
}{  	 \hline
		\end{tabular}
}

\newenvironment{revisionlabels}{%
	\begin{center}
  \addtocounter{revisionvalue}{-1}
	\vspace{0,5cm}
	%\hspace{-1cm}
	\begin{tabular}{|p{3cm}|p{13,4cm}|}
		\hline
		{\@irevlabtabletitle} & \hspace{5,5cm}\@mrevlabtabletitle \rule[-7pt]{0pt}{20pt} \\ \hline
}
{
   \whiledo{\value{revlabvalue} < \value{revisionvalue}}{\revlabel{}} \ \revisionvaluetext{revlabvalue} & \rule[-7pt]{0pt}{20pt} \\ \hline
	\end{tabular}
	\stepcounter{revisionvalue}
\end{center}
}
%%%{label}
\newcommand{\revlabel}[1]{\ \revisionvaluetext{revlabvalue} & #1 \rule[-7pt]{0pt}{20pt} \\ \hline }

\newcommand{\dates}[5]{ &%
     \revisionvaluetext{revisionvalue}\textedate#1 &%
     \revisionvaluetext{revisionvalue}\textedate#2 &% 
     \revisionvaluetext{revisionvalue}\textedate#3 &% 
     \revisionvaluetext{revisionvalue}\textedate#4 &%
     \revisionvaluetext{revisionvalue}\textedate#5 \rule[-7pt]{0pt}{20pt}\\ \hline}

\newcommand{\writers}[5]{%
     \@authorstitle &%
     \names{#1} & \names{#2} & \names{#3} & \names{#4} & \names{#5} \\[0,5cm]%
     Signature& & & & & \\[1cm]}

\newcommand{\approvers}[5]{\hline%
     \@approverstitle &%
     \names{#1} & \names{#2} & \names{#3} & \names{#4} & \names{#5} \\[0,5cm]%
     Signature& & & & & \\[1cm]}

\newcommand{\textedate}{\@dateslabel}
\newcommand{\names}[1]{\hspace*{-4.5pt}\begin{tabular}{p{2,4cm}}\rule[0pt]{0pt}{13pt}#1 \end{tabular}}
\newcommand{\revisionvaluetext}[1]{\ifthenelse{\value{#1}=0}{--}{\Alph{#1}}\stepcounter{#1}}


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%% TABLE OF AUTHORS 
\newenvironment{tableofauthors}{
	\newpage
	\centering \Large \textbf{Authors}\\%
	\bigskip
	\normalsize
	\begin{tabular}{|p{7cm}|p{5cm}|p{3.5cm}|}
	\hline 
	\begin{center}\bf Author \end{center}& \begin{center} \bf Partner \end{center} & \begin{center} \bf Role \end{center}\\ \hline
	}
	{\end{tabular}
	\newpage}
	
\newcommand{\leadauthor}[2]{#1 & #2 & Lead author  \\ \hline }
\newcommand{\redactor}[2]{#1 & #2 & Author  \\ \hline }
\newcommand{\contributor}[2]{#1 & #2 & Contributor \\ \hline }

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%% INTRODUCTION OF DOCUMENT 
\newenvironment{introduction}{
\begin{center}\Large \bf \@title \end{center}
\chapter{Introduction}\label{sec:introduction}}{}


%%%%%%%%%%%%%%%%%%%%
%% CAPTION
\long\def\@makecaption#1#2{%
	\rm \itshape
  \vskip\abovecaptionskip
  \sbox\@tempboxa{#1: #2}%
  \ifdim \wd\@tempboxa >\hsize
     #1: #2\par
  \else
    \global \@minipagefalse
    \hb@xt@\hsize{\hfil\box\@tempboxa\hfil}%
  \fi
  \vskip\belowcaptionskip}


%\setcounter{page}{2}
\pagestyle{fancy}
