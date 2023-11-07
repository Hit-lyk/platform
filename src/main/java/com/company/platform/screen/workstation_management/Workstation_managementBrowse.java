package com.company.platform.screen.workstation_management;

import io.jmix.ui.screen.*;
import com.company.platform.entity.Workstation_management;

@UiController("Workstation_management.browse")
@UiDescriptor("workstation_management-browse.xml")
@LookupComponent("workstation_managementsTable")
public class Workstation_managementBrowse extends StandardLookup<Workstation_management> {
}