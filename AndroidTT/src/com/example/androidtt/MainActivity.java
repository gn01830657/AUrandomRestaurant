package com.example.androidtt;

import java.util.ArrayList;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.os.Build;

public class MainActivity extends Activity {
	TextView tv;

	CheckBox cb_chinese, cb_western, cb_other, cb_rice, cb_noodles, cb_pot,
			cb_fast, cb_lo, cb_convenience;

	Button btn;

	String tag = "WHERE tag='";

	int count = 0;

	private SQLiteDatabase db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		/*
		 * if (savedInstanceState == null) {
		 * getFragmentManager().beginTransaction() .add(R.id.container, new
		 * PlaceholderFragment()).commit(); }
		 */

		db = openOrCreateDatabase("AUfood.db", MODE_PRIVATE, null);
		db.execSQL("DROP TABLE AUfood;");
		String create_table = "CREATE TABLE IF NOT EXISTS AUfood"
				+ "(id INTEGER PRIMARY KEY," + "name TEXT NOT NULL,"
				+ "tag TEXT NOT NULL);";
		db.execSQL(create_table);
		db.execSQL("INSERT INTO AUfood (id,name,tag) VALUES(1,'�ũM��','����')");
		db.execSQL("INSERT INTO AUfood (id,name,tag) VALUES(2,'���M��','����')");
		db.execSQL("INSERT INTO AUfood (id,name,tag) VALUES(3,'�⥿','����')");
		db.execSQL("INSERT INTO AUfood (id,name,tag) VALUES(4,'�����','�t��')");
		db.execSQL("INSERT INTO AUfood (id,name,tag) VALUES(5,'7-11','�K�Q�ө�')");
		db.execSQL("INSERT INTO AUfood (id,name,tag) VALUES(6,'���a','�K�Q�ө�')");
		db.execSQL("INSERT INTO AUfood (id,name,tag) VALUES(7,'OK','�K�Q�ө�')");
		db.execSQL("INSERT INTO AUfood (id,name,tag) VALUES(8,'�ܺ��I','�K�Q�ө�')");
		db.execSQL("INSERT INTO AUfood (id,name,tag) VALUES(9,'�|���C�s','��')");
		db.execSQL("INSERT INTO AUfood (id,name,tag) VALUES(10,'�촵','�覡')");
		db.execSQL("INSERT INTO AUfood (id,name,tag) VALUES(11,'�K�足��','��')");
		db.execSQL("INSERT INTO AUfood (id,name,tag) VALUES(12,'�K��','��')");
		db.execSQL("INSERT INTO AUfood (id,name,tag) VALUES(13,'�g�����f','��')");
		db.execSQL("INSERT INTO AUfood (id,name,tag) VALUES(14,'�Ѫ��D','��')");
		db.execSQL("INSERT INTO AUfood (id,name,tag) VALUES(15,'���@��','��')");
		db.execSQL("INSERT INTO AUfood (id,name,tag) VALUES(16,'���n����','����')");
		db.execSQL("INSERT INTO AUfood (id,name,tag) VALUES(17,'�N�Q����','����')");
		db.execSQL("INSERT INTO AUfood (id,name,tag) VALUES(18,'��������','����')");
		db.execSQL("INSERT INTO AUfood (id,name,tag) VALUES(19,'�E�O','��')");
		db.execSQL("INSERT INTO AUfood (id,name,tag) VALUES(20,'�j�H�K�O�N','��L')");
		db.execSQL("INSERT INTO AUfood (id,name,tag) VALUES(21,'�Y�V','��L')");
		db.execSQL("INSERT INTO AUfood (id,name,tag) VALUES(22,'�ּw��','�t��')");
		db.execSQL("INSERT INTO AUfood (id,name,tag) VALUES(23,'�a�M','����')");
		db.execSQL("INSERT INTO AUfood (id,name,tag) VALUES(24,'����','��')");
		db.execSQL("INSERT INTO AUfood (id,name,tag) VALUES(25,'THE FIRE','��L')");


