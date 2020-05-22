package cs598ga.shull.prolog.truffle.language;

import com.oracle.truffle.api.TruffleFile;
import java.io.IOException;
import java.nio.charset.Charset;

public final class PrologFileDetector implements TruffleFile.FileTypeDetector {

    @Override
    public String findMimeType(TruffleFile file) throws IOException {
        String name = file.getName();
        if (name != null && name.endsWith(".pl")) {
            return PrologLanguage.MIME_TYPE;
        }
        return null;
    }

    @Override
    public Charset findEncoding(TruffleFile file) throws IOException {
        return null;
    }
}
