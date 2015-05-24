ALLDOT=${shell echo *.dot}
ALLPNG=${ALLDOT:%.dot=%.png}

all: ${ALLPNG}

#	step.png command.png artifact_add.png artifact_update.png
#
#step.png: ../fig
#	cp $</$@ $@
#
#command.png: ../fig
#	cp $</$@ $@
#
#artifact_update.png: ../fig
#	cp $</$@ $@
#
#artifact_add.png: ../fig
#	cp $</$@ $@

clean:
	${RM} *.dot ${ALLPNG}

%.png: %.dot
	dot -Tpng "$<" -o "$@"
