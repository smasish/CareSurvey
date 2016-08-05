package caresurvey.sci.com.caresurvey.activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import caresurvey.sci.com.caresurvey.R;
import caresurvey.sci.com.caresurvey.database.ANCTable;
import caresurvey.sci.com.caresurvey.database.DatabaseAccessUnion;
import caresurvey.sci.com.caresurvey.database.DatabaseAccessUpazila;
import caresurvey.sci.com.caresurvey.database.DatabaseAccessVillage;
import caresurvey.sci.com.caresurvey.database.FpObservationTable;
import caresurvey.sci.com.caresurvey.database.InventoryTable;
import caresurvey.sci.com.caresurvey.database.SatelliteClinicTable;
import caresurvey.sci.com.caresurvey.database.SickChildTable;
import caresurvey.sci.com.caresurvey.model.AddressItem;
import caresurvey.sci.com.caresurvey.utils.AppUtils;
import utils.GPSTracker;

/**
 * Created by shantanu on 6/23/16.
 */

public class AddressInsertActivity2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener, LocationListener {
    private Spinner districtSpinner;
    private TextView districtText;
    AddressAdapter districtAdapter;
    private Spinner facilitySpinner;
    private AddressAdapter facilityAdapter;
    private Spinner observationSpinner;
    private AddressAdapter observationAdapter;
    private Spinner upazilaSpinner;
    private AddressAdapter upazilaAdapter;
    private Spinner unionSpinner;
    private AddressAdapter unionAdapter;
    private Spinner wardSpinner;
    private AddressAdapter wardAdapter;
    private Spinner villageSpinner;
    private AddressAdapter villageAdapter;
    private TextView facilityID;
    private String district;
    private String facility;
    private String upazila;
    private String union;
    private String ward;
    private String village;
    private int observationPosition;
    private String observationName;
    private GPSTracker gpsTracker;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_insert);
        gpsTracker = new GPSTracker(this,this);
        facilityID = (TextView) findViewById(R.id.facility_id_number);
        districtSpinner = (Spinner) findViewById(R.id.districtspinner);
        districtText = (TextView) findViewById(R.id.districtText);
        districtAdapter = new AddressAdapter(this, R.layout.drop_down_list_addrees);
        districtAdapter.add(new AddressItem(-1, "Select", "Select"));
        districtAdapter.add(new AddressItem(36, "Habiganj", "হবিগঞ্জ"));
        districtAdapter.add(new AddressItem(51, "Lakshmipur", "লক্ষিপুর"));
        districtAdapter.add(new AddressItem(75, "Noakhali", "নোয়াখালী"));
        districtAdapter.add(new AddressItem(42, "Jhalakati", "ঝালকাঠী"));
        districtSpinner.setAdapter(districtAdapter);
        districtSpinner.setOnItemSelectedListener(this);

        facilitySpinner = (Spinner) findViewById(R.id.facility);
        facilitySpinner.setOnItemSelectedListener(this);
        facilityAdapter = new AddressAdapter(this, R.layout.drop_down_list_addrees);
        facilityAdapter.add(new AddressItem(-1, "Select", "Select"));
        facilityAdapter.add(new AddressItem(0, "District Hospital", "District Hospital"));
        facilityAdapter.add(new AddressItem(1, "Upazila Health Complex", "Upazila Health Complex"));
        facilityAdapter.add(new AddressItem(2, "Union Health & Family Welfare Center", "Union Health & Family Welfare Center"));
        facilityAdapter.add(new AddressItem(3, "Satellite Clinic", "Satellite Clinic"));
        facilitySpinner.setAdapter(facilityAdapter);

        observationSpinner = (Spinner) findViewById(R.id.obsSpinner);
        observationAdapter = new AddressAdapter(this, R.layout.drop_down_list_addrees);
        observationAdapter.add(new AddressItem(-1, "Select", "Select"));
        observationAdapter.add(new AddressItem(3, "Inventory of Facility", "Inventory of Facility"));
        observationAdapter.add(new AddressItem(1, "Inventory of satellite clinic", "Inventory of satellite clinic"));
        observationAdapter.add(new AddressItem(0, "Observation of ANC", "Observation of ANC"));
        observationAdapter.add(new AddressItem(2, "Observation of Sick Child ", "Observation of Sick Child "));
        observationAdapter.add(new AddressItem(4, "Observation of Family planning", "Observation of Family planning"));
        observationSpinner.setAdapter(observationAdapter);
        observationSpinner.setOnItemSelectedListener(this);

        upazilaSpinner = (Spinner) findViewById(R.id.upzillaspinner);
        upazilaAdapter = new AddressAdapter(this, R.layout.drop_down_list_addrees);
        upazilaSpinner.setOnItemSelectedListener(this);
        upazilaSpinner.setAdapter(upazilaAdapter);

        unionSpinner = (Spinner) findViewById(R.id.unionspinner);
        unionAdapter = new AddressAdapter(this, R.layout.drop_down_list_addrees);
        unionSpinner.setOnItemSelectedListener(this);
        unionSpinner.setAdapter(unionAdapter);

        wardSpinner = (Spinner) findViewById(R.id.wardspinner);
        wardAdapter = new AddressAdapter(this, R.layout.drop_down_list_addrees);
        wardSpinner.setAdapter(wardAdapter);

        villageSpinner = (Spinner) findViewById(R.id.villagespinner);
        villageAdapter = new AddressAdapter(this, R.layout.drop_down_list_addrees);
        villageSpinner.setAdapter(villageAdapter);


        findViewById(R.id.next).setOnClickListener(this);
        loadData();
        //get location
    }

    private void loadData() {
        String district = getIntent().getStringExtra(SelectionActivity.EXTRA_DISTRICT);
        if(!TextUtils.isEmpty(district)){
            districtSpinner.setSelection(0);
            for(int i=0;i<districtAdapter.getCount();i++){
                if(districtAdapter.getItem(i).nameEng.equalsIgnoreCase(district)){
                    districtSpinner.setSelection(i);
                }
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Location location = gpsTracker.getLocation();
        if(location != null){
            ((TextView)findViewById(R.id.location)).setText(""+location.getLatitude() + "," + location.getLongitude());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        gpsTracker.stopUsingGPS();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(parent == facilitySpinner){
            AddressItem item = facilityAdapter.getItem(position);
            observationAdapter.clear();
            if(item.id <= 0){
                if(item.id == -1) {
                    findViewById(R.id.observation_layout).setVisibility(View.GONE);
                }
                else{
                    findViewById(R.id.observation_layout).setVisibility(View.VISIBLE);
                    observationAdapter.add(new AddressItem(-1, "Select", "Select"));
                    observationAdapter.add(new AddressItem(3, "Inventory of Facility", "Inventory of Facility"));
                    observationAdapter.add(new AddressItem(0, "Observation of ANC", "Observation of ANC"));
                    observationAdapter.add(new AddressItem(2, "Observation of Sick Child ", "Observation of Sick Child "));
                    observationAdapter.add(new AddressItem(4, "Observation of Family planning", "Observation of Family planning"));
                    observationSpinner.setSelection(0);
                }
                findViewById(R.id.upazila_layout).setVisibility(View.GONE);
                findViewById(R.id.union_layout).setVisibility(View.GONE);
                findViewById(R.id.ward_layout).setVisibility(View.GONE);
                findViewById(R.id.village_layout).setVisibility(View.GONE);

            }
            else if(item.id == 1){ //upazilla
                findViewById(R.id.observation_layout).setVisibility(View.VISIBLE);
                findViewById(R.id.upazila_layout).setVisibility(View.VISIBLE);
                findViewById(R.id.union_layout).setVisibility(View.GONE);
                findViewById(R.id.ward_layout).setVisibility(View.GONE);
                findViewById(R.id.village_layout).setVisibility(View.GONE);

                observationAdapter.add(new AddressItem(-1, "Select", "Select"));
                observationAdapter.add(new AddressItem(3, "Inventory of Facility", "Inventory of Facility"));
                observationAdapter.add(new AddressItem(0, "Observation of ANC", "Observation of ANC"));
                observationAdapter.add(new AddressItem(2, "Observation of Sick Child ", "Observation of Sick Child "));
                observationAdapter.add(new AddressItem(4, "Observation of Family planning", "Observation of Family planning"));
                observationSpinner.setSelection(0);

            }
            else if(item.id == 2){// union
                findViewById(R.id.observation_layout).setVisibility(View.VISIBLE);
                findViewById(R.id.upazila_layout).setVisibility(View.VISIBLE);
                findViewById(R.id.union_layout).setVisibility(View.VISIBLE);
                findViewById(R.id.ward_layout).setVisibility(View.VISIBLE);
                findViewById(R.id.village_layout).setVisibility(View.GONE);

                observationAdapter.add(new AddressItem(-1, "Select", "Select"));
                observationAdapter.add(new AddressItem(3, "Inventory of Facility", "Inventory of Facility"));
                observationAdapter.add(new AddressItem(0, "Observation of ANC", "Observation of ANC"));
                observationAdapter.add(new AddressItem(2, "Observation of Sick Child ", "Observation of Sick Child "));
                observationAdapter.add(new AddressItem(4, "Observation of Family planning", "Observation of Family planning"));
                observationSpinner.setSelection(0);
            }
            else if(item.id == 3){ //satellite
                findViewById(R.id.observation_layout).setVisibility(View.VISIBLE);
                findViewById(R.id.upazila_layout).setVisibility(View.VISIBLE);
                findViewById(R.id.union_layout).setVisibility(View.VISIBLE);
                findViewById(R.id.ward_layout).setVisibility(View.VISIBLE);
                findViewById(R.id.village_layout).setVisibility(View.VISIBLE);

                observationAdapter.add(new AddressItem(-1, "Select", "Select"));
                observationAdapter.add(new AddressItem(1, "Inventory of satellite clinic", "Inventory of satellite clinic"));
                observationAdapter.add(new AddressItem(0, "Observation of ANC", "Observation of ANC"));
                observationAdapter.add(new AddressItem(2, "Observation of Sick Child ", "Observation of Sick Child "));
                observationAdapter.add(new AddressItem(4, "Observation of Family planning", "Observation of Family planning"));
                observationSpinner.setSelection(0);
            }
        }
        else if(parent == districtSpinner){
            AddressItem item = districtAdapter.getItem(position);
            upazilaAdapter.clear();
            unionAdapter.clear();
            wardAdapter.clear();
            villageAdapter.clear();
            if(item.id > 0)
            {
                final DatabaseAccessUpazila databaseAccessUpazila = caresurvey.sci.com.caresurvey.database.DatabaseAccessUpazila.getInstance(this);
                databaseAccessUpazila.open();
                upazilaAdapter.add(new AddressItem(-1,"Select","Select"));
                upazilaAdapter.addAll(databaseAccessUpazila.getUpazila(Integer.toString(item.id)));
                databaseAccessUpazila.close();
                if(upazilaAdapter.getCount() == 2){
                    upazilaSpinner.setSelection(1);
                }
                else{
                    upazilaSpinner.setSelection(0);
                }
                districtText.setText(item.name);
                final DatabaseAccessVillage databaseAccessVillage = DatabaseAccessVillage.getInstance(this);
                try {

                    AddressItem selectedDistrict = districtAdapter.getItem(districtSpinner.getSelectedItemPosition());
                    AddressItem selectedUpazilla = upazilaAdapter.getItem(upazilaSpinner.getSelectedItemPosition());
                    AddressItem selectedUnion = unionAdapter.getItem(unionSpinner.getSelectedItemPosition());
                    databaseAccessVillage.open();
                    villageAdapter.addAll(databaseAccessVillage.getVillage(Integer.toString(selectedDistrict.id), Integer.toString(selectedUpazilla.id), Integer.toString(selectedUnion.id)));
                    databaseAccessVillage.close();
                    if (villageAdapter.getCount() > 0) {
                        villageAdapter.insert(new AddressItem(-1, "Select", "Select"), 0);
                    }
                    if (villageAdapter.getCount() == 2) {
                        villageSpinner.setSelection(1);
                    } else if (villageAdapter.getCount() > 0) {
                        villageSpinner.setSelection(0);
                    }

                }catch (Exception e){
                    e.printStackTrace();
                    databaseAccessVillage.close();
                }
            }
        }
        else if(parent == upazilaSpinner){
            AddressItem item = upazilaAdapter.getItem(position);
            unionAdapter.clear();
            wardAdapter.clear();
            villageAdapter.clear();
            if(item.id > 0){
                unionAdapter.add(new AddressItem(-1,"Select","Select"));
                final DatabaseAccessUnion databaseAccessUnion =DatabaseAccessUnion.getInstance(this);
                databaseAccessUnion.open();
                unionAdapter.addAll(databaseAccessUnion.getUnion(Integer.toString(item.id)));
                wardAdapter.addAll(databaseAccessUnion.getWard(Integer.toString(item.id)));
                if(wardAdapter.getCount() > 0){
                    wardAdapter.insert(new AddressItem(-1,"Select","Select"),0);
                }
                databaseAccessUnion.close();
                if(unionAdapter.getCount() == 2){
                    unionSpinner.setSelection(1);
                }
                else {
                    unionSpinner.setSelection(0);
                }
                try{
                    if(wardAdapter.getCount() == 2){
                        wardSpinner.setSelection(1);
                    }
                    else {
                        wardSpinner.setSelection(0);
                    }
                }catch (Exception e){

                }
                final DatabaseAccessVillage databaseAccessVillage = DatabaseAccessVillage.getInstance(this);
                try {

                    AddressItem selectedDistrict = districtAdapter.getItem(districtSpinner.getSelectedItemPosition());
                    AddressItem selectedUpazilla = upazilaAdapter.getItem(upazilaSpinner.getSelectedItemPosition());
                    AddressItem selectedUnion = unionAdapter.getItem(unionSpinner.getSelectedItemPosition());
                    databaseAccessVillage.open();
                    villageAdapter.addAll(databaseAccessVillage.getVillage(Integer.toString(selectedDistrict.id), Integer.toString(selectedUpazilla.id), Integer.toString(selectedUnion.id)));
                    databaseAccessVillage.close();
                    if (villageAdapter.getCount() > 0) {
                        villageAdapter.insert(new AddressItem(-1, "Select", "Select"), 0);
                    }
                    if (villageAdapter.getCount() == 2) {
                        villageSpinner.setSelection(1);
                    } else if (villageAdapter.getCount() > 0) {
                        villageSpinner.setSelection(0);
                    }

                }catch (Exception e){
                    e.printStackTrace();
                    databaseAccessVillage.close();
                }
            }
        }
        else if(parent == unionSpinner){
            AddressItem item = unionAdapter.getItem(position);
            villageAdapter.clear();
            if(item.id > 0){
                final DatabaseAccessVillage databaseAccessVillage = DatabaseAccessVillage.getInstance(this);
                try {

                    AddressItem selectedDistrict = districtAdapter.getItem(districtSpinner.getSelectedItemPosition());
                    AddressItem selectedUpazilla = upazilaAdapter.getItem(upazilaSpinner.getSelectedItemPosition());
                    AddressItem selectedUnion = unionAdapter.getItem(unionSpinner.getSelectedItemPosition());
                    databaseAccessVillage.open();
                    villageAdapter.addAll(databaseAccessVillage.getVillage(Integer.toString(selectedDistrict.id), Integer.toString(selectedUpazilla.id), Integer.toString(selectedUnion.id)));
                    databaseAccessVillage.close();
                    if (villageAdapter.getCount() > 0) {
                        villageAdapter.insert(new AddressItem(-1, "Select", "Select"), 0);
                    }
                    if (villageAdapter.getCount() == 2) {
                        villageSpinner.setSelection(1);
                    } else if (villageAdapter.getCount() > 0) {
                        villageSpinner.setSelection(0);
                    }

                }catch (Exception e){
                    e.printStackTrace();
                    databaseAccessVillage.close();
                }
            }
        }
        else if(parent == observationSpinner){
            String totalObservation = "/30";
            AddressItem item = observationAdapter.getItem(position);
            long lastId = 0;
            if(item.id == 0){
                lastId = new ANCTable(AddressInsertActivity2.this).getLastId();
            }
            else if(item.id == 1){
                lastId = new SatelliteClinicTable(AddressInsertActivity2.this).getLastId();
            }
            else if(item.id == 2){
                lastId = new SickChildTable(AddressInsertActivity2.this).getLastId();
            }
            else if(item.id == 3){
                lastId = new InventoryTable(AddressInsertActivity2.this).getLastId();
                totalObservation = "/1";
            }
            else if(item.id == 4){
                lastId = new FpObservationTable(AddressInsertActivity2.this).getLastId();
            }
            if(item.id == -1){
                facilityID.setText("");
            }
            else {
                facilityID.setText("" + (++lastId) + totalObservation);
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    private final int MAX_RANGE = 30;
    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.next){
            try{
                collectData();
                Location location = gpsTracker.getLocation();
                if(location != null){
                    ((TextView)findViewById(R.id.location)).setText(""+location.getLatitude() + "," + location.getLongitude());
                }
                else{
                    Toast.makeText(this,"Location not found. Please enable gps, wait a moment and try again.",Toast.LENGTH_SHORT);
                    gpsTracker.getLocation();
                    return;
                }

//                switch (observationPosition){
//                    case 0:
//                        if(new ANCTable(this).getRowSize() >= MAX_RANGE){
//                            Toast.makeText(this,"Maximum observation has been completed",Toast.LENGTH_SHORT).show();
//                            finish();
//                            return;
//                        }
//                        break;
//                    case 1:
//                        if(new SatelliteClinicTable(this).getRowSize() >= MAX_RANGE){
//                            Toast.makeText(this,"Maximum observation has been completed",Toast.LENGTH_SHORT).show();
//                            finish();
//                            return;
//                        }
//                        break;
//                    case 2:
//                        if(new SickChildTable(this).getRowSize() >= MAX_RANGE){
//                            Toast.makeText(this,"Maximum observation has been completed",Toast.LENGTH_SHORT).show();
//                            finish();
//                            return;
//                        }
//                        break;
//                    case 3:
//                        if(new InventoryTable(this).getRowSize() >= 1){
//                            Toast.makeText(this,"Maximum observation has been completed",Toast.LENGTH_SHORT).show();
//                            finish();
//                            return;
//                        }
//                        break;
//                    case 4:
//                        if(new FpObservationTable(this).getRowSize() >= MAX_RANGE){
//                            Toast.makeText(this,"Maximum observation has been completed",Toast.LENGTH_SHORT).show();
//                            finish();
//                            return;
//                        }
//                        break;
//                }
                Intent intent = new Intent(this, ConsentActivity2.class);
                intent.putExtra("facility",facility);
                intent.putExtra("upozila", upazila);
                intent.putExtra("union", union);
                intent.putExtra("village", village);
                intent.putExtra("district",district);
                intent.putExtra("ward",ward);
                intent.putExtra("serial",facilityID.getText().toString());
                intent.putExtra("obs_name",observationName);
                intent.putExtra("lat",(""+location.getLatitude()));
                intent.putExtra("lon",(""+location.getLongitude()));
                intent.putExtra(ConsentActivity1.FORM,observationPosition);
                startActivity(intent);
                finish();
            }catch (Exception e){
                e.printStackTrace();
                Toast.makeText(this,"Form is not complete",Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        if(location != null){
            ((TextView)findViewById(R.id.location)).setText(""+location.getLatitude() + "," + location.getLongitude());
        }
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    private class AddressAdapter extends ArrayAdapter<AddressItem>{
        private LayoutInflater inflater;
        private int resource;
        public AddressAdapter(Context context, int resource) {
            super(context, resource);
            inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
            this.resource = resource;
        }

        public AddressAdapter(Context context, int resource, List<AddressItem> list) {
            super(context, resource,list);
            inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
            this.resource = resource;
        }

        @Override
        public View getDropDownView(int position, View convertView, ViewGroup parent){
            ViewHolder holder;
            if(convertView == null){
                convertView = inflater.inflate(resource,parent,false);
                holder = new ViewHolder();
                holder.textView = (TextView) convertView.findViewById(android.R.id.text1);
                convertView.setTag(holder);
            }
            else{
                holder = (ViewHolder) convertView.getTag();
            }
            holder.textView.setText(getItem(position).name);
            return convertView;
        }

        class ViewHolder{
            TextView textView;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if(convertView == null){
                convertView = inflater.inflate(resource,parent,false);
                holder = new ViewHolder();
                holder.textView = (TextView) convertView.findViewById(android.R.id.text1);
                convertView.setTag(holder);
            }
            else{
                holder = (ViewHolder) convertView.getTag();
            }
            holder.textView.setText(getItem(position).name);
            return convertView;
        }
    }

    private void collectData() throws Exception {
        AddressItem item = districtAdapter.getItem(districtSpinner.getSelectedItemPosition());
        if(item.id == -1){
            district = "";
            throw new Exception();
        }
        else{
            district = item.nameEng;
        }

        item = facilityAdapter.getItem(facilitySpinner.getSelectedItemPosition());
        if(item.id == -1){
            facility = "";
            throw new Exception();
        }
        else{
            facility = item.nameEng;
        }
        item = observationAdapter.getItem(observationSpinner.getSelectedItemPosition());
        if(item.id == -1){
            observationPosition = -1;
            observationName = "";
            throw new Exception();
        }
        else{
            observationPosition = item.id;
            observationName = item.nameEng;
        }
        if(findViewById(R.id.upazila_layout).getVisibility() == View.VISIBLE) {
            item = upazilaAdapter.getItem(upazilaSpinner.getSelectedItemPosition());
            if (item.id == -1) {
                upazila = "";
                throw new Exception();
            } else {
                upazila = item.nameEng;
            }
        }

        if(findViewById(R.id.union_layout).getVisibility() == View.VISIBLE) {
            item = unionAdapter.getItem(unionSpinner.getSelectedItemPosition());
            if (item.id == -1) {
                union = "";
                throw new Exception();
            } else {
                union = item.nameEng;
            }
        }

        if(findViewById(R.id.ward_layout).getVisibility() == View.VISIBLE) {
            item = wardAdapter.getItem(wardSpinner.getSelectedItemPosition());
            if (item.id == -1) {
                ward = "";
                throw new Exception();
            } else {
                ward = item.nameEng;
            }
        }

        if(findViewById(R.id.village_layout).getVisibility() == View.VISIBLE) {
            item = villageAdapter.getItem(villageSpinner.getSelectedItemPosition());
            if (item.id == -1) {
                village = "";
                throw new Exception();
            } else {
                village = item.nameEng;
            }
        }
    }

}
