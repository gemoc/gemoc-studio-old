PDFFILES = \
	automate-abcd-star.pdf	\
	automate-aSbaS.pdf	\
	automate-mots.pdf	\
	automate-ccomm.pdf	\
	automate-abcde.pdf	\

GENERES =	\
	${PDFFILES:%.pdf=%.png}	\
	xDSML-definition-process-general.png	\
	xDSML-definition-process-overview.png	\

	# ${PDFFILES}	\

ifndef TOOLSDIR
TOOLSDIR = ../../tools
endif

all: ${GENERES}


clean:
	${RM} ${GENERES}

test:
	echo ${TOOLSDIR}

%.pdf: %.dot
	dot -Tpdf $< > $@

%.png: %.dot
	dot -Tpng $< > $@

%.png: %.plantuml
	java -jar ${TOOLSDIR}/plantuml.jar -tpng $<
