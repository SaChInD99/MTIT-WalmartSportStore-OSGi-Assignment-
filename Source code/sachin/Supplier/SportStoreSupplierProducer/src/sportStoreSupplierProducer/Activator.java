package sportStoreSupplierProducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import sportStoreSupplierProducer.SportSupplierService;
import sportStoreSupplierProducer.SportSupplierServiceImpl;

public class Activator implements BundleActivator {
	ServiceRegistration serviceRegisterer;
	@Override
	public void start(BundleContext context) throws Exception {//Life cycle method-start
		System.out.println("======================Welcome to Walmart Sport Store. Producer Service Started.======================");
		SportSupplierService managerSer = new SportSupplierServiceImpl();
		serviceRegisterer = context.registerService(SportSupplierService.class.getName(), managerSer, null); //registering the managerService
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {//Life cycle method-stop
		System.out.println("========================Thank you! Come Again. Producer Service Closed.=======================");
		serviceRegisterer.unregister();
	}

}
