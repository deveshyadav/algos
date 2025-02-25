```mermaid
stateDiagram-v2
    [*] --> Shipment_Created
    Shipment_Created --> Asset_Assigned: XB Event (Asset Assigned)
    Asset_Assigned --> In_Transit: LO Event (Location Update)
    In_Transit --> Final_Arrival: FV_AUD Event (Arrived at Destination)
    Final_Arrival --> [*]
    
    state Shipment_Created {
        Shipment_Created --> Validate_Details: Validate Shipment Data
        Validate_Details --> Initialize_Tracking: Initialize Tracking (if Air Mode)
        Initialize_Tracking --> Shipment_Created
    }
    
    state Asset_Assigned {
        Asset_Assigned --> Validate_Asset: Ensure Valid Asset
        Validate_Asset --> Update_Shipment: Update Shipment Tracking
        Update_Shipment --> Asset_Assigned
    }
    
    state In_Transit {
        In_Transit --> Validate_Location: Validate Stop & Status
        Validate_Location --> Update_Progress: Update Shipment Progress
        Update_Progress --> In_Transit
    }
```
    
    state Final_Arrival {
        Final_Arrival --> Mark_Complete: Set Shipment Status to Completed
        Mark_Complete --> Update_ETA: Trigger ETA Calculation (if Needed)
        Update_ETA --> Final_Arrival
    }
