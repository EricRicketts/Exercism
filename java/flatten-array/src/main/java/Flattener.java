import java.util.ArrayList;
import java.util.List;

public class Flattener {

    private List<Object> flattenedList = new ArrayList<>();

    public List<Object> flatten(List<Object> listsOfLists) {
        for (int index = 0; index < listsOfLists.size(); index++) {
            var currentListOrObject = listsOfLists.get(index);
            if (currentListOrObject instanceof List) {
                this.flatten((List<Object>) currentListOrObject);
            } else if (currentListOrObject == null) {
                continue;
            } else {
                this.flattenedList.add(currentListOrObject);
            }
        }
        return this.flattenedList;
    }
}