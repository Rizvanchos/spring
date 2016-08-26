package magic;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

public class TigerReplacer implements MethodReplacer {
    @Override
    public Object reimplement(final Object obj, final Method method, final Object[] args) throws Throwable {
        return "Tiger from the box!";
    }
}
