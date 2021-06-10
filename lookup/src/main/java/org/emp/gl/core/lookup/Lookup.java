package org.emp.gl.core.lookup;

import java.util.HashMap;
import java.util.Map;


public class Lookup {

    Map<Class, Object> services = new HashMap<>() ;

    public <T> void register (Class<? super T> service, T instance){
        services.put(service, instance) ;
    }

    public <T> void unregister (Class<? super T> service){
        services.remove(service);
    }

    public <T> T getService (Class<T> service){
        T instance = (T) services.get(service) ;
        return  instance ;
    }


    private Lookup() {
    }

    public static Lookup getInstance() {
        return LookupHolder.INSTANCE;
    }

    private static class LookupHolder {

        private static final Lookup INSTANCE = new Lookup();
    }
}