/**
 */
package sigpmlextended.impl;

import cnrs.luchogie.up.SwingPlotter;

import cnrs.luchogie.up.data.Figure;

import com.google.common.collect.LinkedListMultimap;

import javax.swing.JFrame;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import sigpmlextended.Agent;
import sigpmlextended.SigpmlextendedPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Agent</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link sigpmlextended.impl.AgentImpl#getPlotter <em>Plotter</em>}</li>
 *   <li>{@link sigpmlextended.impl.AgentImpl#getFrame <em>Frame</em>}</li>
 *   <li>{@link sigpmlextended.impl.AgentImpl#getFigure <em>Figure</em>}</li>
 *   <li>{@link sigpmlextended.impl.AgentImpl#getCurrentExecCycle <em>Current Exec Cycle</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AgentImpl extends org.gemoc.sigpml.impl.AgentImpl implements Agent {
	/**
	 * The default value of the '{@link #getPlotter() <em>Plotter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlotter()
	 * @generated
	 * @ordered
	 */
	protected static final SwingPlotter PLOTTER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPlotter() <em>Plotter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlotter()
	 * @generated
	 * @ordered
	 */
	protected SwingPlotter plotter = PLOTTER_EDEFAULT;

	/**
	 * The default value of the '{@link #getFrame() <em>Frame</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrame()
	 * @generated
	 * @ordered
	 */
	protected static final JFrame FRAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFrame() <em>Frame</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrame()
	 * @generated
	 * @ordered
	 */
	protected JFrame frame = FRAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getFigure() <em>Figure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFigure()
	 * @generated
	 * @ordered
	 */
	protected static final Figure FIGURE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFigure() <em>Figure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFigure()
	 * @generated
	 * @ordered
	 */
	protected Figure figure = FIGURE_EDEFAULT;

	/**
	 * The default value of the '{@link #getCurrentExecCycle() <em>Current Exec Cycle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentExecCycle()
	 * @generated
	 * @ordered
	 */
	protected static final int CURRENT_EXEC_CYCLE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getCurrentExecCycle() <em>Current Exec Cycle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentExecCycle()
	 * @generated
	 * @ordered
	 */
	protected int currentExecCycle = CURRENT_EXEC_CYCLE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AgentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SigpmlextendedPackage.Literals.AGENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SwingPlotter getPlotter() {
		return plotter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlotter(SwingPlotter newPlotter) {
		SwingPlotter oldPlotter = plotter;
		plotter = newPlotter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SigpmlextendedPackage.AGENT__PLOTTER, oldPlotter, plotter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFrame(JFrame newFrame) {
		JFrame oldFrame = frame;
		frame = newFrame;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SigpmlextendedPackage.AGENT__FRAME, oldFrame, frame));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Figure getFigure() {
		return figure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFigure(Figure newFigure) {
		Figure oldFigure = figure;
		figure = newFigure;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SigpmlextendedPackage.AGENT__FIGURE, oldFigure, figure));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getCurrentExecCycle() {
		return currentExecCycle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurrentExecCycle(int newCurrentExecCycle) {
		int oldCurrentExecCycle = currentExecCycle;
		currentExecCycle = newCurrentExecCycle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SigpmlextendedPackage.AGENT__CURRENT_EXEC_CYCLE, oldCurrentExecCycle, currentExecCycle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void isExecuting() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void execute() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LinkedListMultimap sharedMemory() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SigpmlextendedPackage.AGENT__PLOTTER:
				return getPlotter();
			case SigpmlextendedPackage.AGENT__FRAME:
				return getFrame();
			case SigpmlextendedPackage.AGENT__FIGURE:
				return getFigure();
			case SigpmlextendedPackage.AGENT__CURRENT_EXEC_CYCLE:
				return getCurrentExecCycle();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SigpmlextendedPackage.AGENT__PLOTTER:
				setPlotter((SwingPlotter)newValue);
				return;
			case SigpmlextendedPackage.AGENT__FRAME:
				setFrame((JFrame)newValue);
				return;
			case SigpmlextendedPackage.AGENT__FIGURE:
				setFigure((Figure)newValue);
				return;
			case SigpmlextendedPackage.AGENT__CURRENT_EXEC_CYCLE:
				setCurrentExecCycle((Integer)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SigpmlextendedPackage.AGENT__PLOTTER:
				setPlotter(PLOTTER_EDEFAULT);
				return;
			case SigpmlextendedPackage.AGENT__FRAME:
				setFrame(FRAME_EDEFAULT);
				return;
			case SigpmlextendedPackage.AGENT__FIGURE:
				setFigure(FIGURE_EDEFAULT);
				return;
			case SigpmlextendedPackage.AGENT__CURRENT_EXEC_CYCLE:
				setCurrentExecCycle(CURRENT_EXEC_CYCLE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SigpmlextendedPackage.AGENT__PLOTTER:
				return PLOTTER_EDEFAULT == null ? plotter != null : !PLOTTER_EDEFAULT.equals(plotter);
			case SigpmlextendedPackage.AGENT__FRAME:
				return FRAME_EDEFAULT == null ? frame != null : !FRAME_EDEFAULT.equals(frame);
			case SigpmlextendedPackage.AGENT__FIGURE:
				return FIGURE_EDEFAULT == null ? figure != null : !FIGURE_EDEFAULT.equals(figure);
			case SigpmlextendedPackage.AGENT__CURRENT_EXEC_CYCLE:
				return currentExecCycle != CURRENT_EXEC_CYCLE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (plotter: ");
		result.append(plotter);
		result.append(", frame: ");
		result.append(frame);
		result.append(", figure: ");
		result.append(figure);
		result.append(", currentExecCycle: ");
		result.append(currentExecCycle);
		result.append(')');
		return result.toString();
	}

} //AgentImpl
