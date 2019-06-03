package com.sogeti.rental.ui.views;


import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.actions.SimpleWildcardTester;
import org.eclipse.ui.part.ViewPart;

import com.opcoach.training.rental.Rental;
import com.sogeti.rental.core.RentalCoreActivator;

public class RentalView extends ViewPart {
	
	Label objectNameLabel;
	Label clientNameLabel;

	Label firstDateLabel;
	Label lastDateLabel;
	
	public RentalView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {
		
		parent.setLayout(new GridLayout(1, false));
		
		///////////////////////////////////////////////
		/////////  Info Client ////////////////////////
		///////////////////////////////////////////////
		
		Group infoGroup = new Group(parent, SWT.NONE);
		
		infoGroup.setText("Informations");
		infoGroup.setLayout(new GridLayout(2, false));
		
		objectNameLabel = new Label(infoGroup, SWT.BORDER);
		GridData gridData = new GridData();
		gridData.horizontalSpan = 2;
		gridData.horizontalAlignment = SWT.FILL;
		
		objectNameLabel.setLayoutData(gridData);
		
		Label rentByLabel = new Label(infoGroup, SWT.CENTER);
		rentByLabel.setText("Loué par : ");
		
		clientNameLabel = new Label(infoGroup, SWT.CENTER);
		
		///////////////////////////////////////////////
		/////////  Info Date //////////////////////////
		///////////////////////////////////////////////
		
		Group infoGroupDate = new Group(parent, SWT.NONE);
		
		infoGroupDate.setText("Date");
		infoGroupDate.setLayout(new GridLayout(2, false));
		
		Label firstDate = new Label(infoGroupDate, SWT.CENTER);
		firstDate.setText("du : ");
		
		firstDateLabel = new Label(infoGroupDate, SWT.CENTER);
		
		Label lastDate = new Label(infoGroupDate, SWT.CENTER);
		lastDate.setText("au : ");
	
		lastDateLabel = new Label(infoGroupDate, SWT.CENTER);
		
		setRental(RentalCoreActivator.getAgency().getRentals().get(0));
	}

	private void setRental(Rental rental) {
		
		objectNameLabel.setText(rental.getRentedObject().getName());
		clientNameLabel.setText(rental.getCustomer().getDisplayName());
		firstDateLabel.setText(rental.getStartDate().toString());
		lastDateLabel.setText(rental.getEndDate().toString());
		
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
