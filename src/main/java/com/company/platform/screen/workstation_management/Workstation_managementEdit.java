package com.company.platform.screen.workstation_management;

import io.jmix.ui.screen.*;
import com.company.platform.entity.Workstation_management;

@UiController("Workstation_management.edit")
@UiDescriptor("workstation_management-edit.xml")
@EditedEntityContainer("workstation_managementDc")
public class Workstation_managementEdit extends StandardEditor<Workstation_management> {
}