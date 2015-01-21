import java.io.*;

public class CSVIO {
	private static InputStream is;
	private static OutputStream os;
	private static FileInputStream fis;
	private static FileOutputStream fos;
	private static String basePath = "." + File.separator + "Baza"
			+ File.separator;
	private static String currentOpen = null;

	public static <T extends CSVInterface> void saveObject(String fileName,
			T objectToSave) throws IOException {
		if (fileName.equals(currentOpen)) {

			os.write(objectToSave.objectToCsv().getBytes());
			os.write("\n".getBytes());

		} else {
			fos = new FileOutputStream(basePath + fileName + ".csv", true);
			os = new DataOutputStream(fos);
			currentOpen = fileName;
			os.write(objectToSave.objectToCsv().getBytes());
			os.write("\n".getBytes());
		}
		System.out.println(objectToSave.objectToCsv());
		fis= new FileInputStream(basePath + fileName + ".csv");
	}

	public static <T extends CSVInterface> T findObject(String[] str) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length - 1; i++) {
			sb.append(str[i]).append(",");
		}
		sb.append(str[str.length - 1]);
		
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		String line = "";
		try {
			String search= sb.toString();
			while ((line = br.readLine()) != null) {
				if (line.equals(search)) {
					@SuppressWarnings("unchecked")
					T newT= (T) new Object();
					newT.CsvToObject(line);
					return (T) newT;
				}
			}
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}
}
