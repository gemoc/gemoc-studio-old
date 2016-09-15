package org.gemoc.gexpressions.xtext.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.gemoc.gexpressions.GAdditionExpression;
import org.gemoc.gexpressions.GAndExpression;
import org.gemoc.gexpressions.GBooleanExpression;
import org.gemoc.gexpressions.GBraceExpression;
import org.gemoc.gexpressions.GDoubleExpression;
import org.gemoc.gexpressions.GEnumLiteralExpression;
import org.gemoc.gexpressions.GEqualityExpression;
import org.gemoc.gexpressions.GIfExpression;
import org.gemoc.gexpressions.GImportStatement;
import org.gemoc.gexpressions.GIntegerExpression;
import org.gemoc.gexpressions.GMultiplicationExpression;
import org.gemoc.gexpressions.GNavigationExpression;
import org.gemoc.gexpressions.GNegationExpression;
import org.gemoc.gexpressions.GOrExpression;
import org.gemoc.gexpressions.GProgram;
import org.gemoc.gexpressions.GReferenceExpression;
import org.gemoc.gexpressions.GRelationExpression;
import org.gemoc.gexpressions.GStringExpression;
import org.gemoc.gexpressions.GXorExpression;
import org.gemoc.gexpressions.GexpressionsPackage;
import org.gemoc.gexpressions.xtext.services.GExpressionsGrammarAccess;

