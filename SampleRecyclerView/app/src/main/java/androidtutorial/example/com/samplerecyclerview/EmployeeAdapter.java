package androidtutorial.example.com.samplerecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by kathires on 6/16/16.
 */

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder>  {

    private EmployeeList mEmployeeList;

    public EmployeeAdapter( EmployeeList employeeList ){

        mEmployeeList = employeeList;

    }

    @Override
    public void onBindViewHolder(EmployeeAdapter.EmployeeViewHolder holder, int position) {

        EmployeeInfo employee = (EmployeeInfo) mEmployeeList.getEmployeeList().get( position );
        holder.mEmployeeName.setText( employee.getName() );
        holder.mEmployeeRole.setText( employee.getRole() );
        holder.mEmployeeAge.setText( employee.getAge()+"" );

    }

    @Override
    public EmployeeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from( context );
        EmployeeAdapter.EmployeeViewHolder viewHolder = new EmployeeAdapter.EmployeeViewHolder( inflater.inflate( R.layout.activity_employee, parent, false ) );

        return viewHolder;
    }

    @Override
    public int getItemCount() {

        return mEmployeeList.getEmployeeList().size();

    }

    public static class EmployeeViewHolder extends RecyclerView.ViewHolder{

        public TextView mEmployeeName;
        public TextView mEmployeeRole;
        public TextView mEmployeeAge;

        public EmployeeViewHolder(View itemView){

            super(itemView);

            mEmployeeName = (TextView)itemView.findViewById( R.id.empName );
            mEmployeeRole = (TextView)itemView.findViewById( R.id.empRole );
            mEmployeeAge = (TextView)itemView.findViewById( R.id.empAge );

        }

    }

}
