package example.exlist.sportseed.expandablelistexample;

/**
 * Created by Umair on 10/02/2015.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListDataPump {
    public static HashMap getData() {
        HashMap expandableListDetail = new HashMap();


        List technology = new ArrayList();
        ListItemModel item = new ListItemModel();
        item.title = "Beats sued for noise-cancelling tech";
        item.isHeader = true;
        technology.add(item);

        item = new ListItemModel();
        item.title = "Wikipedia blocks US Congress edits";
        item.isHeader = false;
        technology.add(item);

        item = new ListItemModel();
        item.title = "Google quizzed over deleted links";
        item.isHeader = false;
        technology.add(item);

        item = new ListItemModel();
        item.title = "Nasa seeks aid with Earth-Mars links";
        item.isHeader = false;
        technology.add(item);

        item = new ListItemModel();
        item.title = "The Good, the Bad and the Ugly";
        item.isHeader = false;
        technology.add(item);

        item = new ListItemModel();
        item.title = "Beats sued for noise-cancelling tech";
        item.isHeader = true;
        technology.add(item);

        item = new ListItemModel();
        item.title = "Wikipedia blocks US Congress edits";
        item.isHeader = false;
        technology.add(item);

        item = new ListItemModel();
        item.title = "Google quizzed over deleted links";
        item.isHeader = false;
        technology.add(item);


        List entertainment = new ArrayList();
        item = new ListItemModel();
        item.title = "Beats sued for noise-cancelling tech";
        item.isHeader = true;
        entertainment.add(item);

        item = new ListItemModel();
        item.title = "Wikipedia blocks US Congress edits";
        item.isHeader = false;
        entertainment.add(item);

        item = new ListItemModel();
        item.title = "Google quizzed over deleted links";
        item.isHeader = false;
        entertainment.add(item);

        item = new ListItemModel();
        item.title = "Nasa seeks aid with Earth-Mars links";
        item.isHeader = false;
        entertainment.add(item);

        item = new ListItemModel();

        item.title = "The Good, the Bad and the Ugly";
        item.isHeader = false;
        entertainment.add(item);

        item = new ListItemModel();
        item.title = "Google quizzed over deleted links";
        item.isHeader = true;
        entertainment.add(item);

        item = new ListItemModel();
        item.title = "Nasa seeks aid with Earth-Mars links";
        item.isHeader = false;
        entertainment.add(item);

        item = new ListItemModel();

        item.title = "The Good, the Bad and the Ugly";
        item.isHeader = false;
        entertainment.add(item);



        expandableListDetail.put("TECHNOLOGY NEWS", technology);
        expandableListDetail.put("ENTERTAINMENT NEWS", entertainment);

        return expandableListDetail;
    }
}