@SuppressWarnings("all")
public abstract class AbstractGExpressionsSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private GExpressionsGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == GexpressionsPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case GexpressionsPackage.GADDITION_EXPRESSION:
				if(context == grammarAccess.getGAdditionExpressionRule() ||
				   context == grammarAccess.getGAdditionExpressionAccess().getGAdditionExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGAndExpressionRule() ||
				   context == grammarAccess.getGAndExpressionAccess().getGAndExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGEqualityExpressionRule() ||
				   context == grammarAccess.getGEqualityExpressionAccess().getGEqualityExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGExpressionRule() ||
				   context == grammarAccess.getGOrExpressionRule() ||
				   context == grammarAccess.getGOrExpressionAccess().getGOrExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGRelationExpressionRule() ||
				   context == grammarAccess.getGRelationExpressionAccess().getGRelationExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGXorExpressionRule() ||
				   context == grammarAccess.getGXorExpressionAccess().getGXorExpressionLeftOperandAction_1_0()) {
					sequence_GAdditionExpression(context, (GAdditionExpression) semanticObject); 
					return; 
				}
				else break;
			case GexpressionsPackage.GAND_EXPRESSION:
				if(context == grammarAccess.getGAndExpressionRule() ||
				   context == grammarAccess.getGAndExpressionAccess().getGAndExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGExpressionRule() ||
				   context == grammarAccess.getGOrExpressionRule() ||
				   context == grammarAccess.getGOrExpressionAccess().getGOrExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGXorExpressionRule() ||
				   context == grammarAccess.getGXorExpressionAccess().getGXorExpressionLeftOperandAction_1_0()) {
					sequence_GAndExpression(context, (GAndExpression) semanticObject); 
					return; 
				}
				else break;
			case GexpressionsPackage.GBOOLEAN_EXPRESSION:
				if(context == grammarAccess.getGAdditionExpressionRule() ||
				   context == grammarAccess.getGAdditionExpressionAccess().getGAdditionExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGAndExpressionRule() ||
				   context == grammarAccess.getGAndExpressionAccess().getGAndExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGBooleanExpressionRule() ||
				   context == grammarAccess.getGEqualityExpressionRule() ||
				   context == grammarAccess.getGEqualityExpressionAccess().getGEqualityExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGExpressionRule() ||
				   context == grammarAccess.getGMultiplicationExpressionRule() ||
				   context == grammarAccess.getGMultiplicationExpressionAccess().getGMultiplicationExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGNavigationExpressionRule() ||
				   context == grammarAccess.getGNavigationExpressionAccess().getGNavigationExpressionBodyAction_1_0() ||
				   context == grammarAccess.getGNegationExpressionRule() ||
				   context == grammarAccess.getGOrExpressionRule() ||
				   context == grammarAccess.getGOrExpressionAccess().getGOrExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGPrimaryExpressionRule() ||
				   context == grammarAccess.getGReferenceExpressionRule() ||
				   context == grammarAccess.getGRelationExpressionRule() ||
				   context == grammarAccess.getGRelationExpressionAccess().getGRelationExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGXorExpressionRule() ||
				   context == grammarAccess.getGXorExpressionAccess().getGXorExpressionLeftOperandAction_1_0()) {
					sequence_GBooleanExpression(context, (GBooleanExpression) semanticObject); 
					return; 
				}
				else break;
			case GexpressionsPackage.GBRACE_EXPRESSION:
				if(context == grammarAccess.getGAdditionExpressionRule() ||
				   context == grammarAccess.getGAdditionExpressionAccess().getGAdditionExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGAndExpressionRule() ||
				   context == grammarAccess.getGAndExpressionAccess().getGAndExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGBraceExpressionRule() ||
				   context == grammarAccess.getGEqualityExpressionRule() ||
				   context == grammarAccess.getGEqualityExpressionAccess().getGEqualityExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGExpressionRule() ||
				   context == grammarAccess.getGMultiplicationExpressionRule() ||
				   context == grammarAccess.getGMultiplicationExpressionAccess().getGMultiplicationExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGNavigationExpressionRule() ||
				   context == grammarAccess.getGNavigationExpressionAccess().getGNavigationExpressionBodyAction_1_0() ||
				   context == grammarAccess.getGNegationExpressionRule() ||
				   context == grammarAccess.getGOrExpressionRule() ||
				   context == grammarAccess.getGOrExpressionAccess().getGOrExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGPrimaryExpressionRule() ||
				   context == grammarAccess.getGReferenceExpressionRule() ||
				   context == grammarAccess.getGRelationExpressionRule() ||
				   context == grammarAccess.getGRelationExpressionAccess().getGRelationExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGXorExpressionRule() ||
				   context == grammarAccess.getGXorExpressionAccess().getGXorExpressionLeftOperandAction_1_0()) {
					sequence_GBraceExpression(context, (GBraceExpression) semanticObject); 
					return; 
				}
				else break;
			case GexpressionsPackage.GDOUBLE_EXPRESSION:
				if(context == grammarAccess.getGAdditionExpressionRule() ||
				   context == grammarAccess.getGAdditionExpressionAccess().getGAdditionExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGAndExpressionRule() ||
				   context == grammarAccess.getGAndExpressionAccess().getGAndExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGDoubleExpressionRule() ||
				   context == grammarAccess.getGEqualityExpressionRule() ||
				   context == grammarAccess.getGEqualityExpressionAccess().getGEqualityExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGExpressionRule() ||
				   context == grammarAccess.getGMultiplicationExpressionRule() ||
				   context == grammarAccess.getGMultiplicationExpressionAccess().getGMultiplicationExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGNavigationExpressionRule() ||
				   context == grammarAccess.getGNavigationExpressionAccess().getGNavigationExpressionBodyAction_1_0() ||
				   context == grammarAccess.getGNegationExpressionRule() ||
				   context == grammarAccess.getGNumericExpressionRule() ||
				   context == grammarAccess.getGOrExpressionRule() ||
				   context == grammarAccess.getGOrExpressionAccess().getGOrExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGPrimaryExpressionRule() ||
				   context == grammarAccess.getGReferenceExpressionRule() ||
				   context == grammarAccess.getGRelationExpressionRule() ||
				   context == grammarAccess.getGRelationExpressionAccess().getGRelationExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGXorExpressionRule() ||
				   context == grammarAccess.getGXorExpressionAccess().getGXorExpressionLeftOperandAction_1_0()) {
					sequence_GDoubleExpression(context, (GDoubleExpression) semanticObject); 
					return; 
				}
				else break;
			case GexpressionsPackage.GENUM_LITERAL_EXPRESSION:
				if(context == grammarAccess.getGAdditionExpressionRule() ||
				   context == grammarAccess.getGAdditionExpressionAccess().getGAdditionExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGAndExpressionRule() ||
				   context == grammarAccess.getGAndExpressionAccess().getGAndExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGEnumLiteralExpressionRule() ||
				   context == grammarAccess.getGEqualityExpressionRule() ||
				   context == grammarAccess.getGEqualityExpressionAccess().getGEqualityExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGExpressionRule() ||
				   context == grammarAccess.getGMultiplicationExpressionRule() ||
				   context == grammarAccess.getGMultiplicationExpressionAccess().getGMultiplicationExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGNavigationExpressionRule() ||
				   context == grammarAccess.getGNavigationExpressionAccess().getGNavigationExpressionBodyAction_1_0() ||
				   context == grammarAccess.getGNegationExpressionRule() ||
				   context == grammarAccess.getGOrExpressionRule() ||
				   context == grammarAccess.getGOrExpressionAccess().getGOrExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGPrimaryExpressionRule() ||
				   context == grammarAccess.getGReferenceExpressionRule() ||
				   context == grammarAccess.getGRelationExpressionRule() ||
				   context == grammarAccess.getGRelationExpressionAccess().getGRelationExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGXorExpressionRule() ||
				   context == grammarAccess.getGXorExpressionAccess().getGXorExpressionLeftOperandAction_1_0()) {
					sequence_GEnumLiteralExpression(context, (GEnumLiteralExpression) semanticObject); 
					return; 
				}
				else break;
			case GexpressionsPackage.GEQUALITY_EXPRESSION:
				if(context == grammarAccess.getGAndExpressionRule() ||
				   context == grammarAccess.getGAndExpressionAccess().getGAndExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGEqualityExpressionRule() ||
				   context == grammarAccess.getGEqualityExpressionAccess().getGEqualityExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGExpressionRule() ||
				   context == grammarAccess.getGOrExpressionRule() ||
				   context == grammarAccess.getGOrExpressionAccess().getGOrExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGXorExpressionRule() ||
				   context == grammarAccess.getGXorExpressionAccess().getGXorExpressionLeftOperandAction_1_0()) {
					sequence_GEqualityExpression(context, (GEqualityExpression) semanticObject); 
					return; 
				}
				else break;
			case GexpressionsPackage.GIF_EXPRESSION:
				if(context == grammarAccess.getGAdditionExpressionRule() ||
				   context == grammarAccess.getGAdditionExpressionAccess().getGAdditionExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGAndExpressionRule() ||
				   context == grammarAccess.getGAndExpressionAccess().getGAndExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGEqualityExpressionRule() ||
				   context == grammarAccess.getGEqualityExpressionAccess().getGEqualityExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGExpressionRule() ||
				   context == grammarAccess.getGIfExpressionRule() ||
				   context == grammarAccess.getGMultiplicationExpressionRule() ||
				   context == grammarAccess.getGMultiplicationExpressionAccess().getGMultiplicationExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGNavigationExpressionRule() ||
				   context == grammarAccess.getGNavigationExpressionAccess().getGNavigationExpressionBodyAction_1_0() ||
				   context == grammarAccess.getGNegationExpressionRule() ||
				   context == grammarAccess.getGOrExpressionRule() ||
				   context == grammarAccess.getGOrExpressionAccess().getGOrExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGPrimaryExpressionRule() ||
				   context == grammarAccess.getGReferenceExpressionRule() ||
				   context == grammarAccess.getGRelationExpressionRule() ||
				   context == grammarAccess.getGRelationExpressionAccess().getGRelationExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGXorExpressionRule() ||
				   context == grammarAccess.getGXorExpressionAccess().getGXorExpressionLeftOperandAction_1_0()) {
					sequence_GIfExpression(context, (GIfExpression) semanticObject); 
					return; 
				}
				else break;
			case GexpressionsPackage.GIMPORT_STATEMENT:
				if(context == grammarAccess.getGImportStatementRule()) {
					sequence_GImportStatement(context, (GImportStatement) semanticObject); 
					return; 
				}
				else break;
			case GexpressionsPackage.GINTEGER_EXPRESSION:
				if(context == grammarAccess.getGAdditionExpressionRule() ||
				   context == grammarAccess.getGAdditionExpressionAccess().getGAdditionExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGAndExpressionRule() ||
				   context == grammarAccess.getGAndExpressionAccess().getGAndExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGEqualityExpressionRule() ||
				   context == grammarAccess.getGEqualityExpressionAccess().getGEqualityExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGExpressionRule() ||
				   context == grammarAccess.getGIntegerExpressionRule() ||
				   context == grammarAccess.getGMultiplicationExpressionRule() ||
				   context == grammarAccess.getGMultiplicationExpressionAccess().getGMultiplicationExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGNavigationExpressionRule() ||
				   context == grammarAccess.getGNavigationExpressionAccess().getGNavigationExpressionBodyAction_1_0() ||
				   context == grammarAccess.getGNegationExpressionRule() ||
				   context == grammarAccess.getGNumericExpressionRule() ||
				   context == grammarAccess.getGOrExpressionRule() ||
				   context == grammarAccess.getGOrExpressionAccess().getGOrExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGPrimaryExpressionRule() ||
				   context == grammarAccess.getGReferenceExpressionRule() ||
				   context == grammarAccess.getGRelationExpressionRule() ||
				   context == grammarAccess.getGRelationExpressionAccess().getGRelationExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGXorExpressionRule() ||
				   context == grammarAccess.getGXorExpressionAccess().getGXorExpressionLeftOperandAction_1_0()) {
					sequence_GIntegerExpression(context, (GIntegerExpression) semanticObject); 
					return; 
				}
				else break;
			case GexpressionsPackage.GMULTIPLICATION_EXPRESSION:
				if(context == grammarAccess.getGAdditionExpressionRule() ||
				   context == grammarAccess.getGAdditionExpressionAccess().getGAdditionExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGAndExpressionRule() ||
				   context == grammarAccess.getGAndExpressionAccess().getGAndExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGEqualityExpressionRule() ||
				   context == grammarAccess.getGEqualityExpressionAccess().getGEqualityExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGExpressionRule() ||
				   context == grammarAccess.getGMultiplicationExpressionRule() ||
				   context == grammarAccess.getGMultiplicationExpressionAccess().getGMultiplicationExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGOrExpressionRule() ||
				   context == grammarAccess.getGOrExpressionAccess().getGOrExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGRelationExpressionRule() ||
				   context == grammarAccess.getGRelationExpressionAccess().getGRelationExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGXorExpressionRule() ||
				   context == grammarAccess.getGXorExpressionAccess().getGXorExpressionLeftOperandAction_1_0()) {
					sequence_GMultiplicationExpression(context, (GMultiplicationExpression) semanticObject); 
					return; 
				}
				else break;
			case GexpressionsPackage.GNAVIGATION_EXPRESSION:
				if(context == grammarAccess.getGAdditionExpressionRule() ||
				   context == grammarAccess.getGAdditionExpressionAccess().getGAdditionExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGAndExpressionRule() ||
				   context == grammarAccess.getGAndExpressionAccess().getGAndExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGEqualityExpressionRule() ||
				   context == grammarAccess.getGEqualityExpressionAccess().getGEqualityExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGExpressionRule() ||
				   context == grammarAccess.getGMultiplicationExpressionRule() ||
				   context == grammarAccess.getGMultiplicationExpressionAccess().getGMultiplicationExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGNavigationExpressionRule() ||
				   context == grammarAccess.getGNavigationExpressionAccess().getGNavigationExpressionBodyAction_1_0() ||
				   context == grammarAccess.getGNegationExpressionRule() ||
				   context == grammarAccess.getGOrExpressionRule() ||
				   context == grammarAccess.getGOrExpressionAccess().getGOrExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGRelationExpressionRule() ||
				   context == grammarAccess.getGRelationExpressionAccess().getGRelationExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGXorExpressionRule() ||
				   context == grammarAccess.getGXorExpressionAccess().getGXorExpressionLeftOperandAction_1_0()) {
					sequence_GNavigationExpression(context, (GNavigationExpression) semanticObject); 
					return; 
				}
				else break;
			case GexpressionsPackage.GNEGATION_EXPRESSION:
				if(context == grammarAccess.getGAdditionExpressionRule() ||
				   context == grammarAccess.getGAdditionExpressionAccess().getGAdditionExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGAndExpressionRule() ||
				   context == grammarAccess.getGAndExpressionAccess().getGAndExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGEqualityExpressionRule() ||
				   context == grammarAccess.getGEqualityExpressionAccess().getGEqualityExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGExpressionRule() ||
				   context == grammarAccess.getGMultiplicationExpressionRule() ||
				   context == grammarAccess.getGMultiplicationExpressionAccess().getGMultiplicationExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGNegationExpressionRule() ||
				   context == grammarAccess.getGOrExpressionRule() ||
				   context == grammarAccess.getGOrExpressionAccess().getGOrExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGRelationExpressionRule() ||
				   context == grammarAccess.getGRelationExpressionAccess().getGRelationExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGXorExpressionRule() ||
				   context == grammarAccess.getGXorExpressionAccess().getGXorExpressionLeftOperandAction_1_0()) {
					sequence_GNegationExpression(context, (GNegationExpression) semanticObject); 
					return; 
				}
				else break;
			case GexpressionsPackage.GOR_EXPRESSION:
				if(context == grammarAccess.getGExpressionRule() ||
				   context == grammarAccess.getGOrExpressionRule() ||
				   context == grammarAccess.getGOrExpressionAccess().getGOrExpressionLeftOperandAction_1_0()) {
					sequence_GOrExpression(context, (GOrExpression) semanticObject); 
					return; 
				}
				else break;
			case GexpressionsPackage.GPROGRAM:
				if(context == grammarAccess.getGProgramRule()) {
					sequence_GProgram(context, (GProgram) semanticObject); 
					return; 
				}
				else break;
			case GexpressionsPackage.GREFERENCE_EXPRESSION:
				if(context == grammarAccess.getGAdditionExpressionRule() ||
				   context == grammarAccess.getGAdditionExpressionAccess().getGAdditionExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGAndExpressionRule() ||
				   context == grammarAccess.getGAndExpressionAccess().getGAndExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGEqualityExpressionRule() ||
				   context == grammarAccess.getGEqualityExpressionAccess().getGEqualityExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGExpressionRule() ||
				   context == grammarAccess.getGMultiplicationExpressionRule() ||
				   context == grammarAccess.getGMultiplicationExpressionAccess().getGMultiplicationExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGNavigationExpressionRule() ||
				   context == grammarAccess.getGNavigationExpressionAccess().getGNavigationExpressionBodyAction_1_0() ||
				   context == grammarAccess.getGNegationExpressionRule() ||
				   context == grammarAccess.getGOrExpressionRule() ||
				   context == grammarAccess.getGOrExpressionAccess().getGOrExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGReferenceExpressionRule() ||
				   context == grammarAccess.getGRelationExpressionRule() ||
				   context == grammarAccess.getGRelationExpressionAccess().getGRelationExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGXorExpressionRule() ||
				   context == grammarAccess.getGXorExpressionAccess().getGXorExpressionLeftOperandAction_1_0()) {
					sequence_GReferenceExpression(context, (GReferenceExpression) semanticObject); 
					return; 
				}
				else break;
			case GexpressionsPackage.GRELATION_EXPRESSION:
				if(context == grammarAccess.getGAndExpressionRule() ||
				   context == grammarAccess.getGAndExpressionAccess().getGAndExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGEqualityExpressionRule() ||
				   context == grammarAccess.getGEqualityExpressionAccess().getGEqualityExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGExpressionRule() ||
				   context == grammarAccess.getGOrExpressionRule() ||
				   context == grammarAccess.getGOrExpressionAccess().getGOrExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGRelationExpressionRule() ||
				   context == grammarAccess.getGRelationExpressionAccess().getGRelationExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGXorExpressionRule() ||
				   context == grammarAccess.getGXorExpressionAccess().getGXorExpressionLeftOperandAction_1_0()) {
					sequence_GRelationExpression(context, (GRelationExpression) semanticObject); 
					return; 
				}
				else break;
			case GexpressionsPackage.GSTRING_EXPRESSION:
				if(context == grammarAccess.getGAdditionExpressionRule() ||
				   context == grammarAccess.getGAdditionExpressionAccess().getGAdditionExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGAndExpressionRule() ||
				   context == grammarAccess.getGAndExpressionAccess().getGAndExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGEqualityExpressionRule() ||
				   context == grammarAccess.getGEqualityExpressionAccess().getGEqualityExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGExpressionRule() ||
				   context == grammarAccess.getGMultiplicationExpressionRule() ||
				   context == grammarAccess.getGMultiplicationExpressionAccess().getGMultiplicationExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGNavigationExpressionRule() ||
				   context == grammarAccess.getGNavigationExpressionAccess().getGNavigationExpressionBodyAction_1_0() ||
				   context == grammarAccess.getGNegationExpressionRule() ||
				   context == grammarAccess.getGOrExpressionRule() ||
				   context == grammarAccess.getGOrExpressionAccess().getGOrExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGPrimaryExpressionRule() ||
				   context == grammarAccess.getGReferenceExpressionRule() ||
				   context == grammarAccess.getGRelationExpressionRule() ||
				   context == grammarAccess.getGRelationExpressionAccess().getGRelationExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGStringExpressionRule() ||
				   context == grammarAccess.getGXorExpressionRule() ||
				   context == grammarAccess.getGXorExpressionAccess().getGXorExpressionLeftOperandAction_1_0()) {
					sequence_GStringExpression(context, (GStringExpression) semanticObject); 
					return; 
				}
				else break;
			case GexpressionsPackage.GXOR_EXPRESSION:
				if(context == grammarAccess.getGExpressionRule() ||
				   context == grammarAccess.getGOrExpressionRule() ||
				   context == grammarAccess.getGOrExpressionAccess().getGOrExpressionLeftOperandAction_1_0() ||
				   context == grammarAccess.getGXorExpressionRule() ||
				   context == grammarAccess.getGXorExpressionAccess().getGXorExpressionLeftOperandAction_1_0()) {
					sequence_GXorExpression(context, (GXorExpression) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (leftOperand=GAdditionExpression_GAdditionExpression_1_0 operator=GAdditionOperator rightOperand=GMultiplicationExpression)
	 */
	protected void sequence_GAdditionExpression(EObject context, GAdditionExpression semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, GexpressionsPackage.Literals.GBINARY_OPERATOR_EXPRESSION__LEFT_OPERAND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GexpressionsPackage.Literals.GBINARY_OPERATOR_EXPRESSION__LEFT_OPERAND));
			if(transientValues.isValueTransient(semanticObject, GexpressionsPackage.Literals.GBINARY_OPERATOR_EXPRESSION__RIGHT_OPERAND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GexpressionsPackage.Literals.GBINARY_OPERATOR_EXPRESSION__RIGHT_OPERAND));
			if(transientValues.isValueTransient(semanticObject, GexpressionsPackage.Literals.GADDITION_EXPRESSION__OPERATOR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GexpressionsPackage.Literals.GADDITION_EXPRESSION__OPERATOR));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getGAdditionExpressionAccess().getGAdditionExpressionLeftOperandAction_1_0(), semanticObject.getLeftOperand());
		feeder.accept(grammarAccess.getGAdditionExpressionAccess().getOperatorGAdditionOperatorEnumRuleCall_1_1_0(), semanticObject.getOperator());
		feeder.accept(grammarAccess.getGAdditionExpressionAccess().getRightOperandGMultiplicationExpressionParserRuleCall_1_2_0(), semanticObject.getRightOperand());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (leftOperand=GAndExpression_GAndExpression_1_0 operator=GAndOperator rightOperand=GEqualityExpression)
	 */
	protected void sequence_GAndExpression(EObject context, GAndExpression semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, GexpressionsPackage.Literals.GBINARY_OPERATOR_EXPRESSION__LEFT_OPERAND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GexpressionsPackage.Literals.GBINARY_OPERATOR_EXPRESSION__LEFT_OPERAND));
			if(transientValues.isValueTransient(semanticObject, GexpressionsPackage.Literals.GBINARY_OPERATOR_EXPRESSION__RIGHT_OPERAND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GexpressionsPackage.Literals.GBINARY_OPERATOR_EXPRESSION__RIGHT_OPERAND));
			if(transientValues.isValueTransient(semanticObject, GexpressionsPackage.Literals.GAND_EXPRESSION__OPERATOR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GexpressionsPackage.Literals.GAND_EXPRESSION__OPERATOR));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getGAndExpressionAccess().getGAndExpressionLeftOperandAction_1_0(), semanticObject.getLeftOperand());
		feeder.accept(grammarAccess.getGAndExpressionAccess().getOperatorGAndOperatorEnumRuleCall_1_1_0(), semanticObject.getOperator());
		feeder.accept(grammarAccess.getGAndExpressionAccess().getRightOperandGEqualityExpressionParserRuleCall_1_2_0(), semanticObject.getRightOperand());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     value=BOOLEAN
	 */
	protected void sequence_GBooleanExpression(EObject context, GBooleanExpression semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, GexpressionsPackage.Literals.GBOOLEAN_EXPRESSION__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GexpressionsPackage.Literals.GBOOLEAN_EXPRESSION__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getGBooleanExpressionAccess().getValueBOOLEANTerminalRuleCall_1_0(), semanticObject.isValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     innerExpression=GExpression
	 */
	protected void sequence_GBraceExpression(EObject context, GBraceExpression semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, GexpressionsPackage.Literals.GBRACE_EXPRESSION__INNER_EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GexpressionsPackage.Literals.GBRACE_EXPRESSION__INNER_EXPRESSION));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getGBraceExpressionAccess().getInnerExpressionGExpressionParserRuleCall_2_0(), semanticObject.getInnerExpression());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     value=DOUBLE
	 */
	protected void sequence_GDoubleExpression(EObject context, GDoubleExpression semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, GexpressionsPackage.Literals.GDOUBLE_EXPRESSION__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GexpressionsPackage.Literals.GDOUBLE_EXPRESSION__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getGDoubleExpressionAccess().getValueDOUBLETerminalRuleCall_1_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     value=[EEnumLiteral|QualifiedName]
	 */
	protected void sequence_GEnumLiteralExpression(EObject context, GEnumLiteralExpression semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, GexpressionsPackage.Literals.GENUM_LITERAL_EXPRESSION__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GexpressionsPackage.Literals.GENUM_LITERAL_EXPRESSION__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getGEnumLiteralExpressionAccess().getValueEEnumLiteralQualifiedNameParserRuleCall_2_0_1(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (leftOperand=GEqualityExpression_GEqualityExpression_1_0 operator=GEqualityOperator rightOperand=GRelationExpression)
	 */
	protected void sequence_GEqualityExpression(EObject context, GEqualityExpression semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, GexpressionsPackage.Literals.GBINARY_OPERATOR_EXPRESSION__LEFT_OPERAND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GexpressionsPackage.Literals.GBINARY_OPERATOR_EXPRESSION__LEFT_OPERAND));
			if(transientValues.isValueTransient(semanticObject, GexpressionsPackage.Literals.GBINARY_OPERATOR_EXPRESSION__RIGHT_OPERAND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GexpressionsPackage.Literals.GBINARY_OPERATOR_EXPRESSION__RIGHT_OPERAND));
			if(transientValues.isValueTransient(semanticObject, GexpressionsPackage.Literals.GEQUALITY_EXPRESSION__OPERATOR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GexpressionsPackage.Literals.GEQUALITY_EXPRESSION__OPERATOR));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getGEqualityExpressionAccess().getGEqualityExpressionLeftOperandAction_1_0(), semanticObject.getLeftOperand());
		feeder.accept(grammarAccess.getGEqualityExpressionAccess().getOperatorGEqualityOperatorEnumRuleCall_1_1_0(), semanticObject.getOperator());
		feeder.accept(grammarAccess.getGEqualityExpressionAccess().getRightOperandGRelationExpressionParserRuleCall_1_2_0(), semanticObject.getRightOperand());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (condition=GExpression thenExpression=GExpression elseExpression=GExpression)
	 */
	protected void sequence_GIfExpression(EObject context, GIfExpression semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, GexpressionsPackage.Literals.GIF_EXPRESSION__CONDITION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GexpressionsPackage.Literals.GIF_EXPRESSION__CONDITION));
			if(transientValues.isValueTransient(semanticObject, GexpressionsPackage.Literals.GIF_EXPRESSION__THEN_EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GexpressionsPackage.Literals.GIF_EXPRESSION__THEN_EXPRESSION));
			if(transientValues.isValueTransient(semanticObject, GexpressionsPackage.Literals.GIF_EXPRESSION__ELSE_EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GexpressionsPackage.Literals.GIF_EXPRESSION__ELSE_EXPRESSION));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getGIfExpressionAccess().getConditionGExpressionParserRuleCall_2_0(), semanticObject.getCondition());
		feeder.accept(grammarAccess.getGIfExpressionAccess().getThenExpressionGExpressionParserRuleCall_4_0(), semanticObject.getThenExpression());
		feeder.accept(grammarAccess.getGIfExpressionAccess().getElseExpressionGExpressionParserRuleCall_6_0(), semanticObject.getElseExpression());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     importURI=STRING
	 */
	protected void sequence_GImportStatement(EObject context, GImportStatement semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, GexpressionsPackage.Literals.GIMPORT_STATEMENT__IMPORT_URI) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GexpressionsPackage.Literals.GIMPORT_STATEMENT__IMPORT_URI));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getGImportStatementAccess().getImportURISTRINGTerminalRuleCall_1_0(), semanticObject.getImportURI());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     value=INT
	 */
	protected void sequence_GIntegerExpression(EObject context, GIntegerExpression semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, GexpressionsPackage.Literals.GINTEGER_EXPRESSION__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GexpressionsPackage.Literals.GINTEGER_EXPRESSION__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getGIntegerExpressionAccess().getValueINTTerminalRuleCall_1_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (leftOperand=GMultiplicationExpression_GMultiplicationExpression_1_0 operator=GMultiplicationOperator rightOperand=GNegationExpression)
	 */
	protected void sequence_GMultiplicationExpression(EObject context, GMultiplicationExpression semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, GexpressionsPackage.Literals.GBINARY_OPERATOR_EXPRESSION__LEFT_OPERAND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GexpressionsPackage.Literals.GBINARY_OPERATOR_EXPRESSION__LEFT_OPERAND));
			if(transientValues.isValueTransient(semanticObject, GexpressionsPackage.Literals.GBINARY_OPERATOR_EXPRESSION__RIGHT_OPERAND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GexpressionsPackage.Literals.GBINARY_OPERATOR_EXPRESSION__RIGHT_OPERAND));
			if(transientValues.isValueTransient(semanticObject, GexpressionsPackage.Literals.GMULTIPLICATION_EXPRESSION__OPERATOR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GexpressionsPackage.Literals.GMULTIPLICATION_EXPRESSION__OPERATOR));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getGMultiplicationExpressionAccess().getGMultiplicationExpressionLeftOperandAction_1_0(), semanticObject.getLeftOperand());
		feeder.accept(grammarAccess.getGMultiplicationExpressionAccess().getOperatorGMultiplicationOperatorEnumRuleCall_1_1_0(), semanticObject.getOperator());
		feeder.accept(grammarAccess.getGMultiplicationExpressionAccess().getRightOperandGNegationExpressionParserRuleCall_1_2_0(), semanticObject.getRightOperand());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (body=GNavigationExpression_GNavigationExpression_1_0 referencedEObject=[EObject|ID])
	 */
	protected void sequence_GNavigationExpression(EObject context, GNavigationExpression semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, GexpressionsPackage.Literals.GNAVIGATION_EXPRESSION__BODY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GexpressionsPackage.Literals.GNAVIGATION_EXPRESSION__BODY));
			if(transientValues.isValueTransient(semanticObject, GexpressionsPackage.Literals.GNAVIGATION_EXPRESSION__REFERENCED_EOBJECT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GexpressionsPackage.Literals.GNAVIGATION_EXPRESSION__REFERENCED_EOBJECT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getGNavigationExpressionAccess().getGNavigationExpressionBodyAction_1_0(), semanticObject.getBody());
		feeder.accept(grammarAccess.getGNavigationExpressionAccess().getReferencedEObjectEObjectIDTerminalRuleCall_1_2_0_1(), semanticObject.getReferencedEObject());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (operator=GNegationOperator operand=GNavigationExpression)
	 */
	protected void sequence_GNegationExpression(EObject context, GNegationExpression semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, GexpressionsPackage.Literals.GUNARY_OPERATOR_EXPRESSION__OPERAND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GexpressionsPackage.Literals.GUNARY_OPERATOR_EXPRESSION__OPERAND));
			if(transientValues.isValueTransient(semanticObject, GexpressionsPackage.Literals.GNEGATION_EXPRESSION__OPERATOR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GexpressionsPackage.Literals.GNEGATION_EXPRESSION__OPERATOR));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getGNegationExpressionAccess().getOperatorGNegationOperatorEnumRuleCall_1_1_0(), semanticObject.getOperator());
		feeder.accept(grammarAccess.getGNegationExpressionAccess().getOperandGNavigationExpressionParserRuleCall_1_2_0(), semanticObject.getOperand());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (leftOperand=GOrExpression_GOrExpression_1_0 operator=GOrOperator rightOperand=GXorExpression)
	 */
	protected void sequence_GOrExpression(EObject context, GOrExpression semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, GexpressionsPackage.Literals.GBINARY_OPERATOR_EXPRESSION__LEFT_OPERAND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GexpressionsPackage.Literals.GBINARY_OPERATOR_EXPRESSION__LEFT_OPERAND));
			if(transientValues.isValueTransient(semanticObject, GexpressionsPackage.Literals.GBINARY_OPERATOR_EXPRESSION__RIGHT_OPERAND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GexpressionsPackage.Literals.GBINARY_OPERATOR_EXPRESSION__RIGHT_OPERAND));
			if(transientValues.isValueTransient(semanticObject, GexpressionsPackage.Literals.GOR_EXPRESSION__OPERATOR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GexpressionsPackage.Literals.GOR_EXPRESSION__OPERATOR));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getGOrExpressionAccess().getGOrExpressionLeftOperandAction_1_0(), semanticObject.getLeftOperand());
		feeder.accept(grammarAccess.getGOrExpressionAccess().getOperatorGOrOperatorEnumRuleCall_1_1_0(), semanticObject.getOperator());
		feeder.accept(grammarAccess.getGOrExpressionAccess().getRightOperandGXorExpressionParserRuleCall_1_2_0(), semanticObject.getRightOperand());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (imports+=GImportStatement* (expressions+=GExpression expressions+=GExpression*)?)
	 */
	protected void sequence_GProgram(EObject context, GProgram semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     referencedEObject=[EObject|ID]
	 */
	protected void sequence_GReferenceExpression(EObject context, GReferenceExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (leftOperand=GRelationExpression_GRelationExpression_1_0 operator=GRelationOperator rightOperand=GAdditionExpression)
	 */
	protected void sequence_GRelationExpression(EObject context, GRelationExpression semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, GexpressionsPackage.Literals.GBINARY_OPERATOR_EXPRESSION__LEFT_OPERAND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GexpressionsPackage.Literals.GBINARY_OPERATOR_EXPRESSION__LEFT_OPERAND));
			if(transientValues.isValueTransient(semanticObject, GexpressionsPackage.Literals.GBINARY_OPERATOR_EXPRESSION__RIGHT_OPERAND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GexpressionsPackage.Literals.GBINARY_OPERATOR_EXPRESSION__RIGHT_OPERAND));
			if(transientValues.isValueTransient(semanticObject, GexpressionsPackage.Literals.GRELATION_EXPRESSION__OPERATOR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GexpressionsPackage.Literals.GRELATION_EXPRESSION__OPERATOR));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getGRelationExpressionAccess().getGRelationExpressionLeftOperandAction_1_0(), semanticObject.getLeftOperand());
		feeder.accept(grammarAccess.getGRelationExpressionAccess().getOperatorGRelationOperatorEnumRuleCall_1_1_0(), semanticObject.getOperator());
		feeder.accept(grammarAccess.getGRelationExpressionAccess().getRightOperandGAdditionExpressionParserRuleCall_1_2_0(), semanticObject.getRightOperand());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     value=STRING
	 */
	protected void sequence_GStringExpression(EObject context, GStringExpression semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, GexpressionsPackage.Literals.GSTRING_EXPRESSION__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GexpressionsPackage.Literals.GSTRING_EXPRESSION__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getGStringExpressionAccess().getValueSTRINGTerminalRuleCall_1_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (leftOperand=GXorExpression_GXorExpression_1_0 operator=GXorOperator rightOperand=GAndExpression)
	 */
	protected void sequence_GXorExpression(EObject context, GXorExpression semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, GexpressionsPackage.Literals.GBINARY_OPERATOR_EXPRESSION__LEFT_OPERAND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GexpressionsPackage.Literals.GBINARY_OPERATOR_EXPRESSION__LEFT_OPERAND));
			if(transientValues.isValueTransient(semanticObject, GexpressionsPackage.Literals.GBINARY_OPERATOR_EXPRESSION__RIGHT_OPERAND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GexpressionsPackage.Literals.GBINARY_OPERATOR_EXPRESSION__RIGHT_OPERAND));
			if(transientValues.isValueTransient(semanticObject, GexpressionsPackage.Literals.GXOR_EXPRESSION__OPERATOR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GexpressionsPackage.Literals.GXOR_EXPRESSION__OPERATOR));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getGXorExpressionAccess().getGXorExpressionLeftOperandAction_1_0(), semanticObject.getLeftOperand());
		feeder.accept(grammarAccess.getGXorExpressionAccess().getOperatorGXorOperatorEnumRuleCall_1_1_0(), semanticObject.getOperator());
		feeder.accept(grammarAccess.getGXorExpressionAccess().getRightOperandGAndExpressionParserRuleCall_1_2_0(), semanticObject.getRightOperand());
		feeder.finish();
	}
}
