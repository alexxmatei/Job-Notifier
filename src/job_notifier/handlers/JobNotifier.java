/**
 * 
 */
package job_notifier.handlers;

import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.IJobChangeListener;
import org.eclipse.swt.internal.win32.OS;
import org.apache.commons.lang.StringUtils;

/**
 * @author Al
 *
 */
public class JobNotifier implements IJobChangeListener {

	@Override
	public void aboutToRun(IJobChangeEvent event) {
		String jobName = event.getJob().getName();
		System.out.println("Started job: " + jobName);
		if ( StringUtils.containsIgnoreCase(jobName, "launching") && 
		     StringUtils.containsIgnoreCase(jobName, "test")         )
		{
			OS.MessageBeep(OS.MB_OK);
		}
	}

	@Override
	public void awake(IJobChangeEvent event) { 
		// TODO Auto-generated method stub
		
	}

	@Override
	public void done(IJobChangeEvent event) {
		String jobName = event.getJob().getName();
		System.out.println("Finished job: " + jobName);
		if ( StringUtils.containsIgnoreCase(jobName, "launching") && 
		     StringUtils.containsIgnoreCase(jobName, "test")         )
		{
			OS.MessageBeep(OS.MB_OK);
		}
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
