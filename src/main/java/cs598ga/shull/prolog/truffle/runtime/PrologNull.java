package cs598ga.shull.prolog.truffle.runtime;

import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.TruffleObject;
import com.oracle.truffle.api.library.ExportLibrary;
import com.oracle.truffle.api.library.ExportMessage;

@ExportLibrary(InteropLibrary.class)
@SuppressWarnings("static-method")
public final class PrologNull implements TruffleObject {

    /**
     * The canonical value to represent {@code null} in Prolog.
     */
    public static final PrologNull SINGLETON = new PrologNull();

    /**
     * Disallow instantiation from outside to ensure that the {@link #SINGLETON} is the only
     * instance.
     */
    private PrologNull() {
    }

    /**
     * This method is, e.g., called when using the {@code null} value in a string concatenation. So
     * changing it has an effect on SL programs.
     */
    @Override
    public String toString() {
        return "NULL";
    }

    /**
     * {@link PrologNull} values are interpreted as null values by other languages.
     */
    @ExportMessage
    boolean isNull() {
        return true;
    }
}
