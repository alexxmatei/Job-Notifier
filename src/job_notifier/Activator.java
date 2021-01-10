package job_notifier;

import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.eclipse.core.runtime.jobs.IJobChangeListener;
import org.eclipse.core.runtime.jobs.Job;
import job_notifier.handlers.JobNotifier;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	private IJobChangeListener myJobListener;
	public static MessageConsole myConsole;

	// The plug-in ID
	public static final String PLUGIN_ID = "Job-Notifier"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;

	/**
	 * The constructor
	 */
	public Activator() {
	}

	private static MessageConsole findConsole(String name) {
		ConsolePlugin consolePlugin = ConsolePlugin.getDefault();
		IConsoleManager conMan = consolePlugin.getConsoleManager();
		IConsole[] existing = conMan.getConsoles();
		for (int i = 0; i < existing.length; i++)
			if (name.equals(existing[i].getName()))
				return (MessageConsole) existing[i];
		// no console found, so create a new one
		MessageConsole messageConsole = new MessageConsole(name, null);
		conMan.addConsoles(new IConsole[] { messageConsole });
		return messageConsole;
	}

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;

		this.myJobListener = new JobNotifier();
		Activator.myConsole = findConsole("Job-Notifier");
		Job.getJobManager().addJobChangeListener(this.myJobListener);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		if (this.myJobListener != null) {
			Job.getJobManager().removeJobChangeListener(this.myJobListener);
		}

		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

}
