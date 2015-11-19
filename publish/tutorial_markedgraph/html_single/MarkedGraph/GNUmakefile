#
#  WARNING: This makefile is only used locally to update files that are put on
#  the source repository. No need to run it!
#

include ${HOME}/usr/make/generes.make

ALL = markedgraph.xtend markedgraph.ecl markedgraph-library.ecl
# markedgraph.ecore
MARKEDGRAPH_PROJECT = ${HOME}/workspace-markedgraph/
MARKEDGRAPH_PROJECT = ${HOME}/workspace-mg/
MARKEDGRAPH_PROJECT = ${HOME}/workspace-mg10/
MARKEDGRAPH_PROJECT = ${HOME}/workspace-mg15/
MARKEDGRAPH_PREFIX = ${MARKEDGRAPH_PROJECT}org.gemoc.example.markedgraph
MARKEDGRAPH_PREFIX = ${MARKEDGRAPH_PROJECT}org.gemoc.sample.markedgraph

all: generes
generes:: ${ALL}

markedgraph.ecore: ${MARKEDGRAPH_PREFIX}.model/model/markedgraph.ecore
	cp $< $@

# markedgraph-xtend.xtend: ${MARKEDGRAPH_PREFIX}.k3dsa/src/markedgraph/markedgraph.xtend

markedgraph.ecl: markedgraph-modele.ecl
	${call COPY_command,$@,$<,xcfiltre -MoCCML +ECL_ONLY -MoCCLIB}

markedgraph-library.ecl: markedgraph-modele.ecl
	${call COPY_command,$@,$<,xcfiltre +MoCCML -ECL_ONLY}

#markedgraph.ecl: ${MARKEDGRAPH_PREFIX}.dse/ecl/markedgraph.ecl
#	cp $< $@
