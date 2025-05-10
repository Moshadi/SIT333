package sit707_week9;


import static org.junit.Assert.*;
import org.junit.Test;

public class Submit_OntrackTaskTest {

    // Test valid input
    @Test
    public void testSubmitTaskValidInput() {
        // Arrange
        String description = "Math Assignment";
        String file = "assignment.pdf";
        
        // Act
        String result = Submit_OntrackTask.submitTask(description, file);
        
        // Assert
        assertEquals("Task submitted successfully!", result);
    }

    // Test missing description
    @Test
    public void testSubmitTaskMissingDescription() {
        // Arrange
        String description = "";
        String file = "assignment.pdf";
        
        // Act
        String result = Submit_OntrackTask.submitTask(description, file);
        
        // Assert
        assertEquals("Description is required", result);
    }

    // Test missing file
    @Test
    public void testSubmitTaskMissingFile() {
        // Arrange
        String description = "Math Assignment";
        String file = "";
        
        // Act
        String result = Submit_OntrackTask.submitTask(description, file);
        
        // Assert
        assertEquals("File is required", result);
    }
}
