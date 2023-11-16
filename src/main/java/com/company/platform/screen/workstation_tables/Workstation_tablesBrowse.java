package com.company.platform.screen.workstation_tables;

import io.jmix.ui.screen.*;
import com.company.platform.entity.Workstation_tables;

@UiController("Workstation_tables.browse")
@UiDescriptor("workstation_tables-browse.xml")
@LookupComponent("workstation_tablesesTable")
public class Workstation_tablesBrowse extends StandardLookup<Workstation_tables> {
}