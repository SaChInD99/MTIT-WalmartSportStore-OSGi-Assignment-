package sports_manager_producer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;



public class Activator implements BundleActivator {

	ServiceRegistration serviceRegisterer;
	@Override
	public void start(BundleContext context) throws Exception {//start the Life cycle method
		System.out.println("Walmart Sports Accessories producer service started !!!!!!!!!!!!");
		ManagerActivaterService managerSer = new ManagerServiceImpl();
		serviceRegisterer = context.registerService(ManagerActivaterService.class.getName(), managerSer, null); //registering the managerActivaterService
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {//stop the Life cycle method
		System.out.println("Walmart Sports Accessories producer service closed !!!!!!!!!!!!!");
		serviceRegisterer.unregister();
	}

}