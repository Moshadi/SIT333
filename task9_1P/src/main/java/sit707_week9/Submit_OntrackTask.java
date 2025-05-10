package sit707_week9;

public class Submit_OntrackTask {

	public static String submitTask(String description, String file) {
	    if (isDescriptionValid(description)) {
	        return "Description is required";
	    }
	    if (isFileValid(file)) {
	        return "File is required";
	    }
	    return "Task submitted successfully!";
	}

	private static boolean isDescriptionValid(String description) {
	    return description == null || description.isEmpty();
	}

	private static boolean isFileValid(String file) {
	    return file == null || file.isEmpty();
	}

}
