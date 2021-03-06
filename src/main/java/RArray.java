
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class RArray extends RObject {
    public final ArrayList<RObject> impl;
    
    public RArray() {
        impl = new ArrayList<RObject>();
    }
    
    public RArray(RObject... args) {
        impl = new ArrayList<RObject>(Arrays.asList(args));
    }
    
    public RArray(List<RObject> impl) {
        this.impl = new ArrayList<RObject>(impl);
    }
    
    public RObject $less$less(RObject what) {
        impl.add(what);
        
        return this;
    }
    
    public RObject $lbrack$rbrack(RObject where) {
        int index = (int)((RFixnum)where.to_i()).fix;
        
        if (index < 0) {
            index = impl.size() + index;
        }

        if (index < impl.size()) {
            return impl.get(index);
        } else {
            return RNil;
        }
    }
    
    public RObject $lbrack$rbrack$equal(RObject where, RObject what) {
        int index = (int)((RFixnum)where.to_i()).fix;
        
        if (index < 0) {
            index = impl.size() + index;
        }

        if (index >= impl.size()) {
            impl.ensureCapacity(index + 1);
        }

        impl.set(index, what);
        
        return this;
    }

    public RObject size() {
        return new RFixnum(impl.size());
    }

    public RObject clear() {
        impl.clear();
        return this;
    }
}
