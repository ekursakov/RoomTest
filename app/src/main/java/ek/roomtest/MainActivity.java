package ek.roomtest;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import ek.roomtest.model.OrganizationWithDetails;
import ek.roomtest.model.OrganizationWithDetailsWrong;

public class MainActivity extends AppCompatActivity {

    private AppDatabase db;
    private TextView outputTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        outputTextView = findViewById(R.id.tv_output);

        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "room.db")
                .allowMainThreadQueries()
                .build();
        db.organizationDao().init();
    }

    public void onGet1(View view) {
        outputTextView.setText("");
        for (OrganizationWithDetailsWrong org : db.organizationDao().getOrganizationsWrong()) {
            outputTextView.append(org.toString() + "\n");
        }
    }

    public void onGet2(View view) {
        outputTextView.setText("");
        for (OrganizationWithDetails org : db.organizationDao().getOrganizations()) {
            outputTextView.append(org.toString() + "\n");
        }
    }
}
