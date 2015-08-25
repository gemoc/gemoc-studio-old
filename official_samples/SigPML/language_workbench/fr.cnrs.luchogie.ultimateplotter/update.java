import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class update
{
    public static void main(String[] args) throws IOException
    {
	System.out.println(args[0]);
	retrieveURLContent(new URL(getURL()));
    }
    
    private static String getURL() throws IOException
    {
	StringBuilder s = new StringBuilder();
	InputStream is = update.class.getResourceAsStream("url.txt");
	
	while (true)
	{
	    int i = is.read();
	    
	    if (i == -1)
	    {
		break;
	    }
	    else
	    {
		s.append((char) i);
	    }
	}
	
	return s.toString();
    }

    public static byte[] retrieveURLContent(URL url) throws IOException
    {
	InputStream is = url.openConnection().getInputStream();
	byte[] bytes = toools.io.Utilities.readUntilEOF(is);
	is.close();
	return bytes;
    }
    
    public static byte[] readUntilEOF(InputStream is) throws IOException
    {
	if (is == null)
	    throw new NullPointerException("null stream");

	ByteArrayOutputStream bos = new ByteArrayOutputStream();
	copy(is, bos);
	return bos.toByteArray();
    }
    
    public static void copy(InputStream is, OutputStream bos) throws IOException
    {
	if (is == null)
	    throw new NullPointerException();

	if (bos == null)
	    throw new NullPointerException();

	byte[] bytes = new byte[4 * 1024];

	while (true)
	{
	    int i = is.read(bytes);

	    if (i == -1)
	    {
		break;
	    }
	    else
	    {
		bos.write(bytes, 0, i);
	    }
	}
    }
}
