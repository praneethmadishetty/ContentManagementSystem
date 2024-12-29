import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ContentManagementSystem {
    private Map<Integer, ContentItem> contentItems;
    private int nextId;

    public ContentManagementSystem() {
        contentItems = new HashMap<>();
        nextId = 1;
    }

    // Create a new content item
    public void createContent(String title, String content) {
        ContentItem newItem = new ContentItem(nextId, title, content);
        contentItems.put(nextId, newItem);
        nextId++;
        System.out.println("Content created successfully!");
    }

    // Retrieve a content item by ID
    public ContentItem getContentById(int id) {
        return contentItems.get(id);
    }

    // Update a content item
    public void updateContent(int id, String newTitle, String newContent) {
        if (contentItems.containsKey(id)) {
            ContentItem item = contentItems.get(id);
            item.title = newTitle;
            item.content = newContent;
            System.out.println("Content updated successfully!");
        } else {
            System.out.println("Content with ID " + id + " does not exist.");
        }
    }

    // Delete a content item
    public void deleteContent(int id) {
        if (contentItems.containsKey(id)) {
            contentItems.remove(id);
            System.out.println("Content deleted successfully!");
        } else {
            System.out.println("Content with ID " + id + " does not exist.");
        }
    }

    // Add a comment to a content item
    public void addComment(int id, String comment) {
        if (contentItems.containsKey(id)) {
            ContentItem item = contentItems.get(id);
            item.addComment(comment);
            System.out.println("Comment added successfully!");
        } else {
            System.out.println("Content with ID " + id + " does not exist.");
        }
    }

    public static void main(String[] args) {
        ContentManagementSystem cms = new ContentManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nContent Management System");
            System.out.println("1. Create Content");
            System.out.println("2. Read Content");
            System.out.println("3. Update Content");
            System.out.println("4. Delete Content");
            System.out.println("5. Add Comment");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter content: ");
                    String content = scanner.nextLine();
                    cms.createContent(title, content);
                    break;
                case 2:
                    System.out.print("Enter content ID: ");
                    int id = scanner.nextInt();
                    ContentItem item = cms.getContentById(id);
                    if (item != null) {
                        System.out.println("Content Details:\n" + item);
                    } else {
                        System.out.println("Content with ID " + id + " not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter content ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter new title: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Enter new content: ");
                    String newContent = scanner.nextLine();
                    cms.updateContent(updateId, newTitle, newContent);
                    break;
                case 4:
                    System.out.print("Enter content ID to delete: ");
                    int deleteId = scanner.nextInt();
                    cms.deleteContent(deleteId);
                    break;
                case 5:
                    System.out.print("Enter content ID to add comment: ");
                    int commentId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter comment: ");
                    String commentText = scanner.nextLine();
                    cms.addComment(commentId, commentText);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }
    }
}

// Model for Content Item
class ContentItem {
    protected int id;
    protected String title;
    protected String content;
    protected List<String> comments;

    public ContentItem(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.comments = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public List<String> getComments() {
        return comments;
    }

    public void addComment(String comment) {
        comments.add(comment);
    }

    @Override
    public String toString() {
        return "ID: " + id + "\nTitle: " + title + "\nContent: " + content;
    }
}

// Content Management System
