/**
 */
package sigpmlextended;

import cnrs.luchogie.up.SwingPlotter;

import cnrs.luchogie.up.data.Figure;

import javax.swing.JFrame;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Agent</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link sigpmlextended.Agent#getPlotter <em>Plotter</em>}</li>
 *   <li>{@link sigpmlextended.Agent#getFrame <em>Frame</em>}</li>
 *   <li>{@link sigpmlextended.Agent#getFigure <em>Figure</em>}</li>
 *   <li>{@link sigpmlextended.Agent#getCurrentExecCycle <em>Current Exec Cycle</em>}</li>
 * </ul>
 * </p>
 *
 * @see sigpmlextended.SigpmlextendedPackage#getAgent()
 * @model
 * @generated
 */
public interface Agent extends org.gemoc.sigpml.Agent {
	/**
	 * Returns the value of the '<em><b>Current Exec Cycle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Current Exec Cycle</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Current Exec Cycle</em>' attribute.
	 * @see #setCurrentExecCycle(int)
	 * @see sigpmlextended.SigpmlextendedPackage#getAgent_CurrentExecCycle()
	 * @model
	 * @generated
	 */
	int getCurrentExecCycle();

	/**
	 * Sets the value of the '{@link sigpmlextended.Agent#getCurrentExecCycle <em>Current Exec Cycle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current Exec Cycle</em>' attribute.
	 * @see #getCurrentExecCycle()
	 * @generated
	 */
	void setCurrentExecCycle(int value);

	/**
	 * Returns the value of the '<em><b>Figure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Figure</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Figure</em>' attribute.
	 * @see #setFigure(Figure)
	 * @see sigpmlextended.SigpmlextendedPackage#getAgent_Figure()
	 * @model dataType="sigpmlextended.Figure"
	 * @generated
	 */
	Figure getFigure();

	/**
	 * Sets the value of the '{@link sigpmlextended.Agent#getFigure <em>Figure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Figure</em>' attribute.
	 * @see #getFigure()
	 * @generated
	 */
	void setFigure(Figure value);

	/**
	 * Returns the value of the '<em><b>Frame</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Frame</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Frame</em>' attribute.
	 * @see #setFrame(JFrame)
	 * @see sigpmlextended.SigpmlextendedPackage#getAgent_Frame()
	 * @model dataType="sigpmlextended.JFrame"
	 * @generated
	 */
	JFrame getFrame();

	/**
	 * Sets the value of the '{@link sigpmlextended.Agent#getFrame <em>Frame</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Frame</em>' attribute.
	 * @see #getFrame()
	 * @generated
	 */
	void setFrame(JFrame value);

	/**
	 * Returns the value of the '<em><b>Plotter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Plotter</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Plotter</em>' attribute.
	 * @see #setPlotter(SwingPlotter)
	 * @see sigpmlextended.SigpmlextendedPackage#getAgent_Plotter()
	 * @model dataType="sigpmlextended.SwingPlotter"
	 * @generated
	 */
	SwingPlotter getPlotter();

	/**
	 * Sets the value of the '{@link sigpmlextended.Agent#getPlotter <em>Plotter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Plotter</em>' attribute.
	 * @see #getPlotter()
	 * @generated
	 */
	void setPlotter(SwingPlotter value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void execute();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	void isExecuting();

} // Agent
