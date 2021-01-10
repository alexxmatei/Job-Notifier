/**
 * 
 */
package job_notifier.handlers;

import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.IJobChangeListener;
import org.eclipse.ui.console.MessageConsoleStream;

/**
 * @author Al
 *
 */
public class JobNotifier implements IJobChangeListener {

	private MessageConsoleStream out;
	
	@Override
	public void aboutToRun(IJobChangeEvent event) {

		/* Debug start */
		/*
		 * Write to the main console of the development environment 
		 * (not the console of the launched application)
		 */
		String jobName = event.getJob().getName();
		System.out.println("Started job: " + jobName);
		/* Debug end */

		/*
		 * Write to the Job-Notifier console of the Eclipse instance 
		 * that has the Job-Notifier plugin installed
		 */
		this.out = job_notifier.Activator.myConsole.newMessageStream();
		this.out.println("Started job: " + jobName);
	}

	@Override
	public void awake(IJobChangeEvent event) { 
		// TODO Auto-generated method stub
		
	}

	@Override
	public void done(IJobChangeEvent event) {

		/* Debug start */
		/*
		 * Write to the main console of the development environment 
		 * (not the console of the launched application)
		 */
		String jobName = event.getJob().getName();
		System.out.println("Finished job: " + jobName);
		/* Debug end */

		/*
		 * Write to the Job-Notifier console of the Eclipse instance 
		 * that has the Job-Notifier plugin installed
		 */
		this.out = job_notifier.Activator.myConsole.newMessageStream();
		this.out.println("Finished job: " + jobName);
	}

	@Override
	public void running(IJobChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void scheduled(IJobChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sleeping(IJobChangeEvent event) {
		// TODO Auto-generated method stub
		
	}
}