		tv = (TextView) findViewById(R.id.textView1);
		cb_chinese = (CheckBox) findViewById(R.id.chinese);
		cb_western = (CheckBox) findViewById(R.id.western);
		cb_other = (CheckBox) findViewById(R.id.other);
		cb_rice = (CheckBox) findViewById(R.id.rice);
		cb_noodles = (CheckBox) findViewById(R.id.noodles);
		cb_pot = (CheckBox) findViewById(R.id.pot);
		cb_fast = (CheckBox) findViewById(R.id.fast);
		cb_lo = (CheckBox) findViewById(R.id.lo);
		cb_convenience = (CheckBox) findViewById(R.id.convenience);

		btn = (Button) findViewById(R.id.button1);

		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (cb_chinese.isChecked()) {
					if (count == 0) {
						tag += cb_chinese.getText().toString() + "'";
						count++;
					} else {
						tag += " OR tag='" + cb_chinese.getText().toString()
								+ "'";
						count++;
					}
				}
				if (cb_western.isChecked()) {
					if (count == 0) {
						tag += cb_western.getText().toString() + "'";
						count++;
					} else {
						tag += " OR tag='" + cb_western.getText().toString()
								+ "'";
						count++;
					}
				}

				if (cb_other.isChecked()) {
					if (count == 0) {
						tag += cb_other.getText().toString() + "'";
						count++;
					} else {
						tag += " OR tag='" + cb_other.getText().toString()
								+ "'";
						count++;
					}
				}

				if (cb_rice.isChecked()) {
					if (count == 0) {
						tag += cb_rice.getText().toString() + "'";
						count++;
					} else {
						tag += " OR tag='" + cb_rice.getText().toString() + "'";
						count++;
					}
				}

				if (cb_noodles.isChecked()) {
					if (count == 0) {
						tag += cb_noodles.getText().toString() + "'";
						count++;
					} else {
						tag += " OR tag='" + cb_noodles.getText().toString()
								+ "'";
						count++;
					}
				}

				if (cb_pot.isChecked()) {
					if (count == 0) {
						tag += cb_pot.getText().toString() + "'";
						count++;
					} else {
						tag += " OR tag='" + cb_pot.getText().toString() + "'";
						count++;
					}
				}

				if (cb_fast.isChecked()) {
					if (count == 0) {
						tag += cb_fast.getText().toString() + "'";
						count++;
					} else {
						tag += " OR tag='" + cb_fast.getText().toString() + "'";
						count++;
					}
				}

				if (cb_lo.isChecked()) {
					if (count == 0) {
						tag += cb_lo.getText().toString() + "'";
						count++;
					} else {
						tag += " OR tag='" + cb_lo.getText().toString() + "'";
						count++;
					}
				}

				if (cb_convenience.isChecked()) {
					if (count == 0) {
						tag += cb_convenience.getText().toString() + "'";
						count++;
					} else {
						tag += " OR tag='"
								+ cb_convenience.getText().toString() + "'";
						count++;
					}
				}
				Cursor cc = db.rawQuery("SELECT id FROM AUfood " + tag, null);

				cc.moveToFirst();

				int i = 0;
				int id[] = new int[cc.getCount()];
				do {
					Log.d("XXX", "" + cc.getInt(0));
					id[i] = cc.getInt(0);
					i++;
					Log.d("XXX", "" + i);
					cc.moveToNext();
				} while (!cc.isAfterLast());

				int ran = (int) (Math.random() * i);

				Cursor cc2 = db.rawQuery("SELECT name FROM AUfood WHERE id="
						+ id[ran], null);
				cc2.moveToFirst();

				tv.setText(cc2.getString(0));

				Log.i("XXX", tag);
				count = 0;
				tag = "WHERE tag='";
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	/*
	 * public static class PlaceholderFragment extends Fragment {
	 * 
	 * public PlaceholderFragment() { }
	 * 
	 * @Override public View onCreateView(LayoutInflater inflater, ViewGroup
	 * container, Bundle savedInstanceState) { View rootView =
	 * inflater.inflate(R.layout.fragment_main, container, false); return
	 * rootView; } }
	 */
}
