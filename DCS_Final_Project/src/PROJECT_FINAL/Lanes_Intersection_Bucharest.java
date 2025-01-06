package PROJECT_FINAL;

import Components.PetriNet;
import Components.Activation;
import Components.Condition;
import Components.GuardMapping;
import Components.PetriNet;
import Components.PetriNetWindow;
import Components.PetriTransition;
import DataObjects.DataCar;
import DataObjects.DataCarQueue;
import DataObjects.DataString;
import DataObjects.DataTransfer;
import DataOnly.TransferOperation;
import Enumerations.LogicConnector;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;

public class Lanes_Intersection_Bucharest {

    public static void main(String[] args) {

        PetriNet pn = new PetriNet();
        pn.PetriNetName = "Lanes Intersection Bucharest";
        pn.NetworkPort = 1080;

        // -------------------------------------------------------------------
        // --------------------CALEA FERENTARI SECTION 1----------------------
        // -------------------------------------------------------------------

        DataString red = new DataString();
        //red.Printable = false;
        red.SetName("red");
        red.SetValue("red");
        pn.ConstantPlaceList.add(red);

        DataString green = new DataString();
        //green.Printable = false;
        green.SetName("green");
        green.SetValue("green");
        pn.ConstantPlaceList.add(green);

        DataString yellow = new DataString();
        //yellow.Printable = false;
        yellow.SetName("yellow");
        yellow.SetValue("yellow");
        pn.ConstantPlaceList.add(yellow);

        //------------------VEST--------------------------
        //-------------------IN---------------------------
        DataCar P_LaneIn_S1 = new DataCar();
        P_LaneIn_S1.SetName("P_LaneIn_S1");
        pn.PlaceList.add(P_LaneIn_S1);

        DataCarQueue P_Lane_DunuvatIn_V_S1 = new DataCarQueue();
        P_Lane_DunuvatIn_V_S1.Value.Size = 2;
        P_Lane_DunuvatIn_V_S1.SetName("P_Lane_DunuvatIn_V_S1");
        pn.PlaceList.add(P_Lane_DunuvatIn_V_S1);

        //----------------------------T0_V_S1---------------------------------------- //T0
        PetriTransition T0_In_V_S1 = new PetriTransition(pn);
        T0_In_V_S1.TransitionName = "T0_In_V_S1";
        T0_In_V_S1.InputPlaceName.add("P_LaneIn_S1");
        T0_In_V_S1.InputPlaceName.add("P_Lane_DunuvatIn_V_S1");

        // --------------guard 1-------------------------------------------------------
        Condition T0_In_V_S1_Ct11 = new Condition(T0_In_V_S1, "P_LaneIn_S1", TransitionCondition.NotNull);
        Condition T0_In_V_S1_Ct12 = new Condition(T0_In_V_S1, "P_Lane_DunuvatIn_V_S1", TransitionCondition.DontHaveCar);
        Condition T0_In_V_S1_Ct13 = new Condition(T0_In_V_S1, "P_LaneIn_int1_V_S1", TransitionCondition.CanAddCars);
        T0_In_V_S1_Ct12.SetNextCondition(LogicConnector.AND, T0_In_V_S1_Ct13);
        T0_In_V_S1_Ct11.SetNextCondition(LogicConnector.AND, T0_In_V_S1_Ct12);
        GuardMapping grd1T0_In_V_S1 = new GuardMapping();
        grd1T0_In_V_S1.condition = T0_In_V_S1_Ct11;
        grd1T0_In_V_S1.Activations.add(new Activation(T0_In_V_S1, "P_LaneIn_S1", TransitionOperation.AddElement, "P_LaneIn_int1_V_S1"));
        T0_In_V_S1.GuardMappingList.add(grd1T0_In_V_S1);

        // --------------guard 2-------------------------------------------------------
        Condition T0_In_V_S1_Ct21 = new Condition(T0_In_V_S1, "P_LaneIn_S1", TransitionCondition.IsNull);
        Condition T0_In_V_S1_Ct22 = new Condition(T0_In_V_S1, "P_Lane_DunuvatIn_V_S1", TransitionCondition.HaveCar);
        Condition T0_In_V_S1_Ct23 = new Condition(T0_In_V_S1, "P_LaneIn_int1_V_S1", TransitionCondition.CanAddCars);
        T0_In_V_S1_Ct22.SetNextCondition(LogicConnector.AND, T0_In_V_S1_Ct23);
        T0_In_V_S1_Ct21.SetNextCondition(LogicConnector.AND, T0_In_V_S1_Ct22);
        GuardMapping grd2T0_In_V_S1 = new GuardMapping();
        grd2T0_In_V_S1.condition = T0_In_V_S1_Ct21;
        grd2T0_In_V_S1.Activations.add(new Activation(T0_In_V_S1, "P_Lane_DunuvatIn_V_S1", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int1_V_S1"));
        T0_In_V_S1.GuardMappingList.add(grd2T0_In_V_S1);

        // --------------guard 3-------------------------------------------------------
        Condition T0_In_V_S1_Ct31 = new Condition(T0_In_V_S1, "P_LaneIn_S1", TransitionCondition.NotNull);
        Condition T0_In_V_S1_Ct32 = new Condition(T0_In_V_S1, "P_Lane_DunuvatIn_V_S1", TransitionCondition.HavePriorityCar);
        Condition T0_In_V_S1_Ct33 = new Condition(T0_In_V_S1, "P_LaneIn_int1_V_S1", TransitionCondition.CanAddCars);
        T0_In_V_S1_Ct32.SetNextCondition(LogicConnector.AND, T0_In_V_S1_Ct33);
        T0_In_V_S1_Ct31.SetNextCondition(LogicConnector.AND, T0_In_V_S1_Ct32);
        GuardMapping grd3T0_In_V_S1 = new GuardMapping();
        grd3T0_In_V_S1.condition = T0_In_V_S1_Ct31;
        grd3T0_In_V_S1.Activations.add(new Activation(T0_In_V_S1, "P_Lane_DunuvatIn_V_S1", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int1_V_S1"));
        grd3T0_In_V_S1.Activations.add(new Activation(T0_In_V_S1, "P_LaneIn_S1", TransitionOperation.AddElement, "P_LaneIn_int1_V_S1"));
        T0_In_V_S1.GuardMappingList.add(grd3T0_In_V_S1);

        // --------------guard 4-------------------------------------------------------
        Condition T0_In_V_S1_Ct41 = new Condition(T0_In_V_S1, "P_LaneIn_S1", TransitionCondition.NotNull);
        Condition T0_In_V_S1_Ct42 = new Condition(T0_In_V_S1, "P_Lane_DunuvatIn_V_S1", TransitionCondition.HaveCar);
        Condition T0_In_V_S1_Ct43 = new Condition(T0_In_V_S1, "P_LaneIn_int1_V_S1", TransitionCondition.CanAddCars);
        T0_In_V_S1_Ct42.SetNextCondition(LogicConnector.AND, T0_In_V_S1_Ct43);
        T0_In_V_S1_Ct41.SetNextCondition(LogicConnector.AND, T0_In_V_S1_Ct42);
        GuardMapping grd4T0_In_V_S1 = new GuardMapping();
        grd4T0_In_V_S1.condition = T0_In_V_S1_Ct41;
        grd4T0_In_V_S1.Activations.add(new Activation(T0_In_V_S1, "P_LaneIn_S1", TransitionOperation.AddElement, "P_LaneIn_int1_V_S1"));
        grd4T0_In_V_S1.Activations.add(new Activation(T0_In_V_S1, "P_Lane_DunuvatIn_V_S1", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int1_V_S1"));
        T0_In_V_S1.GuardMappingList.add(grd4T0_In_V_S1);


        T0_In_V_S1.Delay = 0;
        pn.Transitions.add(T0_In_V_S1);
        //---------------------------- END T0_V_S1---------------------------------------- //T0


        DataCarQueue P_LaneIn_int1_V_S1 = new DataCarQueue();
        P_LaneIn_int1_V_S1.Value.Size = 3;
        P_LaneIn_int1_V_S1.SetName("P_LaneIn_int1_V_S1");
        pn.PlaceList.add(P_LaneIn_int1_V_S1);

        //----------------------------T2_V_S1---------------------------------------- //T4
        PetriTransition T2_In_V_S1 = new PetriTransition(pn);
        T2_In_V_S1.TransitionName = "T2_In_V_S1";
        T2_In_V_S1.InputPlaceName.add("P_LaneIn_int1_V_S1");

        // --------------guard 1-------------------------------------------------------
        Condition T2_In_V_S1_Ct11 = new Condition(T2_In_V_S1, "P_LaneIn_int1_V_S1", TransitionCondition.HaveCarForMe);
        Condition T2_In_V_S1_Ct12 = new Condition(T2_In_V_S1, "P_LaneIn_int2_V_S1", TransitionCondition.CanAddCars);
        T2_In_V_S1_Ct11.SetNextCondition(LogicConnector.AND, T2_In_V_S1_Ct12);
        GuardMapping grd1T2_In_V_S1 = new GuardMapping();
        grd1T2_In_V_S1.condition = T2_In_V_S1_Ct11;
        grd1T2_In_V_S1.Activations.add(new Activation(T2_In_V_S1, "P_LaneIn_int1_V_S1", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int2_V_S1"));
        T2_In_V_S1.GuardMappingList.add(grd1T2_In_V_S1);

        T2_In_V_S1.Delay = 0;
        pn.Transitions.add(T2_In_V_S1);
        //---------------------------- END T2_V_S1---------------------------------------- //T4

        DataCarQueue P_LaneIn_int2_V_S1 = new DataCarQueue();
        P_LaneIn_int2_V_S1.SetName("P_LaneIn_int2_V_S1");
        P_LaneIn_int2_V_S1.Value.Size = 3;
        pn.PlaceList.add(P_LaneIn_int2_V_S1);

        DataCar P_Lane_TelitaOut_V_S1 = new DataCar();
        P_Lane_TelitaOut_V_S1.SetName("P_Lane_TelitaOut_V_S1");
        pn.PlaceList.add(P_Lane_TelitaOut_V_S1);

        //----------------------------T6_V_S1---------------------------------------- //T112
        PetriTransition T6_In_V_S1 = new PetriTransition(pn);
        T6_In_V_S1.TransitionName = "T6_In_V_S1";
        T6_In_V_S1.InputPlaceName.add("P_LaneIn_int1_V_S1");
        // --------------guard 1-------------------------------------------------------
        Condition T6_In_V_S1_Ct11 = new Condition(T6_In_V_S1, "P_LaneIn_int1_V_S1", TransitionCondition.HaveCarForMe);
        GuardMapping grd1T6_In_V_S1 = new GuardMapping();
        grd1T6_In_V_S1.condition= T6_In_V_S1_Ct11;
        grd1T6_In_V_S1.Activations.add(new Activation(T6_In_V_S1, "P_LaneIn_int1_V_S1", TransitionOperation.PopElementWithTarget, "P_Lane_TelitaOut_V_S1"));
        T6_In_V_S1.GuardMappingList.add(grd1T6_In_V_S1);
        T6_In_V_S1.Delay = 0;
        pn.Transitions.add(T6_In_V_S1);

        //----------------------------END T6_V_S1----------------------------------------

        DataCar P_Lane_TelitaIn_V_S1 = new DataCar();
        P_Lane_TelitaIn_V_S1.SetName("P_Lane_TelitaIn_V_S1");
        pn.PlaceList.add(P_Lane_TelitaIn_V_S1);

        //----------------------------T8_V_S1---------------------------------------- //T5
        PetriTransition T8_In_V_S1 = new PetriTransition(pn);
        T8_In_V_S1.TransitionName = "T8_In_V_S1";
        T8_In_V_S1.InputPlaceName.add("P_LaneIn_int2_V_S1");
        T8_In_V_S1.InputPlaceName.add("P_Lane_TelitaIn_V_S1");

        // --------------guard 1-------------------------------------------------------
        Condition T8_In_V_S1_Ct11 = new Condition(T8_In_V_S1, "P_LaneIn_int2_V_S1", TransitionCondition.HaveCar);
        Condition T8_In_V_S1_Ct12 = new Condition(T8_In_V_S1, "P_Lane_TelitaIn_V_S1", TransitionCondition.IsNull);
        Condition T8_In_V_S1_Ct13 = new Condition(T8_In_V_S1, "P_LaneIn_int3_V_S1", TransitionCondition.CanAddCars);
        T8_In_V_S1_Ct12.SetNextCondition(LogicConnector.AND, T8_In_V_S1_Ct13);
        T8_In_V_S1_Ct11.SetNextCondition(LogicConnector.AND, T8_In_V_S1_Ct12);
        GuardMapping grd1T8_In_V_S1 = new GuardMapping();
        grd1T8_In_V_S1.condition = T8_In_V_S1_Ct11;
        grd1T8_In_V_S1.Activations.add(new Activation(T8_In_V_S1, "P_LaneIn_int2_V_S1", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int3_V_S1"));
        T8_In_V_S1.GuardMappingList.add(grd1T8_In_V_S1);

        // --------------guard 2-------------------------------------------------------
        Condition T8_In_V_S1_Ct21 = new Condition(T8_In_V_S1, "P_LaneIn_int2_V_S1", TransitionCondition.DontHaveCar);
        Condition T8_In_V_S1_Ct22 = new Condition(T8_In_V_S1, "P_Lane_TelitaIn_V_S1", TransitionCondition.NotNull);
        Condition T8_In_V_S1_Ct23 = new Condition(T8_In_V_S1, "P_LaneIn_int3_V_S1", TransitionCondition.CanAddCars);
        T8_In_V_S1_Ct22.SetNextCondition(LogicConnector.AND, T8_In_V_S1_Ct23);
        T8_In_V_S1_Ct21.SetNextCondition(LogicConnector.AND, T8_In_V_S1_Ct22);
        GuardMapping grd2T8_In_V_S1 = new GuardMapping();
        grd2T8_In_V_S1.condition = T8_In_V_S1_Ct21;
        grd2T8_In_V_S1.Activations.add(new Activation(T8_In_V_S1, "P_Lane_TelitaIn_V_S1", TransitionOperation.AddElement, "P_LaneIn_int3_V_S1"));
        T8_In_V_S1.GuardMappingList.add(grd2T8_In_V_S1);

        // --------------guard 3-------------------------------------------------------
        Condition T8_In_V_S1_Ct31 = new Condition(T8_In_V_S1, "P_LaneIn_int2_V_S1", TransitionCondition.HaveCar);
        Condition T8_In_V_S1_Ct32 = new Condition(T8_In_V_S1, "P_Lane_TelitaIn_V_S1", TransitionCondition.IsPriorityCar);
        Condition T8_In_V_S1_Ct33 = new Condition(T8_In_V_S1, "P_LaneIn_int3_V_S1", TransitionCondition.CanAddCars);
        T8_In_V_S1_Ct32.SetNextCondition(LogicConnector.AND, T8_In_V_S1_Ct33);
        T8_In_V_S1_Ct31.SetNextCondition(LogicConnector.AND, T8_In_V_S1_Ct32);
        GuardMapping grd3T8_In_V_S1 = new GuardMapping();
        grd3T8_In_V_S1.condition = T8_In_V_S1_Ct31;
        grd3T8_In_V_S1.Activations.add(new Activation(T8_In_V_S1, "P_Lane_TelitaIn_V_S1", TransitionOperation.AddElement, "P_LaneIn_int3_V_S1"));
        grd3T8_In_V_S1.Activations.add(new Activation(T8_In_V_S1, "P_LaneIn_int2_V_S1", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int3_V_S1"));
        T8_In_V_S1.GuardMappingList.add(grd3T8_In_V_S1);

        // --------------guard 4-------------------------------------------------------
        Condition T8_In_V_S1_Ct41 = new Condition(T8_In_V_S1, "P_LaneIn_int2_V_S1", TransitionCondition.HaveCar);
        Condition T8_In_V_S1_Ct42 = new Condition(T8_In_V_S1, "P_Lane_TelitaIn_V_S1", TransitionCondition.NotNull);
        Condition T8_In_V_S1_Ct43 = new Condition(T8_In_V_S1, "P_LaneIn_int3_V_S1", TransitionCondition.CanAddCars);
        T8_In_V_S1_Ct42.SetNextCondition(LogicConnector.AND, T8_In_V_S1_Ct43);
        T8_In_V_S1_Ct41.SetNextCondition(LogicConnector.AND, T8_In_V_S1_Ct42);
        GuardMapping grd4T8_In_V_S1 = new GuardMapping();
        grd4T8_In_V_S1.condition = T8_In_V_S1_Ct41;
        grd4T8_In_V_S1.Activations.add(new Activation(T8_In_V_S1, "P_LaneIn_int2_V_S1", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int3_V_S1"));
        grd4T8_In_V_S1.Activations.add(new Activation(T8_In_V_S1, "P_Lane_TelitaIn_V_S1", TransitionOperation.AddElement, "P_LaneIn_int3_V_S1"));
        T8_In_V_S1.GuardMappingList.add(grd4T8_In_V_S1);


        T8_In_V_S1.Delay = 0;
        pn.Transitions.add(T8_In_V_S1);
        //----------------------------END T8_V_S1----------------------------------------

        DataCarQueue P_LaneIn_int3_V_S1 = new DataCarQueue();
        P_LaneIn_int3_V_S1.Value.Size = 3;
        P_LaneIn_int3_V_S1.SetName("P_LaneIn_int3_V_S1");
        pn.PlaceList.add(P_LaneIn_int3_V_S1);

        //----------------------------T10_V_S1---------------------------------------- //T8
        PetriTransition T10_In_V_S1 = new PetriTransition(pn);
        T10_In_V_S1.TransitionName = "T10_In_V_S1";
        T10_In_V_S1.InputPlaceName.add("P_LaneIn_int3_V_S1");

        // --------------guard 1-------------------------------------------------------
        Condition T10_In_V_S1_Ct11 = new Condition(T10_In_V_S1, "P_LaneIn_int3_V_S1", TransitionCondition.HaveCar);
        Condition T10_In_V_S1_Ct12 = new Condition(T10_In_V_S1, "P_LaneIn_int4_V_S1", TransitionCondition.CanAddCars);
        T10_In_V_S1_Ct11.SetNextCondition(LogicConnector.AND, T10_In_V_S1_Ct12);
        GuardMapping grd1T10_In_V_S1 = new GuardMapping();
        grd1T10_In_V_S1.condition = T10_In_V_S1_Ct11;
        grd1T10_In_V_S1.Activations.add(new Activation(T10_In_V_S1, "P_LaneIn_int3_V_S1", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int4_V_S1"));
        T10_In_V_S1.GuardMappingList.add(grd1T10_In_V_S1);

        T10_In_V_S1.Delay = 0;
        pn.Transitions.add(T10_In_V_S1);
        //---------------------------- END T10_V_S1----------------------------------------

        DataCarQueue P_LaneIn_int4_V_S1 = new DataCarQueue();
        P_LaneIn_int4_V_S1.Value.Size = 3;
        P_LaneIn_int4_V_S1.SetName("P_LaneIn_int4_V_S1");
        pn.PlaceList.add(P_LaneIn_int4_V_S1);

        DataCar P_LaneInOut_V_S1 = new DataCar();
        P_LaneInOut_V_S1.SetName("P_LaneInOut_V_S1");
        pn.PlaceList.add(P_LaneInOut_V_S1);

        //----------------------------T12_V_S1---------------------------------------- //T9
        PetriTransition T12_In_V_S1 = new PetriTransition(pn);
        T12_In_V_S1.TransitionName = "T12_In_V_S1";
        T12_In_V_S1.InputPlaceName.add("P_LaneIn_int4_V_S1");

        // --------------guard 1-------------------------------------------------------
        Condition T12_In_V_S1_Ct11 = new Condition(T12_In_V_S1, "P_LaneIn_int4_V_S1", TransitionCondition.HaveCarForMe);
        Condition T12_In_V_S1_Ct12 = new Condition(T12_In_V_S1, "P_LaneIn_int5_V_S1", TransitionCondition.CanAddCars);
        T12_In_V_S1_Ct11.SetNextCondition(LogicConnector.AND, T12_In_V_S1_Ct12);
        GuardMapping grd1T12_In_V_S1 = new GuardMapping();
        grd1T12_In_V_S1.condition = T12_In_V_S1_Ct11;
        grd1T12_In_V_S1.Activations.add(new Activation(T12_In_V_S1, "P_LaneIn_int4_V_S1", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneIn_int5_V_S1"));
        T12_In_V_S1.GuardMappingList.add(grd1T12_In_V_S1);

        T12_In_V_S1.Delay = 0;
        pn.Transitions.add(T12_In_V_S1);
        //---------------------------- END T12_V_S1----------------------------------------

        //----------------------------T14_V_S1---------------------------------------- //T113
        PetriTransition T14_In_V_S1 = new PetriTransition(pn);
        T14_In_V_S1.TransitionName = "T14_In_V_S1";
        T14_In_V_S1.InputPlaceName.add("P_LaneIn_int4_V_S1");

        // --------------guard 1-------------------------------------------------------
        Condition T14_In_V_S1_Ct11 = new Condition(T14_In_V_S1, "P_LaneIn_int4_V_S1", TransitionCondition.HaveCarForMe);
        GuardMapping grd1T14_In_V_S1 = new GuardMapping();
        grd1T14_In_V_S1.condition = T14_In_V_S1_Ct11;
        grd1T14_In_V_S1.Activations.add(new Activation(T14_In_V_S1, "P_LaneIn_int4_V_S1", TransitionOperation.PopElementWithoutTarget, "P_LaneInOut_V_S1"));
        T14_In_V_S1.GuardMappingList.add(grd1T14_In_V_S1);

        T14_In_V_S1.Delay = 0;
        pn.Transitions.add(T14_In_V_S1);
        //---------------------------- END T14_V_S1----------------------------------------

        DataCarQueue P_LaneIn_int5_V_S1 = new DataCarQueue();
        P_LaneIn_int5_V_S1.Value.Size = 4;
        P_LaneIn_int5_V_S1.SetName("P_LaneIn_int5_V_S1");
        pn.PlaceList.add(P_LaneIn_int5_V_S1);

        //------------------------------T16_V_S1-------------------------------------------- //T_u_car1_V
        PetriTransition T16_In_V_S1 = new PetriTransition(pn);
        T16_In_V_S1.TransitionName = "T16_In_V_S1";
        T16_In_V_S1.InputPlaceName.add("P_LaneIn_int5_V_S1");
        T16_In_V_S1.InputPlaceName.add("P_x_Lane_V_S1");

        Condition T16_In_V_S1_Ct11 = new Condition(T16_In_V_S1, "P_LaneIn_int5_V_S1", TransitionCondition.HaveCar);
        Condition T16_In_V_S1_Ct12 = new Condition(T16_In_V_S1, "P_x_Lane_V_S1", TransitionCondition.CanAddCars);
        T16_In_V_S1_Ct11.SetNextCondition(LogicConnector.AND, T16_In_V_S1_Ct12);

        GuardMapping grd1T16_In_V_S1 = new GuardMapping();
        grd1T16_In_V_S1.condition = T16_In_V_S1_Ct11;
        grd1T16_In_V_S1.Activations.add(new Activation(T16_In_V_S1, "P_LaneIn_int5_V_S1", TransitionOperation.PopElementWithoutTargetToQueue, "P_x_Lane_V_S1"));
        T16_In_V_S1.GuardMappingList.add(grd1T16_In_V_S1);

        T16_In_V_S1.Delay = 0;
        pn.Transitions.add(T16_In_V_S1);
        //---------------------------- END T16_V_S1----------------------------------------

        DataCarQueue P_x_Lane_V_S1 = new DataCarQueue();
        P_x_Lane_V_S1.Value.Size = 4;
        P_x_Lane_V_S1.SetName("P_x_Lane_V_S1");
        pn.PlaceList.add(P_x_Lane_V_S1);

        //------------------------------T18_V_S1-------------------------------------------- //T_e_car1_V
        PetriTransition T18_In_V_S1 = new PetriTransition(pn);
        T18_In_V_S1.TransitionName = "T18_V_S1";
        T18_In_V_S1.InputPlaceName.add("P_x_Lane_V_S1");
        T18_In_V_S1.InputPlaceName.add("P_TL_V_S1");
        T18_In_V_S1.InputPlaceName.add("UserReq_V_S1");
        T18_In_V_S1.InputPlaceName.add("P_PTL_V_S1");

        //-----------------------guard3---------------------------------------------------

        Condition T18_In_S_S1_C31 = new Condition(T18_In_V_S1, "P_x_Lane_V_S1", TransitionCondition.HavePriorityCar);
        GuardMapping grd3T18_In_S_S1 = new GuardMapping();
        grd3T18_In_S_S1.condition= T18_In_S_S1_C31;
        grd3T18_In_S_S1.Activations.add(new Activation(T18_In_V_S1, "P_x_Lane_V_S1", TransitionOperation.PopElementWithoutTarget, "P_b_Lane_V_S1"));
        grd3T18_In_S_S1.Activations.add(new Activation(T18_In_V_S1, "P_TL_V_S1", TransitionOperation.Move, "P_TL_V_S1"));
        grd3T18_In_S_S1.Activations.add(new Activation(T18_In_V_S1, "P_PTL_V_S1", TransitionOperation.Move, "P_PTL_V_S1"));

        T18_In_V_S1.GuardMappingList.add(grd3T18_In_S_S1);

        //-----------------------guard1---------------------------------------------------

        Condition T18_In_V_S1_Ct11 = new Condition(T18_In_V_S1, "P_TL_V_S1", TransitionCondition.Equal,"green");
        Condition T18_In_V_S1_Ct12 = new Condition(T18_In_V_S1, "P_x_Lane_V_S1", TransitionCondition.HaveCar);
        T18_In_V_S1_Ct11.SetNextCondition(LogicConnector.AND, T18_In_V_S1_Ct12);

        GuardMapping grd1T18_In_V_S1 = new GuardMapping();
        grd1T18_In_V_S1.condition= T18_In_V_S1_Ct11;
        grd1T18_In_V_S1.Activations.add(new Activation(T18_In_V_S1, "P_x_Lane_V_S1", TransitionOperation.PopElementWithoutTarget, "P_b_Lane_V_S1"));
        grd1T18_In_V_S1.Activations.add(new Activation(T18_In_V_S1, "P_TL_V_S1", TransitionOperation.Move, "P_TL_V_S1"));
        grd1T18_In_V_S1.Activations.add(new Activation(T18_In_V_S1, "P_PTL_V_S1", TransitionOperation.Move, "P_PTL_V_S1"));

        T18_In_V_S1.GuardMappingList.add(grd1T18_In_V_S1);
        //-----------------------guard2---------------------------------------------------
        Condition T18_In_V_S1_Ct13 = new Condition(T18_In_V_S1, "UserReq_V_S1", TransitionCondition.NotNull);

        GuardMapping grd2T18_In_V_S1 = new GuardMapping();
        grd2T18_In_V_S1.condition = T18_In_V_S1_Ct13;

        grd2T18_In_V_S1.Activations.add(new Activation(T18_In_V_S1, "P_TL_V_S1", TransitionOperation.Move, "P_TL_V_S1"));
        grd2T18_In_V_S1.Activations.add(new Activation(T18_In_V_S1, "P_PTL_V_S1", TransitionOperation.Move, "P_PTL_V_S1"));
        grd2T18_In_V_S1.Activations.add(new Activation(T18_In_V_S1, "UserReq_V_S1", TransitionOperation.SendOverNetwork, "OP_Req_V_S1"));

        T18_In_V_S1.GuardMappingList.add(grd2T18_In_V_S1);

        T18_In_V_S1.Delay = 0;
        pn.Transitions.add(T18_In_V_S1);
        //---------------------------- END T18_V_S1----------------------------------------

        DataCar P_b_Lane_V_S1 = new DataCar();
        P_b_Lane_V_S1.SetName("P_b_Lane_V_S1");
        pn.PlaceList.add(P_b_Lane_V_S1);

        //-----------------------------T20_V_S1-------------------------------------------//T_I_Car1_V
        PetriTransition T20_In_V_S1 = new PetriTransition(pn);
        T20_In_V_S1.TransitionName = "T20_In_V_S1";
        T20_In_V_S1.InputPlaceName.add("P_b_Lane_V_S1");
        T20_In_V_S1.InputPlaceName.add("P_I_S1");

        Condition T20_In_V_S1_Ct11 = new Condition(T20_In_V_S1, "P_b_Lane_V_S1", TransitionCondition.NotNull);
        Condition T20_In_V_S1_Ct12 = new Condition(T20_In_V_S1, "P_I_S1", TransitionCondition.CanAddCars);
        T20_In_V_S1_Ct11.SetNextCondition(LogicConnector.AND, T20_In_V_S1_Ct12);

        GuardMapping grd1T20_In_V_S1 = new GuardMapping();
        grd1T20_In_V_S1.condition = T20_In_V_S1_Ct11;
        grd1T20_In_V_S1.Activations.add(new Activation(T20_In_V_S1, "P_b_Lane_V_S1", TransitionOperation.AddElement, "P_I_S1"));
        T20_In_V_S1.GuardMappingList.add(grd1T20_In_V_S1);

        T20_In_V_S1.Delay = 0;
        pn.Transitions.add(T20_In_V_S1);
        //---------------------------- END T20_V_S1----------------------------------------


        //-------------------OUT---------------------------
        DataCar P_LaneOut_V_S1 = new DataCar();
        P_LaneOut_V_S1.SetName("P_LaneOut_V_S1");
        pn.PlaceList.add(P_LaneOut_V_S1);

        DataCarQueue P_LaneOut_Int1_V_S1 = new DataCarQueue();
        P_LaneOut_Int1_V_S1.SetName("P_LaneOut_Int1_V_S1");
        P_LaneOut_Int1_V_S1.Value.Size = 3;
        pn.PlaceList.add(P_LaneOut_Int1_V_S1);

        DataCar P_LaneDonici_V_In_S1 = new DataCar();
        P_LaneDonici_V_In_S1.SetName("P_LaneDonici_V_In_S1");
        pn.PlaceList.add(P_LaneDonici_V_In_S1);

        //----------------------------T1_V_S1---------------------------------------- T3

        PetriTransition T1_Out_V_S1 = new PetriTransition(pn);
        T1_Out_V_S1.TransitionName = "T1_Out_V_S1";
        T1_Out_V_S1.InputPlaceName.add("P_LaneOut_Int1_V_S1");
        T1_Out_V_S1.InputPlaceName.add("P_LaneDonici_V_In_S1");

        // --------------guard 1-------------------------------------------------------OK
        Condition T1_Out_V_S1_Ct11 = new Condition(T1_Out_V_S1, "P_LaneOut_Int1_V_S1", TransitionCondition.HaveCar);
        Condition T1_Out_V_S1_Ct12 = new Condition(T1_Out_V_S1, "P_LaneDonici_V_In_S1", TransitionCondition.IsNull);
        T1_Out_V_S1_Ct11.SetNextCondition(LogicConnector.AND, T1_Out_V_S1_Ct12);
        GuardMapping grd1T1_Out_V_S1 = new GuardMapping();
        grd1T1_Out_V_S1.condition = T1_Out_V_S1_Ct11;
        grd1T1_Out_V_S1.Activations.add(new Activation(T1_Out_V_S1, "P_LaneOut_Int1_V_S1", TransitionOperation.PopElementWithoutTarget, "P_LaneOut_V_S1"));
        T1_Out_V_S1.GuardMappingList.add(grd1T1_Out_V_S1);

        // --------------guard 2-------------------------------------------------------OK with new condition DontHaveCar
        Condition T1_Out_V_S1_Ct21 = new Condition(T1_Out_V_S1, "P_LaneOut_Int1_V_S1", TransitionCondition.DontHaveCar);
        Condition T1_Out_V_S1_Ct22 = new Condition(T1_Out_V_S1, "P_LaneDonici_V_In_S1", TransitionCondition.NotNull);
        T1_Out_V_S1_Ct21.SetNextCondition(LogicConnector.AND, T1_Out_V_S1_Ct22);
        GuardMapping grd2T1_Out_V_S1 = new GuardMapping();
        grd2T1_Out_V_S1.condition = T1_Out_V_S1_Ct21;
        grd2T1_Out_V_S1.Activations.add(new Activation(T1_Out_V_S1, "P_LaneDonici_V_In_S1", TransitionOperation.Move, "P_LaneOut_V_S1"));
        T1_Out_V_S1.GuardMappingList.add(grd2T1_Out_V_S1);

        // --------------guard 3-------------------------------------------------------
        Condition T1_Out_V_S1_Ct31 = new Condition(T1_Out_V_S1, "P_LaneOut_Int1_V_S1", TransitionCondition.HaveCar);
        Condition T1_Out_V_S1_Ct32 = new Condition(T1_Out_V_S1, "P_LaneDonici_V_In_S1", TransitionCondition.IsPriorityCar);
        T1_Out_V_S1_Ct31.SetNextCondition(LogicConnector.AND, T1_Out_V_S1_Ct32);
        GuardMapping grd3T1_Out_V_S1 = new GuardMapping();
        grd3T1_Out_V_S1.condition = T1_Out_V_S1_Ct31;
        grd3T1_Out_V_S1.Activations.add(new Activation(T1_Out_V_S1, "P_LaneDonici_V_In_S1", TransitionOperation.Move, "P_LaneOut_V_S1"));
        grd3T1_Out_V_S1.Activations.add(new Activation(T1_Out_V_S1, "P_LaneOut_Int1_V_S1", TransitionOperation.PopElementWithoutTarget, "P_LaneOut_V_S1"));
        T1_Out_V_S1.GuardMappingList.add(grd3T1_Out_V_S1);


        // --------------guard 4-------------------------------------------------------
        Condition T1_Out_V_S1_Ct41 = new Condition(T1_Out_V_S1, "P_LaneOut_Int1_V_S1", TransitionCondition.HaveCar);
        Condition T1_Out_V_S1_Ct42 = new Condition(T1_Out_V_S1, "P_LaneDonici_V_In_S1", TransitionCondition.NotNull);
        T1_Out_V_S1_Ct41.SetNextCondition(LogicConnector.AND, T1_Out_V_S1_Ct42);
        GuardMapping grd4T1_Out_V_S1 = new GuardMapping();
        grd4T1_Out_V_S1.condition = T1_Out_V_S1_Ct41;
        grd4T1_Out_V_S1.Activations.add(new Activation(T1_Out_V_S1, "P_LaneOut_Int1_V_S1", TransitionOperation.PopElementWithoutTarget, "P_LaneOut_V_S1"));
        grd4T1_Out_V_S1.Activations.add(new Activation(T1_Out_V_S1, "P_LaneDonici_V_In_S1", TransitionOperation.Move, "P_LaneOut_V_S1"));
        T1_Out_V_S1.GuardMappingList.add(grd4T1_Out_V_S1);

        T1_Out_V_S1.Delay = 0;
        pn.Transitions.add(T1_Out_V_S1);

        //----------------------------END T1_V_S1----------------------------------------

        DataCar P_LaneDonici_V_Out_S1 = new DataCar();
        P_LaneDonici_V_Out_S1.SetName("P_LaneDonici_V_Out_S1");
        pn.PlaceList.add(P_LaneDonici_V_Out_S1);

        DataCarQueue P_LaneOut_Int2_V_S1 = new DataCarQueue();
        P_LaneOut_Int2_V_S1.SetName("P_LaneOut_Int2_V_S1");
        P_LaneOut_Int2_V_S1.Value.Size = 3;
        pn.PlaceList.add(P_LaneOut_Int2_V_S1);

        //----------------------------T3_V_S1---------------------------------------- T109

        PetriTransition T3_Out_V_S1 = new PetriTransition(pn);
        T3_Out_V_S1.TransitionName = "T3_Out_V_S1";
        T3_Out_V_S1.InputPlaceName.add("P_LaneOut_Int2_V_S1");

        // --------------guard 1-------------------------------------------------------
        Condition T3_Out_V_S1_Ct11 = new Condition(T3_Out_V_S1, "P_LaneOut_Int2_V_S1", TransitionCondition.HaveCarForMe);
        Condition T3_Out_V_S1_Ct12 = new Condition(T3_Out_V_S1, "P_LaneOut_Int1_V_S1", TransitionCondition.CanAddCars);
        GuardMapping grd1T3_Out_V_S1 = new GuardMapping();
        T3_Out_V_S1_Ct11.SetNextCondition(LogicConnector.AND, T3_Out_V_S1_Ct12);
        grd1T3_Out_V_S1.condition= T3_Out_V_S1_Ct11;
        grd1T3_Out_V_S1.Activations.add(new Activation(T3_Out_V_S1, "P_LaneOut_Int2_V_S1", TransitionOperation.PopElementWithTargetToQueue, "P_LaneOut_Int1_V_S1"));
        T3_Out_V_S1.GuardMappingList.add(grd1T3_Out_V_S1);
        T3_Out_V_S1.Delay = 0;
        pn.Transitions.add(T3_Out_V_S1);

        //----------------------------END T3_V_S1----------------------------------------

        //----------------------------T5_V_S1---------------------------------------- T2

        PetriTransition T5_Out_V_S1 = new PetriTransition(pn);
        T5_Out_V_S1.TransitionName = "T5_Out_V_S1";
        T5_Out_V_S1.InputPlaceName.add("P_LaneOut_Int2_V_S1");

        // --------------guard 1-------------------------------------------------------
        Condition T5_Out_V_S1_Ct11 = new Condition(T5_Out_V_S1, "P_LaneOut_Int2_V_S1", TransitionCondition.HaveCarForMe);
        GuardMapping grd1T5_Out_V_S1 = new GuardMapping();
        grd1T5_Out_V_S1.condition= T5_Out_V_S1_Ct11;
        grd1T5_Out_V_S1.Activations.add(new Activation(T5_Out_V_S1, "P_LaneOut_Int2_V_S1", TransitionOperation.PopElementWithTarget, "P_LaneDonici_V_Out_S1"));
        T5_Out_V_S1.GuardMappingList.add(grd1T5_Out_V_S1);
        T5_Out_V_S1.Delay = 0;
        pn.Transitions.add(T5_Out_V_S1);

        //----------------------------END T5_V_S1----------------------------------------

        DataCarQueue P_LaneOut_Int3_V_S1 = new DataCarQueue();
        P_LaneOut_Int3_V_S1.SetName("P_LaneOut_Int3_V_S1");
        P_LaneOut_Int3_V_S1.Value.Size = 3;
        pn.PlaceList.add(P_LaneOut_Int3_V_S1);

        DataCar P_LaneGhDonici_V_In_S1 = new DataCar();
        P_LaneGhDonici_V_In_S1.SetName("P_LaneGhDonici_V_In_S1");
        pn.PlaceList.add(P_LaneGhDonici_V_In_S1);

        //----------------------------T7_V_S1---------------------------------------- T6

        PetriTransition T7_Out_V_S1 = new PetriTransition(pn);
        T7_Out_V_S1.TransitionName = "T7_Out_V_S1";
        T7_Out_V_S1.InputPlaceName.add("P_LaneOut_Int3_V_S1");
        T7_Out_V_S1.InputPlaceName.add("P_LaneGhDonici_V_In_S1");

        // --------------guard 1-------------------------------------------------------OK
        Condition T7_Out_V_S1_Ct11 = new Condition(T7_Out_V_S1, "P_LaneOut_Int3_V_S1", TransitionCondition.HaveCar);
        Condition T7_Out_V_S1_Ct12 = new Condition(T7_Out_V_S1, "P_LaneGhDonici_V_In_S1", TransitionCondition.IsNull);
        Condition T7_Out_V_S1_Ct13 = new Condition(T7_Out_V_S1, "P_LaneOut_Int2_V_S1", TransitionCondition.CanAddCars);
        T7_Out_V_S1_Ct12.SetNextCondition(LogicConnector.AND, T7_Out_V_S1_Ct13);
        T7_Out_V_S1_Ct11.SetNextCondition(LogicConnector.AND, T7_Out_V_S1_Ct12);
        GuardMapping grd1T7_Out_V_S1 = new GuardMapping();
        grd1T7_Out_V_S1.condition = T7_Out_V_S1_Ct11;
        grd1T7_Out_V_S1.Activations.add(new Activation(T7_Out_V_S1, "P_LaneOut_Int3_V_S1", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int2_V_S1"));
        T7_Out_V_S1.GuardMappingList.add(grd1T7_Out_V_S1);

        // --------------guard 2-------------------------------------------------------OK with new condition DontHaveCar
        Condition T7_Out_V_S1_Ct21 = new Condition(T7_Out_V_S1, "P_LaneOut_Int3_V_S1", TransitionCondition.DontHaveCar);
        Condition T7_Out_V_S1_Ct22 = new Condition(T7_Out_V_S1, "P_LaneGhDonici_V_In_S1", TransitionCondition.NotNull);
        Condition T7_Out_V_S1_Ct23 = new Condition(T7_Out_V_S1, "P_LaneOut_Int2_V_S1", TransitionCondition.CanAddCars);
        T7_Out_V_S1_Ct22.SetNextCondition(LogicConnector.AND, T7_Out_V_S1_Ct23);
        T7_Out_V_S1_Ct21.SetNextCondition(LogicConnector.AND, T7_Out_V_S1_Ct22);
        GuardMapping grd2T7_Out_V_S1 = new GuardMapping();
        grd2T7_Out_V_S1.condition = T7_Out_V_S1_Ct21;
        grd2T7_Out_V_S1.Activations.add(new Activation(T7_Out_V_S1, "P_LaneGhDonici_V_In_S1", TransitionOperation.AddElement, "P_LaneOut_Int2_V_S1"));
        T7_Out_V_S1.GuardMappingList.add(grd2T7_Out_V_S1);

        // --------------guard 3-------------------------------------------------------
        Condition T7_Out_V_S1_Ct31 = new Condition(T7_Out_V_S1, "P_LaneOut_Int3_V_S1", TransitionCondition.HaveCar);
        Condition T7_Out_V_S1_Ct32 = new Condition(T7_Out_V_S1, "P_LaneGhDonici_V_In_S1", TransitionCondition.IsPriorityCar);
        Condition T7_Out_V_S1_Ct33 = new Condition(T7_Out_V_S1, "P_LaneOut_Int2_V_S1", TransitionCondition.CanAddCars);
        T7_Out_V_S1_Ct32.SetNextCondition(LogicConnector.AND, T7_Out_V_S1_Ct33);
        T7_Out_V_S1_Ct31.SetNextCondition(LogicConnector.AND, T7_Out_V_S1_Ct32);
        GuardMapping grd3T7_Out_V_S1 = new GuardMapping();
        grd3T7_Out_V_S1.condition = T7_Out_V_S1_Ct31;
        grd3T7_Out_V_S1.Activations.add(new Activation(T7_Out_V_S1, "P_LaneGhDonici_V_In_S1", TransitionOperation.AddElement, "P_LaneOut_Int2_V_S1"));
        grd3T7_Out_V_S1.Activations.add(new Activation(T7_Out_V_S1, "P_LaneOut_Int3_V_S1", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int2_V_S1"));
        T7_Out_V_S1.GuardMappingList.add(grd3T7_Out_V_S1);


        // --------------guard 4-------------------------------------------------------
        Condition T7_Out_V_S1_Ct41 = new Condition(T7_Out_V_S1, "P_LaneOut_Int3_V_S1", TransitionCondition.HaveCar);
        Condition T7_Out_V_S1_Ct42 = new Condition(T7_Out_V_S1, "P_LaneGhDonici_V_In_S1", TransitionCondition.NotNull);
        Condition T7_Out_V_S1_Ct43 = new Condition(T7_Out_V_S1, "P_LaneOut_Int2_V_S1", TransitionCondition.CanAddCars);
        T7_Out_V_S1_Ct42.SetNextCondition(LogicConnector.AND, T7_Out_V_S1_Ct43);
        T7_Out_V_S1_Ct41.SetNextCondition(LogicConnector.AND, T7_Out_V_S1_Ct42);
        GuardMapping grd4T7_Out_V_S1 = new GuardMapping();
        grd4T7_Out_V_S1.condition = T7_Out_V_S1_Ct41;
        grd4T7_Out_V_S1.Activations.add(new Activation(T7_Out_V_S1, "P_LaneOut_Int3_V_S1", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int2_V_S1"));
        grd4T7_Out_V_S1.Activations.add(new Activation(T7_Out_V_S1, "P_LaneGhDonici_V_In_S1", TransitionOperation.AddElement, "P_LaneOut_Int2_V_S1"));
        T7_Out_V_S1.GuardMappingList.add(grd4T7_Out_V_S1);

        T7_Out_V_S1.Delay = 0;
        pn.Transitions.add(T7_Out_V_S1);

        //----------------------------END T7_V_S1----------------------------------------

        DataCar P_LaneGhDonici_V_Out_S1 = new DataCar();
        P_LaneGhDonici_V_Out_S1.SetName("P_LaneGhDonici_V_Out_S1");
        pn.PlaceList.add(P_LaneGhDonici_V_Out_S1);

        DataCarQueue P_LaneOut_Int4_V_S1 = new DataCarQueue();
        P_LaneOut_Int4_V_S1.SetName("P_LaneOut_Int4_V_S1");
        P_LaneOut_Int4_V_S1.Value.Size = 3;
        pn.PlaceList.add(P_LaneOut_Int4_V_S1);

        //----------------------------T9_V_S1---------------------------------------- T110

        PetriTransition T9_Out_V_S1 = new PetriTransition(pn);
        T9_Out_V_S1.TransitionName = "T9_Out_V_S1";
        T9_Out_V_S1.InputPlaceName.add("P_LaneOut_Int4_V_S1");

        // --------------guard 1-------------------------------------------------------
        Condition T9_Out_V_S1_Ct11 = new Condition(T9_Out_V_S1, "P_LaneOut_Int4_V_S1", TransitionCondition.HaveCarForMe);
        Condition T9_Out_V_S1_Ct12 = new Condition(T9_Out_V_S1, "P_LaneOut_Int3_V_S1", TransitionCondition.CanAddCars);
        GuardMapping grd1T9_Out_V_S1 = new GuardMapping();
        T9_Out_V_S1_Ct11.SetNextCondition(LogicConnector.AND, T9_Out_V_S1_Ct12);
        grd1T9_Out_V_S1.condition= T9_Out_V_S1_Ct11;
        grd1T9_Out_V_S1.Activations.add(new Activation(T9_Out_V_S1, "P_LaneOut_Int4_V_S1", TransitionOperation.PopElementWithTargetToQueue, "P_LaneOut_Int3_V_S1"));
        T9_Out_V_S1.GuardMappingList.add(grd1T9_Out_V_S1);
        T9_Out_V_S1.Delay = 0;
        pn.Transitions.add(T9_Out_V_S1);

        //----------------------------END T9_V_S1----------------------------------------

        //----------------------------T11_V_S1---------------------------------------- T7

        PetriTransition T11_Out_V_S1 = new PetriTransition(pn);
        T11_Out_V_S1.TransitionName = "T11_Out_V_S1";
        T11_Out_V_S1.InputPlaceName.add("P_LaneOut_Int4_V_S1");

        // --------------guard 1-------------------------------------------------------
        Condition T11_Out_V_S1_Ct11 = new Condition(T11_Out_V_S1, "P_LaneOut_Int4_V_S1", TransitionCondition.HaveCarForMe);
        GuardMapping grd1T11_Out_V_S1 = new GuardMapping();
        grd1T11_Out_V_S1.condition= T11_Out_V_S1_Ct11;
        grd1T11_Out_V_S1.Activations.add(new Activation(T11_Out_V_S1, "P_LaneOut_Int4_V_S1", TransitionOperation.PopElementWithTarget, "P_LaneGhDonici_V_Out_S1"));
        T11_Out_V_S1.GuardMappingList.add(grd1T11_Out_V_S1);
        T11_Out_V_S1.Delay = 0;
        pn.Transitions.add(T11_Out_V_S1);

        //----------------------------END T11_V_S1----------------------------------------

        DataCarQueue P_LaneOut_Int5_V_S1 = new DataCarQueue();
        P_LaneOut_Int5_V_S1.SetName("P_LaneOut_Int5_V_S1");
        P_LaneOut_Int5_V_S1.Value.Size = 3;
        pn.PlaceList.add(P_LaneOut_Int5_V_S1);

        DataCarQueue P_BusStation_Sebastian_V_Out_S1 = new DataCarQueue();
        P_BusStation_Sebastian_V_Out_S1.SetName("P_BusStation_Sebastian_V_Out_S1");
        P_BusStation_Sebastian_V_Out_S1.Value.Size = 2;
        pn.PlaceList.add(P_BusStation_Sebastian_V_Out_S1);

        //----------------------------T13_V_S1---------------------------------------- T85

        PetriTransition T13_Out_V_S1 = new PetriTransition(pn);
        T13_Out_V_S1.TransitionName = "T13_Out_V_S1";
        T13_Out_V_S1.InputPlaceName.add("P_LaneOut_Int5_V_S1");
        T13_Out_V_S1.InputPlaceName.add("P_BusStation_Sebastian_V_Out_S1");

        // --------------guard 1-------------------------------------------------------OK
        Condition T13_Out_V_S1_Ct11 = new Condition(T13_Out_V_S1, "P_LaneOut_Int5_V_S1", TransitionCondition.HaveCar);
        Condition T13_Out_V_S1_Ct12 = new Condition(T13_Out_V_S1, "P_BusStation_Sebastian_V_Out_S1", TransitionCondition.DontHaveBus);
        Condition T13_Out_V_S1_Ct13 = new Condition(T13_Out_V_S1, "P_LaneOut_Int4_V_S1", TransitionCondition.CanAddCars);
        T13_Out_V_S1_Ct12.SetNextCondition(LogicConnector.AND, T13_Out_V_S1_Ct13);
        T13_Out_V_S1_Ct11.SetNextCondition(LogicConnector.AND, T13_Out_V_S1_Ct12);
        GuardMapping grd1T13_Out_V_S1 = new GuardMapping();
        grd1T13_Out_V_S1.condition = T13_Out_V_S1_Ct11;
        grd1T13_Out_V_S1.Activations.add(new Activation(T13_Out_V_S1, "P_LaneOut_Int5_V_S1", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int4_V_S1"));
        T13_Out_V_S1.GuardMappingList.add(grd1T13_Out_V_S1);

        // --------------guard 2-------------------------------------------------------OK with new condition DontHaveCar
        Condition T13_Out_V_S1_Ct21 = new Condition(T13_Out_V_S1, "P_LaneOut_Int5_V_S1", TransitionCondition.DontHaveCar);
        Condition T13_Out_V_S1_Ct22 = new Condition(T13_Out_V_S1, "P_BusStation_Sebastian_V_Out_S1", TransitionCondition.HaveBus);
        Condition T13_Out_V_S1_Ct23 = new Condition(T13_Out_V_S1, "P_LaneOut_Int4_V_S1", TransitionCondition.CanAddCars);
        T13_Out_V_S1_Ct22.SetNextCondition(LogicConnector.AND, T13_Out_V_S1_Ct23);
        T13_Out_V_S1_Ct21.SetNextCondition(LogicConnector.AND, T13_Out_V_S1_Ct22);
        GuardMapping grd2T13_Out_V_S1 = new GuardMapping();
        grd2T13_Out_V_S1.condition = T13_Out_V_S1_Ct21;
        grd2T13_Out_V_S1.Activations.add(new Activation(T13_Out_V_S1, "P_BusStation_Sebastian_V_Out_S1", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int4_V_S1"));
        T13_Out_V_S1.GuardMappingList.add(grd2T13_Out_V_S1);

        // --------------guard 3-------------------------------------------------------
        Condition T13_Out_V_S1_Ct31 = new Condition(T13_Out_V_S1, "P_LaneOut_Int5_V_S1", TransitionCondition.HavePriorityCar);
        Condition T13_Out_V_S1_Ct32 = new Condition(T13_Out_V_S1, "P_BusStation_Sebastian_V_Out_S1", TransitionCondition.HaveBus);
        Condition T13_Out_V_S1_Ct33 = new Condition(T13_Out_V_S1, "P_LaneOut_Int4_V_S1", TransitionCondition.CanAddCars);
        T13_Out_V_S1_Ct32.SetNextCondition(LogicConnector.AND, T13_Out_V_S1_Ct33);
        T13_Out_V_S1_Ct31.SetNextCondition(LogicConnector.AND, T13_Out_V_S1_Ct32);
        GuardMapping grd3T13_Out_V_S1 = new GuardMapping();
        grd3T13_Out_V_S1.condition = T13_Out_V_S1_Ct31;
        grd3T13_Out_V_S1.Activations.add(new Activation(T13_Out_V_S1, "P_LaneOut_Int5_V_S1", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int4_V_S1"));
        grd3T13_Out_V_S1.Activations.add(new Activation(T13_Out_V_S1, "P_BusStation_Sebastian_V_Out_S1", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int4_V_S1"));
        T13_Out_V_S1.GuardMappingList.add(grd3T13_Out_V_S1);


        // --------------guard 4-------------------------------------------------------
        Condition T13_Out_V_S1_Ct41 = new Condition(T13_Out_V_S1, "P_LaneOut_Int5_V_S1", TransitionCondition.HaveCar);
        Condition T13_Out_V_S1_Ct42 = new Condition(T13_Out_V_S1, "P_BusStation_Sebastian_V_Out_S1", TransitionCondition.HaveBus);
        Condition T13_Out_V_S1_Ct43 = new Condition(T13_Out_V_S1, "P_LaneOut_Int4_V_S1", TransitionCondition.CanAddCars);
        T13_Out_V_S1_Ct42.SetNextCondition(LogicConnector.AND, T13_Out_V_S1_Ct43);
        T13_Out_V_S1_Ct41.SetNextCondition(LogicConnector.AND, T13_Out_V_S1_Ct42);
        GuardMapping grd4T13_Out_V_S1 = new GuardMapping();
        grd4T13_Out_V_S1.condition = T13_Out_V_S1_Ct41;
        grd4T13_Out_V_S1.Activations.add(new Activation(T13_Out_V_S1, "P_BusStation_Sebastian_V_Out_S1", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int4_V_S1"));
        grd4T13_Out_V_S1.Activations.add(new Activation(T13_Out_V_S1, "P_LaneOut_Int5_V_S1", TransitionOperation.PopElementWithoutTargetToQueue, "P_LaneOut_Int4_V_S1"));
        T13_Out_V_S1.GuardMappingList.add(grd4T13_Out_V_S1);

        T13_Out_V_S1.Delay = 0;
        pn.Transitions.add(T13_Out_V_S1);

        //----------------------------END T13_V_S1----------------------------------------

        DataCarQueue P_BusStation_Sebastian_V_S1 = new DataCarQueue();
        P_BusStation_Sebastian_V_S1.SetName("P_BusStation_Sebastian_V_S1");
        P_BusStation_Sebastian_V_S1.Value.Size = 2;
        pn.PlaceList.add(P_BusStation_Sebastian_V_S1);

        //----------------------------T15_V_S1---------------------------------------- T88

        PetriTransition T15_Out_V_S1 = new PetriTransition(pn);
        T15_Out_V_S1.TransitionName = "T15_Out_V_S1";
        T15_Out_V_S1.InputPlaceName.add("P_BusStation_Sebastian_V_S1");

        // --------------guard 1-------------------------------------------------------OK
        Condition T15_Out_V_S1_Ct11 = new Condition(T15_Out_V_S1, "P_BusStation_Sebastian_V_S1", TransitionCondition.HaveBus);
        Condition T15_Out_V_S1_Ct12 = new Condition(T15_Out_V_S1, "P_BusStation_Sebastian_V_Out_S1", TransitionCondition.CanAddCars);
        T15_Out_V_S1_Ct11.SetNextCondition(LogicConnector.AND, T15_Out_V_S1_Ct12);
        GuardMapping grd1T15_Out_V_S1 = new GuardMapping();
        grd1T15_Out_V_S1.condition = T15_Out_V_S1_Ct11;
        grd1T15_Out_V_S1.Activations.add(new Activation(T15_Out_V_S1, "P_BusStation_Sebastian_V_S1", TransitionOperation.PopElementWithoutTargetToQueue, "P_BusStation_Sebastian_V_Out_S1"));
        T15_Out_V_S1.GuardMappingList.add(grd1T15_Out_V_S1);

        T15_Out_V_S1.Delay = 10;
        pn.Transitions.add(T15_Out_V_S1);

        //----------------------------END T15_V_S1----------------------------------------

        DataCarQueue P_O_Lane_V_S1 = new DataCarQueue();
        P_O_Lane_V_S1.Value.Size = 3;
        P_O_Lane_V_S1.SetName("P_O_Lane_V_S1");
        pn.PlaceList.add(P_O_Lane_V_S1);

        //----------------------------T17_V_S1---------------------------------------- T111

        PetriTransition T17_Out_V_S1 = new PetriTransition(pn);
        T17_Out_V_S1.TransitionName = "T17_Out_V_S1";
        T17_Out_V_S1.InputPlaceName.add("P_O_Lane_V_S1");

        // --------------guard 1-------------------------------------------------------OK
        Condition T17_Out_V_S1_Ct11 = new Condition(T17_Out_V_S1, "P_O_Lane_V_S1", TransitionCondition.HaveBusForMe);
        Condition T17_Out_V_S1_Ct12 = new Condition(T17_Out_V_S1, "P_BusStation_Sebastian_V_S1", TransitionCondition.CanAddCars);
        T17_Out_V_S1_Ct11.SetNextCondition(LogicConnector.AND, T17_Out_V_S1_Ct12);
        GuardMapping grd1T17_Out_V_S1 = new GuardMapping();
        grd1T17_Out_V_S1.condition = T17_Out_V_S1_Ct11;
        grd1T17_Out_V_S1.Activations.add(new Activation(T17_Out_V_S1, "P_O_Lane_V_S1", TransitionOperation.PopElementWithTargetToQueue, "P_BusStation_Sebastian_V_S1"));
        T17_Out_V_S1.GuardMappingList.add(grd1T17_Out_V_S1);

        T17_Out_V_S1.Delay = 0;
        pn.Transitions.add(T17_Out_V_S1);

        //----------------------------END T17_V_S1----------------------------------------

        //----------------------------T19_V_S1---------------------------------------- T_ge_CarLane1_V

        PetriTransition T19_Out_V_S1 = new PetriTransition(pn);
        T19_Out_V_S1.TransitionName = "T19_Out_V_S1";
        T19_Out_V_S1.InputPlaceName.add("P_O_Lane_V_S1");

        // --------------guard 1-------------------------------------------------------OK
        Condition T19_Out_V_S1_Ct11 = new Condition(T19_Out_V_S1, "P_O_Lane_V_S1", TransitionCondition.HaveCarForMe);
        Condition T19_Out_V_S1_Ct12 = new Condition(T19_Out_V_S1, "P_LaneOut_Int5_V_S1", TransitionCondition.CanAddCars);
        T19_Out_V_S1_Ct11.SetNextCondition(LogicConnector.AND, T19_Out_V_S1_Ct12);
        GuardMapping grd1T19_Out_V_S1 = new GuardMapping();
        grd1T19_Out_V_S1.condition = T19_Out_V_S1_Ct11;
        grd1T19_Out_V_S1.Activations.add(new Activation(T19_Out_V_S1, "P_O_Lane_V_S1", TransitionOperation.PopElementWithTargetToQueue, "P_LaneOut_Int5_V_S1"));
        T19_Out_V_S1.GuardMappingList.add(grd1T19_Out_V_S1);

        T19_Out_V_S1.Delay = 0;
        pn.Transitions.add(T19_Out_V_S1);

        //----------------------------END T19_V_S1----------------------------------------

        //----------------------------T21_V_S1---------------------------------------- T_g_CarLane1_V

        PetriTransition T21_Out_V_S1 = new PetriTransition(pn);
        T21_Out_V_S1.TransitionName = "T21_Out_V_S1";
        T21_Out_V_S1.InputPlaceName.add("P_I_S1");
        T21_Out_V_S1.InputPlaceName.add("P_O_Lane_V_S1");
        T21_Out_V_S1.InputPlaceName.add("P_PTL_V_S1");

        // --------------guard 1-------------------------------------------------------OK
        Condition T21_Out_V_S1_Ct11 = new Condition(T21_Out_V_S1, "P_I_S1", TransitionCondition.HavePriorityCarForMe);
        Condition T21_Out_V_S1_Ct12 = new Condition(T21_Out_V_S1, "P_O_Lane_V_S1", TransitionCondition.CanAddCars);
        T21_Out_V_S1_Ct11.SetNextCondition(LogicConnector.AND, T21_Out_V_S1_Ct12);
        GuardMapping grd1T21_Out_V_S1 = new GuardMapping();
        grd1T21_Out_V_S1.condition = T21_Out_V_S1_Ct11;
        grd1T21_Out_V_S1.Activations.add(new Activation(T21_Out_V_S1, "P_I_S1", TransitionOperation.PopElementWithTargetToQueue, "P_O_Lane_V_S1"));
        T21_Out_V_S1.GuardMappingList.add(grd1T21_Out_V_S1);

        // --------------guard 2-------------------------------------------------------OK
        Condition T21_Out_V_S1_Ct21 = new Condition(T21_Out_V_S1, "P_I_S1", TransitionCondition.HaveCarForMe);
        Condition T21_Out_V_S1_Ct22 = new Condition(T21_Out_V_S1, "P_O_Lane_V_S1", TransitionCondition.CanAddCars);
        Condition T21_Out_V_S1_Ct23 = new Condition(T21_Out_V_S1, "P_PTL_V_S1", TransitionCondition.Equal, "red");
        T21_Out_V_S1_Ct22.SetNextCondition(LogicConnector.AND, T21_Out_V_S1_Ct23);
        T21_Out_V_S1_Ct21.SetNextCondition(LogicConnector.AND, T21_Out_V_S1_Ct22);
        GuardMapping grd2T21_Out_V_S1 = new GuardMapping();
        grd2T21_Out_V_S1.condition = T21_Out_V_S1_Ct21;
        grd2T21_Out_V_S1.Activations.add(new Activation(T21_Out_V_S1, "P_I_S1", TransitionOperation.PopElementWithTargetToQueue, "P_O_Lane_V_S1"));
        T21_Out_V_S1.GuardMappingList.add(grd2T21_Out_V_S1);

        T21_Out_V_S1.Delay = 0;
        pn.Transitions.add(T21_Out_V_S1);

        //----------------------------END T21_V_S1----------------------------------------

        //------------------NORTH--------------------------
        //-------------------IN---------------------------
        DataCar P_LaneIn_N_S1   = new DataCar();
        P_LaneIn_N_S1.SetName("P_LaneIn_N_S1");
        pn.PlaceList.add(P_LaneIn_N_S1);

        DataCarQueue P_x_Lane_N_S1 = new DataCarQueue();
        P_x_Lane_N_S1.Value.Size = 3;
        P_x_Lane_N_S1.SetName("P_x_Lane_N_S1");
        pn.PlaceList.add(P_x_Lane_N_S1);

        //------------------------------T0_N_S1-------------------------------------------- //T_u_Car1_N
        PetriTransition T0_In_N_S1 = new PetriTransition(pn);
        T0_In_N_S1.TransitionName = "T0_In_N_S1";
        T0_In_N_S1.InputPlaceName.add("P_LaneIn_N_S1");
        T0_In_N_S1.InputPlaceName.add("P_x_Lane_N_S1");

        Condition T0_In_N_S1_Ct11 = new Condition(T0_In_N_S1, "P_LaneIn_N_S1", TransitionCondition.NotNull);
        Condition T0_In_N_S1_Ct12 = new Condition(T0_In_N_S1, "P_x_Lane_N_S1", TransitionCondition.CanAddCars);
        T0_In_N_S1_Ct11.SetNextCondition(LogicConnector.AND, T0_In_N_S1_Ct12);

        GuardMapping grd1T0_In_N_S1 = new GuardMapping();
        grd1T0_In_N_S1.condition = T0_In_N_S1_Ct11;
        grd1T0_In_N_S1.Activations.add(new Activation(T0_In_N_S1, "P_LaneIn_N_S1", TransitionOperation.AddElement, "P_x_Lane_N_S1"));
        T0_In_N_S1.GuardMappingList.add(grd1T0_In_N_S1);

        T0_In_N_S1.Delay = 0;
        pn.Transitions.add(T0_In_N_S1);
        //---------------------------- END T0_N_S1----------------------------------------

        DataCar P_b_Lane_N_S1 = new DataCar();
        P_b_Lane_N_S1.SetName("P_b_Lane_N_S1");
        pn.PlaceList.add(P_b_Lane_N_S1);

        //------------------------------T2_N_S1-------------------------------------------- //T_e_Car1_N
        PetriTransition T2_In_N_S1 = new PetriTransition(pn);
        T2_In_N_S1.TransitionName = "T2_In_N_S1";
        T2_In_N_S1.InputPlaceName.add("P_x_Lane_N_S1");
        T2_In_N_S1.InputPlaceName.add("P_TL_N_S1");
        T2_In_N_S1.InputPlaceName.add("UserReq_N_S1");
        T2_In_N_S1.InputPlaceName.add("P_PTL_N_S1");

        //------------------------guard 3------------------------------------------------------
        Condition T2_In_N_S1_C31 = new Condition(T2_In_N_S1, "P_x_Lane_N_S1", TransitionCondition.HavePriorityCar);
        GuardMapping grd3T2_In_N_S1 = new GuardMapping();
        grd3T2_In_N_S1.condition= T2_In_N_S1_C31;
        grd3T2_In_N_S1.Activations.add(new Activation(T2_In_N_S1, "P_x_Lane_N_S1", TransitionOperation.PopElementWithoutTarget, "P_b_Lane_N_S1"));
        grd3T2_In_N_S1.Activations.add(new Activation(T2_In_N_S1, "P_TL_N_S1", TransitionOperation.Move, "P_TL_N_S1"));
        grd3T2_In_N_S1.Activations.add(new Activation(T2_In_N_S1, "P_PTL_N_S1", TransitionOperation.Move, "P_PTL_N_S1"));

        T2_In_N_S1.GuardMappingList.add(grd3T2_In_N_S1);

        //-----------------------guard1---------------------------------------------------

        Condition T2_In_N_S1_Ct11 = new Condition(T2_In_N_S1, "P_TL_N_S1", TransitionCondition.Equal,"green");
        Condition T2_In_N_S1_Ct12 = new Condition(T2_In_N_S1, "P_x_Lane_N_S1", TransitionCondition.HaveCar);
        T2_In_N_S1_Ct11.SetNextCondition(LogicConnector.AND, T2_In_N_S1_Ct12);

        GuardMapping grd1T2_In_N_S1 = new GuardMapping();
        grd1T2_In_N_S1.condition= T2_In_N_S1_Ct11;
        grd1T2_In_N_S1.Activations.add(new Activation(T2_In_N_S1, "P_x_Lane_N_S1", TransitionOperation.PopElementWithoutTarget, "P_b_Lane_N_S1"));
        grd1T2_In_N_S1.Activations.add(new Activation(T2_In_N_S1, "P_TL_N_S1", TransitionOperation.Move, "P_TL_N_S1"));
        grd1T2_In_N_S1.Activations.add(new Activation(T2_In_N_S1, "P_PTL_N_S1", TransitionOperation.Move, "P_PTL_N_S1"));
        T2_In_N_S1.GuardMappingList.add(grd1T2_In_N_S1);

        //-----------------------guard2---------------------------------------------------
        Condition T2_In_N_S1_Ct13 = new Condition(T2_In_N_S1, "UserReq_N_S1", TransitionCondition.NotNull);

        GuardMapping grd2T2_In_N_S1 = new GuardMapping();
        grd2T2_In_N_S1.condition = T2_In_N_S1_Ct13;

        grd2T2_In_N_S1.Activations.add(new Activation(T2_In_N_S1, "P_TL_N_S1", TransitionOperation.Move, "P_TL_N_S1"));
        grd2T2_In_N_S1.Activations.add(new Activation(T2_In_N_S1, "P_PTL_N_S1", TransitionOperation.Move, "P_PTL_N_S1"));
        grd2T2_In_N_S1.Activations.add(new Activation(T2_In_N_S1, "UserReq_N_S1", TransitionOperation.SendOverNetwork, "OP_Req_N_S1"));

        T2_In_N_S1.GuardMappingList.add(grd2T2_In_N_S1);

        T2_In_N_S1.Delay = 0;
        pn.Transitions.add(T2_In_N_S1);
        //---------------------------- END T2_N_S1----------------------------------------

        //-----------------------------T4_N_S1-------------------------------------------//T_I_Car1_N
        PetriTransition T4_In_N_S1 = new PetriTransition(pn);
        T4_In_N_S1.TransitionName = "T4_In_N_S1";
        T4_In_N_S1.InputPlaceName.add("P_b_Lane_N_S1");
        T4_In_N_S1.InputPlaceName.add("P_I_S1");

        Condition T4_In_N_S1_Ct11 = new Condition(T4_In_N_S1, "P_b_Lane_N_S1", TransitionCondition.NotNull);
        Condition T4_In_N_S1_Ct12 = new Condition(T4_In_N_S1, "P_I_S1", TransitionCondition.CanAddCars);
        T4_In_N_S1_Ct11.SetNextCondition(LogicConnector.AND, T4_In_N_S1_Ct12);

        GuardMapping grd1T4_In_N_S1 = new GuardMapping();
        grd1T4_In_N_S1.condition = T4_In_N_S1_Ct11;
        grd1T4_In_N_S1.Activations.add(new Activation(T4_In_N_S1, "P_b_Lane_N_S1", TransitionOperation.AddElement, "P_I_S1"));
        T4_In_N_S1.GuardMappingList.add(grd1T4_In_N_S1);

        T4_In_N_S1.Delay = 0;
        pn.Transitions.add(T4_In_N_S1);
        //---------------------------- END T4_N_S1----------------------------------------

        //-------------------OUT---------------------------
        DataCarQueue P_O_Lane_N_S1 = new DataCarQueue();
        P_O_Lane_N_S1.Value.Size = 3;
        P_O_Lane_N_S1.SetName("P_O_Lane_N_S1");
        pn.PlaceList.add(P_O_Lane_N_S1);

        DataCar P_Oe_Lane_N_S1 = new DataCar();
        P_Oe_Lane_N_S1.SetName("P_Oe_Lane_N_S1");
        pn.PlaceList.add(P_Oe_Lane_N_S1);

        //----------------------------T1_N_S1---------------------------------------- T_ge_CarLane1_N

        PetriTransition T1_Out_N_S1 = new PetriTransition(pn);
        T1_Out_N_S1.TransitionName = "T1_Out_N_S1";
        T1_Out_N_S1.InputPlaceName.add("P_O_Lane_N_S1");

        // --------------guard 1-------------------------------------------------------OK
        Condition T1_Out_N_S1_Ct11 = new Condition(T1_Out_N_S1, "P_O_Lane_N_S1", TransitionCondition.HaveCar);
        GuardMapping grd1T1_Out_N_S1 = new GuardMapping();
        grd1T1_Out_N_S1.condition = T1_Out_N_S1_Ct11;
        grd1T1_Out_N_S1.Activations.add(new Activation(T1_Out_N_S1, "P_O_Lane_N_S1", TransitionOperation.PopElementWithoutTarget, "P_Oe_Lane_N_S1"));
        T1_Out_N_S1.GuardMappingList.add(grd1T1_Out_N_S1);

        T1_Out_N_S1.Delay = 0;
        pn.Transitions.add(T1_Out_N_S1);

        //----------------------------END T1_N_S1----------------------------------------

        //----------------------------T3_N_S1---------------------------------------- T_g_CarLane1_N

        PetriTransition T3_Out_N_S1 = new PetriTransition(pn);
        T3_Out_N_S1.TransitionName = "T3_Out_N_S1";
        T3_Out_N_S1.InputPlaceName.add("P_I_S1");
        T3_Out_N_S1.InputPlaceName.add("P_O_Lane_N_S1");
        T3_Out_N_S1.InputPlaceName.add("P_PTL_N_S1");

        // --------------guard 1-------------------------------------------------------OK
        Condition T3_Out_N_S1_Ct11 = new Condition(T3_Out_N_S1, "P_I_S1", TransitionCondition.HavePriorityCarForMe);
        Condition T3_Out_N_S1_Ct12 = new Condition(T3_Out_N_S1, "P_O_Lane_N_S1", TransitionCondition.CanAddCars);
        T3_Out_N_S1_Ct11.SetNextCondition(LogicConnector.AND, T3_Out_N_S1_Ct12);
        GuardMapping grd1T3_Out_N_S1 = new GuardMapping();
        grd1T3_Out_N_S1.condition = T3_Out_N_S1_Ct11;
        grd1T3_Out_N_S1.Activations.add(new Activation(T3_Out_N_S1, "P_I_S1", TransitionOperation.PopElementWithTargetToQueue, "P_O_Lane_N_S1"));
        T21_Out_V_S1.GuardMappingList.add(grd1T3_Out_N_S1);

        // --------------guard 2-------------------------------------------------------OK
        Condition T3_Out_N_S1_Ct21 = new Condition(T3_Out_N_S1, "P_I_S1", TransitionCondition.HaveCarForMe);
        Condition T3_Out_N_S1_Ct22 = new Condition(T3_Out_N_S1, "P_O_Lane_N_S1", TransitionCondition.CanAddCars);
        Condition T3_Out_N_S1_Ct23 = new Condition(T3_Out_N_S1, "P_PTL_N_S1", TransitionCondition.Equal, "red");
        T3_Out_N_S1_Ct22.SetNextCondition(LogicConnector.AND, T3_Out_N_S1_Ct23);
        T3_Out_N_S1_Ct21.SetNextCondition(LogicConnector.AND, T3_Out_N_S1_Ct22);
        GuardMapping grd2T3_Out_N_S1 = new GuardMapping();
        grd2T3_Out_N_S1.condition = T3_Out_N_S1_Ct21;
        grd2T3_Out_N_S1.Activations.add(new Activation(T3_Out_N_S1, "P_I_S1", TransitionOperation.PopElementWithTargetToQueue, "P_O_Lane_N_S1"));
        T21_Out_V_S1.GuardMappingList.add(grd2T3_Out_N_S1);

        T3_Out_N_S1.Delay = 0;
        pn.Transitions.add(T3_Out_N_S1);

        //----------------------------END T3_N_S1----------------------------------------

        //------------------SOUTH--------------------------
        //-------------------IN---------------------------
        DataCar P_LaneIn_int1_S_S1 = new DataCar();
        P_LaneIn_int1_S_S1.SetName("P_LaneIn_int1_S_S1");
        pn.PlaceList.add(P_LaneIn_int1_S_S1);

        DataCarQueue P_x_Lane_S_S1 = new DataCarQueue();
        P_x_Lane_S_S1.Value.Size = 6;
        P_x_Lane_S_S1.SetName("P_x_Lane_S_S1");
        pn.PlaceList.add(P_x_Lane_S_S1);

        //------------------------------T0_S_S1-------------------------------------------- //T_u_car1_S
        PetriTransition T0_In_S_S1 = new PetriTransition(pn);
        T0_In_S_S1.TransitionName = "T0_In_S_S1";
        T0_In_S_S1.InputPlaceName.add("P_LaneIn_int1_S_S1");
        T0_In_S_S1.InputPlaceName.add("P_x_Lane_S_S1");

        Condition T0_In_S_S1_Ct11 = new Condition(T0_In_S_S1, "P_LaneIn_int1_S_S1", TransitionCondition.NotNull);
        Condition T0_In_S_S1_Ct12 = new Condition(T0_In_S_S1, "P_x_Lane_S_S1", TransitionCondition.CanAddCars);
        T0_In_S_S1_Ct11.SetNextCondition(LogicConnector.AND, T0_In_S_S1_Ct12);

        GuardMapping grd1T0_In_S_S1 = new GuardMapping();
        grd1T0_In_S_S1.condition = T0_In_S_S1_Ct11;
        grd1T0_In_S_S1.Activations.add(new Activation(T0_In_S_S1, "P_LaneIn_int1_S_S1", TransitionOperation.AddElement, "P_x_Lane_S_S1"));
        T0_In_S_S1.GuardMappingList.add(grd1T0_In_S_S1);

        T0_In_S_S1.Delay = 0;
        pn.Transitions.add(T0_In_S_S1);
        //---------------------------- END T0_S_S1----------------------------------------

        //------------------------------T2_S_S1-------------------------------------------- //T_e_car1_S
        PetriTransition T2_In_S_S1 = new PetriTransition(pn);
        T2_In_S_S1.TransitionName = "T2_In_S_S1";
        T2_In_S_S1.InputPlaceName.add("P_x_Lane_S_S1");
        T2_In_S_S1.InputPlaceName.add("P_TL_S_S1");
        T2_In_S_S1.InputPlaceName.add("UserReq_S_S1");
        T2_In_S_S1.InputPlaceName.add("P_PTL_S_S1");

        //------------------------guard 3------------------------------------------------------
        Condition T2_In_S_S1_C31 = new Condition(T2_In_S_S1, "P_x_Lane_S_S1", TransitionCondition.HavePriorityCar);
        GuardMapping grd3T2_In_S_S1 = new GuardMapping();
        grd3T2_In_S_S1.condition= T2_In_S_S1_C31;
        grd3T2_In_S_S1.Activations.add(new Activation(T2_In_S_S1, "P_x_Lane_S_S1", TransitionOperation.PopElementWithoutTarget, "P_b_Lane_S_S1"));
        grd3T2_In_S_S1.Activations.add(new Activation(T2_In_S_S1, "P_TL_S_S1", TransitionOperation.Move, "P_TL_S_S1"));
        grd3T2_In_S_S1.Activations.add(new Activation(T2_In_S_S1, "P_PTL_S_S1", TransitionOperation.Move, "P_PTL_S_S1"));

        T2_In_S_S1.GuardMappingList.add(grd3T2_In_S_S1);

        //------------------------guard 1-------------------------------------------------------

        Condition T2_In_S_S1_Ct11 = new Condition(T2_In_S_S1, "P_TL_S_S1", TransitionCondition.Equal,"green");
        Condition T2_In_S_S1_Ct12 = new Condition(T2_In_S_S1, "P_x_Lane_S_S1", TransitionCondition.HaveCar);
        T2_In_S_S1_Ct11.SetNextCondition(LogicConnector.AND, T2_In_S_S1_Ct12);

        GuardMapping grd1T2_In_S_S1 = new GuardMapping();
        grd1T2_In_S_S1.condition= T2_In_S_S1_Ct11;
        grd1T2_In_S_S1.Activations.add(new Activation(T2_In_S_S1, "P_x_Lane_S_S1", TransitionOperation.PopElementWithoutTarget, "P_b_Lane_S_S1"));
        grd1T2_In_S_S1.Activations.add(new Activation(T2_In_S_S1, "P_TL_S_S1", TransitionOperation.Move, "P_TL_S_S1"));
        grd1T2_In_S_S1.Activations.add(new Activation(T2_In_S_S1, "P_PTL_S_S1", TransitionOperation.Move, "P_PTL_S_S1"));

        T2_In_S_S1.GuardMappingList.add(grd1T2_In_S_S1);
        //-----------------------guard2---------------------------------------------------
        Condition T2_In_S_S1_Ct13 = new Condition(T2_In_S_S1, "UserReq_S_S1", TransitionCondition.NotNull);

        GuardMapping grd2T2_In_S_S1 = new GuardMapping();
        grd2T2_In_S_S1.condition = T2_In_S_S1_Ct13;

        grd2T2_In_S_S1.Activations.add(new Activation(T2_In_S_S1, "P_TL_S_S1", TransitionOperation.Move, "P_TL_S_S1"));
        grd2T2_In_S_S1.Activations.add(new Activation(T2_In_S_S1, "P_PTL_S_S1", TransitionOperation.Move, "P_PTL_S_S1"));
        grd2T2_In_S_S1.Activations.add(new Activation(T2_In_S_S1, "UserReq_S_S1", TransitionOperation.SendOverNetwork, "OP_Req_S_S1"));

        T2_In_S_S1.GuardMappingList.add(grd2T2_In_S_S1);

        T2_In_S_S1.Delay = 0;
        pn.Transitions.add(T2_In_S_S1);
        //---------------------------- END T2_S_S1----------------------------------------

        DataCar P_b_Lane_S_S1 = new DataCar();
        P_b_Lane_S_S1.SetName("P_b_Lane_S_S1");
        pn.PlaceList.add(P_b_Lane_S_S1);

        //------------------------------T4_S_S1-------------------------------------------- //T_I_car1_S
        PetriTransition T4_In_S_S1 = new PetriTransition(pn);
        T4_In_S_S1.TransitionName = "T4_In_S_S1";
        T4_In_S_S1.InputPlaceName.add("P_b_Lane_S_S1");
        T4_In_S_S1.InputPlaceName.add("P_I_S1");

        Condition T4_In_S_S1_Ct11 = new Condition(T4_In_S_S1, "P_b_Lane_S_S1", TransitionCondition.NotNull);
        Condition T4_In_S_S1_Ct12 = new Condition(T4_In_S_S1, "P_I_S1", TransitionCondition.CanAddCars);
        T4_In_S_S1_Ct11.SetNextCondition(LogicConnector.AND, T4_In_S_S1_Ct12);

        GuardMapping grd1T4_In_S_S1 = new GuardMapping();
        grd1T4_In_S_S1.condition = T4_In_S_S1_Ct11;
        grd1T4_In_S_S1.Activations.add(new Activation(T4_In_S_S1, "P_b_Lane_S_S1", TransitionOperation.AddElement, "P_I_S1"));
        T4_In_S_S1.GuardMappingList.add(grd1T4_In_S_S1);

        T4_In_S_S1.Delay = 0;
        pn.Transitions.add(T4_In_S_S1);
        //---------------------------- END T4_S_S1----------------------------------------

        //-------------------OUT---------------------------
        DataCarQueue P_O_Lane_S_S1 = new DataCarQueue();
        P_O_Lane_S_S1.Value.Size = 4;
        P_O_Lane_S_S1.SetName("P_O_Lane_S_S1");
        pn.PlaceList.add(P_O_Lane_S_S1);

        DataCar P_Oe_Lane_S_S1 = new DataCar();
        P_Oe_Lane_S_S1.SetName("P_Oe_Lane_S_S1");
        pn.PlaceList.add(P_Oe_Lane_S_S1);

        //----------------------------T1_S_S1---------------------------------------- T_ge_CarLane1_S

        PetriTransition T1_Out_S_S1 = new PetriTransition(pn);
        T1_Out_S_S1.TransitionName = "T1_Out_S_S1";
        T1_Out_S_S1.InputPlaceName.add("P_O_Lane_S_S1");

        // --------------guard 1-------------------------------------------------------OK
        Condition T1_Out_S_S1_Ct11 = new Condition(T1_Out_S_S1, "P_O_Lane_S_S1", TransitionCondition.HaveCar);
        GuardMapping grd1T1_Out_S_S1 = new GuardMapping();
        grd1T1_Out_S_S1.condition = T1_Out_S_S1_Ct11;
        grd1T1_Out_S_S1.Activations.add(new Activation(T1_Out_S_S1, "P_O_Lane_S_S1", TransitionOperation.PopElementWithoutTarget, "P_Oe_Lane_S_S1"));
        T1_Out_S_S1.GuardMappingList.add(grd1T1_Out_S_S1);

        T1_Out_S_S1.Delay = 0;
        pn.Transitions.add(T1_Out_S_S1);

        //----------------------------END T1_S_S1----------------------------------------

        //----------------------------T3_S_S1---------------------------------------- T_g_CarLane1_V

        PetriTransition T3_Out_S_S1 = new PetriTransition(pn);
        T3_Out_S_S1.TransitionName = "T3_Out_S_S1";
        T3_Out_S_S1.InputPlaceName.add("P_I_S1");
        T3_Out_S_S1.InputPlaceName.add("P_O_Lane_S_S1");
        T3_Out_S_S1.InputPlaceName.add("P_PTL_S_S1");

        // --------------guard 2-------------------------------------------------------OK
        Condition T3_Out_S_S1_Ct21 = new Condition(T3_Out_S_S1, "P_I_S1", TransitionCondition.HavePriorityCarForMe);
        Condition T3_Out_S_S1_Ct22 = new Condition(T3_Out_S_S1, "P_O_Lane_S_S1", TransitionCondition.CanAddCars);
        T3_Out_S_S1_Ct21.SetNextCondition(LogicConnector.AND, T3_Out_S_S1_Ct22);
        GuardMapping grd2T3_Out_S_S1 = new GuardMapping();
        grd2T3_Out_S_S1.condition = T3_Out_S_S1_Ct21;
        grd2T3_Out_S_S1.Activations.add(new Activation(T3_Out_S_S1, "P_I_S1", TransitionOperation.PopElementWithTargetToQueue, "P_O_Lane_S_S1"));
        T3_Out_S_S1.GuardMappingList.add(grd2T3_Out_S_S1);

        // --------------guard 1-------------------------------------------------------OK
        Condition T3_Out_S_S1_Ct11 = new Condition(T3_Out_S_S1, "P_I_S1", TransitionCondition.HaveCarForMe);
        Condition T3_Out_S_S1_Ct12 = new Condition(T3_Out_S_S1, "P_O_Lane_S_S1", TransitionCondition.CanAddCars);
        Condition T3_Out_S_S1_Ct13 = new Condition(T3_Out_S_S1, "P_PTL_S_S1", TransitionCondition.Equal, "red");
        T3_Out_S_S1_Ct12.SetNextCondition(LogicConnector.AND, T3_Out_S_S1_Ct13);
        T3_Out_S_S1_Ct11.SetNextCondition(LogicConnector.AND, T3_Out_S_S1_Ct12);
        GuardMapping grd1T3_Out_S_S1 = new GuardMapping();
        grd1T3_Out_S_S1.condition = T3_Out_S_S1_Ct11;
        grd1T3_Out_S_S1.Activations.add(new Activation(T3_Out_S_S1, "P_I_S1", TransitionOperation.PopElementWithTargetToQueue, "P_O_Lane_S_S1"));
        T3_Out_S_S1.GuardMappingList.add(grd1T3_Out_S_S1);

        T3_Out_S_S1.Delay = 0;
        pn.Transitions.add(T3_Out_S_S1);

        //----------------------------END T21_V_S1----------------------------------------

        //------------------EAST--------------------------
        //-------------------IN---------------------------
        DataCarQueue P_x_Lane_E_S1 = new DataCarQueue();
        P_x_Lane_E_S1.Value.Size = 3;
        P_x_Lane_E_S1.SetName("P_x_Lane_E_S1");
        pn.PlaceList.add(P_x_Lane_E_S1);

        //------------------------------T0_E_S1-------------------------------------------- //T_u_Car1_E
        PetriTransition T0_In_E_S1 = new PetriTransition(pn);
        T0_In_E_S1.TransitionName = "T0_In_E_S1";
        T0_In_E_S1.InputPlaceName.add("P_LaneOut_Int1_V_S2");
        T0_In_E_S1.InputPlaceName.add("P_x_Lane_E_S1");

        Condition T0_In_E_S1_Ct11 = new Condition(T0_In_E_S1, "P_LaneOut_Int1_V_S2", TransitionCondition.HaveCar);
        Condition T0_In_E_S1_Ct12 = new Condition(T0_In_E_S1, "P_x_Lane_E_S1", TransitionCondition.CanAddCars);
        T0_In_E_S1_Ct11.SetNextCondition(LogicConnector.AND, T0_In_E_S1_Ct12);

        GuardMapping grd1T0_In_E_S1 = new GuardMapping();
        grd1T0_In_E_S1.condition = T0_In_E_S1_Ct11;
        grd1T0_In_E_S1.Activations.add(new Activation(T0_In_E_S1, "P_LaneOut_Int1_V_S2", TransitionOperation.PopElementWithoutTargetToQueue, "P_x_Lane_E_S1"));
        T0_In_E_S1.GuardMappingList.add(grd1T0_In_E_S1);

        T0_In_E_S1.Delay = 0;
        pn.Transitions.add(T0_In_E_S1);
        //---------------------------- END T0_E_S1----------------------------------------

        DataCar P_b_Lane_E_S1 = new DataCar();
        P_b_Lane_E_S1.SetName("P_b_Lane_E_S1");
        pn.PlaceList.add(P_b_Lane_E_S1);

        //------------------------------T2_E_S1-------------------------------------------- //T_e_Car1_E
        PetriTransition T2_In_E_S1 = new PetriTransition(pn);
        T2_In_E_S1.TransitionName = "T2_In_E_S1";
        T2_In_E_S1.InputPlaceName.add("P_x_Lane_E_S1");
        T2_In_E_S1.InputPlaceName.add("P_TL_E_S1");
        T2_In_E_S1.InputPlaceName.add("UserReq_E_S1");
        T2_In_E_S1.InputPlaceName.add("P_PTL_E_S1");

        //------------------------guard 3------------------------------------------------------
        Condition T2_In_E_S1_C31 = new Condition(T2_In_E_S1, "P_x_Lane_E_S1", TransitionCondition.HavePriorityCar);
        GuardMapping grd3T2_In_E_S1 = new GuardMapping();
        grd3T2_In_E_S1.condition= T2_In_E_S1_C31;
        grd3T2_In_E_S1.Activations.add(new Activation(T2_In_E_S1, "P_x_Lane_E_S1", TransitionOperation.PopElementWithoutTarget, "P_b_Lane_E_S1"));
        grd3T2_In_E_S1.Activations.add(new Activation(T2_In_E_S1, "P_TL_E_S1", TransitionOperation.Move, "P_TL_E_S1"));
        grd3T2_In_E_S1.Activations.add(new Activation(T2_In_E_S1, "P_PTL_E_S1", TransitionOperation.Move, "P_PTL_E_S1"));

        T2_In_E_S1.GuardMappingList.add(grd3T2_In_E_S1);


        //-----------------------guard1---------------------------------------------------

        Condition T2_In_E_S1_Ct11 = new Condition(T2_In_E_S1, "P_TL_E_S1", TransitionCondition.Equal,"green");
        Condition T2_In_E_S1_Ct12 = new Condition(T2_In_E_S1, "P_x_Lane_E_S1", TransitionCondition.HaveCar);
        T2_In_E_S1_Ct11.SetNextCondition(LogicConnector.AND, T2_In_E_S1_Ct12);

        GuardMapping grd1T2_In_E_S1 = new GuardMapping();
        grd1T2_In_E_S1.condition= T2_In_E_S1_Ct11;
        grd1T2_In_E_S1.Activations.add(new Activation(T2_In_E_S1, "P_x_Lane_E_S1", TransitionOperation.PopElementWithoutTarget, "P_b_Lane_E_S1"));
        grd1T2_In_E_S1.Activations.add(new Activation(T2_In_E_S1, "P_TL_E_S1", TransitionOperation.Move, "P_TL_E_S1"));
        grd1T2_In_E_S1.Activations.add(new Activation(T2_In_E_S1, "P_PTL_E_S1", TransitionOperation.Move, "P_PTL_E_S1"));
        T2_In_E_S1.GuardMappingList.add(grd1T2_In_E_S1);

        //-----------------------guard2---------------------------------------------------
        Condition T2_In_E_S1_Ct13 = new Condition(T2_In_E_S1, "UserReq_E_S1", TransitionCondition.NotNull);

        GuardMapping grd2T2_In_E_S1 = new GuardMapping();
        grd2T2_In_E_S1.condition = T2_In_E_S1_Ct13;

        grd2T2_In_E_S1.Activations.add(new Activation(T2_In_E_S1, "P_TL_E_S1", TransitionOperation.Move, "P_TL_E_S1"));
        grd2T2_In_E_S1.Activations.add(new Activation(T2_In_E_S1, "P_PTL_E_S1", TransitionOperation.Move, "P_PTL_E_S1"));
        grd2T2_In_E_S1.Activations.add(new Activation(T2_In_E_S1, "UserReq_E_S1", TransitionOperation.SendOverNetwork, "OP_Req_E_S1"));

        T2_In_E_S1.GuardMappingList.add(grd2T2_In_E_S1);

        T2_In_E_S1.Delay = 0;
        pn.Transitions.add(T2_In_E_S1);
        //---------------------------- END T2_E_S1----------------------------------------

        //-----------------------------T4_E_S1-------------------------------------------//T_I_Car1_E
        PetriTransition T4_In_E_S1 = new PetriTransition(pn);
        T4_In_E_S1.TransitionName = "T4_In_E_S1";
        T4_In_E_S1.InputPlaceName.add("P_b_Lane_E_S1");
        T4_In_E_S1.InputPlaceName.add("P_I_S1");

        Condition T4_In_E_S1_Ct11 = new Condition(T4_In_E_S1, "P_b_Lane_E_S1", TransitionCondition.NotNull);
        Condition T4_In_E_S1_Ct12 = new Condition(T4_In_E_S1, "P_I_S1", TransitionCondition.CanAddCars);
        T4_In_E_S1_Ct11.SetNextCondition(LogicConnector.AND, T4_In_E_S1_Ct12);

        GuardMapping grd1T4_In_E_S1 = new GuardMapping();
        grd1T4_In_E_S1.condition = T4_In_E_S1_Ct11;
        grd1T4_In_E_S1.Activations.add(new Activation(T4_In_E_S1, "P_b_Lane_E_S1", TransitionOperation.AddElement, "P_I_S1"));
        T4_In_E_S1.GuardMappingList.add(grd1T4_In_E_S1);

        T4_In_E_S1.Delay = 0;
        pn.Transitions.add(T4_In_E_S1);
        //---------------------------- END T4_N_S1----------------------------------------

        //-------------------OUT---------------------------
        DataCarQueue P_O_Lane_E_S1 = new DataCarQueue();
        P_O_Lane_E_S1.Value.Size = 3;
        P_O_Lane_E_S1.SetName("P_O_Lane_E_S1");
        pn.PlaceList.add(P_O_Lane_E_S1);

        //----------------------------T3_E_S1---------------------------------------- T_g_CarLane1_E

        PetriTransition T3_Out_E_S1 = new PetriTransition(pn);
        T3_Out_E_S1.TransitionName = "T3_Out_E_S1";
        T3_Out_E_S1.InputPlaceName.add("P_I_S1");
        T3_Out_E_S1.InputPlaceName.add("P_O_Lane_E_S1");
        T3_Out_E_S1.InputPlaceName.add("P_PTL_E_S1");

        // --------------guard 2-------------------------------------------------------OK
        Condition T3_Out_E_S1_Ct21 = new Condition(T3_Out_E_S1, "P_I_S1", TransitionCondition.HavePriorityCarForMe);
        Condition T3_Out_E_S1_Ct22 = new Condition(T3_Out_E_S1, "P_O_Lane_E_S1", TransitionCondition.CanAddCars);
        T3_Out_E_S1_Ct21.SetNextCondition(LogicConnector.AND, T3_Out_E_S1_Ct22);
        GuardMapping grd2T3_Out_E_S1 = new GuardMapping();
        grd2T3_Out_E_S1.condition = T3_Out_E_S1_Ct21;
        grd2T3_Out_E_S1.Activations.add(new Activation(T3_Out_E_S1, "P_I_S1", TransitionOperation.PopElementWithTargetToQueue, "P_O_Lane_E_S1"));
        T3_Out_E_S1.GuardMappingList.add(grd2T3_Out_E_S1);

        // --------------guard 1-------------------------------------------------------OK
        Condition T3_Out_E_S1_Ct11 = new Condition(T3_Out_E_S1, "P_I_S1", TransitionCondition.HaveCarForMe);
        Condition T3_Out_E_S1_Ct12 = new Condition(T3_Out_E_S1, "P_O_Lane_E_S1", TransitionCondition.CanAddCars);
        Condition T3_Out_E_S1_Ct13 = new Condition(T3_Out_E_S1, "P_PTL_E_S1", TransitionCondition.Equal, "red");
        T3_Out_E_S1_Ct12.SetNextCondition(LogicConnector.AND, T3_Out_E_S1_Ct13);
        T3_Out_E_S1_Ct11.SetNextCondition(LogicConnector.AND, T3_Out_E_S1_Ct12);
        GuardMapping grd1T3_Out_E_S1 = new GuardMapping();
        grd1T3_Out_E_S1.condition = T3_Out_E_S1_Ct11;
        grd1T3_Out_E_S1.Activations.add(new Activation(T3_Out_E_S1, "P_I_S1", TransitionOperation.PopElementWithTargetToQueue, "P_O_Lane_E_S1"));
        T3_Out_E_S1.GuardMappingList.add(grd1T3_Out_E_S1);

        T3_Out_E_S1.Delay = 0;
        pn.Transitions.add(T3_Out_E_S1);

        //----------------------------END T3_E_S1----------------------------------------

        //----------------------------T1_E_S1---------------------------------------- T_ge_CarLane1_E

        PetriTransition T1_Out_E_S1 = new PetriTransition(pn);
        T1_Out_E_S1.TransitionName = "T1_Out_E_S1";
        T1_Out_E_S1.InputPlaceName.add("P_O_Lane_E_S1");

        // --------------guard 1-------------------------------------------------------OK
        Condition T1_Out_E_S1_Ct11 = new Condition(T1_Out_E_S1, "P_O_Lane_E_S1", TransitionCondition.HaveCar);
        Condition T1_Out_E_S1_Ct12 = new Condition(T1_Out_E_S1, "P_LaneIn_int1_V_S2", TransitionCondition.CanAddCars);
        T1_Out_E_S1_Ct11.SetNextCondition(LogicConnector.AND, T1_Out_E_S1_Ct12);
        GuardMapping grd1T1_Out_E_S1 = new GuardMapping();
        grd1T1_Out_E_S1.condition = T1_Out_E_S1_Ct11;
        grd1T1_Out_E_S1.Activations.add(new Activation(T1_Out_E_S1, "P_O_Lane_E_S1", TransitionOperation.PopElementWithoutTarget, "P_LaneIn_int1_V_S2"));
        T1_Out_E_S1.GuardMappingList.add(grd1T1_Out_E_S1);

        T1_Out_E_S1.Delay = 0;
        pn.Transitions.add(T1_Out_E_S1);

        //----------------------------END T1_E_S1----------------------------------------

        //-------------------INTERSECTION---------------------------
        DataCarQueue P_I_S1 = new DataCarQueue();
        P_I_S1.Value.Size = 3;
        P_I_S1.SetName("P_I_S1");
        pn.PlaceList.add(P_I_S1);

        //-------------------SEMAPHORES---------------------------
        //-------------------VEST---------------------------
        DataString P_TL_V_S1 = new DataString();
        P_TL_V_S1.SetName("P_TL_V_S1");
        pn.PlaceList.add(P_TL_V_S1);

        DataString P_PTL_V_S1 = new DataString();
        P_PTL_V_S1.SetName("P_PTL_V_S1");
        pn.PlaceList.add(P_PTL_V_S1);

        DataString UserReq_V_S1 = new DataString();
        UserReq_V_S1.SetName("UserReq_V_S1");
        pn.PlaceList.add(UserReq_V_S1);

        DataTransfer OP_Req_V_S1 = new DataTransfer();
        OP_Req_V_S1.SetName("OP_Req_V_S1");
        OP_Req_V_S1.Value = new TransferOperation("localhost", "1081" , "UserReq_V");
        pn.PlaceList.add(OP_Req_V_S1);

        //-------------------NORTH---------------------------
        DataString P_TL_N_S1 = new DataString();
        P_TL_N_S1.SetName("P_TL_N_S1");
        pn.PlaceList.add(P_TL_N_S1);

        DataString P_PTL_N_S1 = new DataString();
        P_PTL_N_S1.SetName("P_PTL_N_S1");
        pn.PlaceList.add(P_PTL_N_S1);

        DataString UserReq_N_S1 = new DataString();
        UserReq_N_S1.SetName("UserReq_N_S1");
        pn.PlaceList.add(UserReq_N_S1);

        DataTransfer OP_Req_N_S1 = new DataTransfer();
        OP_Req_N_S1.SetName("OP_Req_N_S1");
        OP_Req_N_S1.Value = new TransferOperation("localhost", "1081" , "UserReq_N");
        pn.PlaceList.add(OP_Req_N_S1);

        //-------------------SOUTH---------------------------
        DataString P_TL_S_S1 = new DataString();
        P_TL_S_S1.SetName("P_TL_S_S1");
        pn.PlaceList.add(P_TL_S_S1);

        DataString P_PTL_S_S1 = new DataString();
        P_PTL_S_S1.SetName("P_PTL_S_S1");
        pn.PlaceList.add(P_PTL_S_S1);

        DataString UserReq_S_S1 = new DataString();
        UserReq_S_S1.SetName("UserReq_S_S1");
        pn.PlaceList.add(UserReq_S_S1);

        DataTransfer OP_Req_S_S1 = new DataTransfer();
        OP_Req_S_S1.SetName("OP_Req_S_S1");
        OP_Req_S_S1.Value = new TransferOperation("localhost", "1081" , "UserReq_S");
        pn.PlaceList.add(OP_Req_S_S1);

        //-------------------EAST---------------------------
        DataString P_TL_E_S1 = new DataString();
        P_TL_E_S1.SetName("P_TL_E_S1");
        pn.PlaceList.add(P_TL_E_S1);

        DataString P_PTL_E_S1 = new DataString();
        P_PTL_E_S1.SetName("P_PTL_E_S1");
        pn.PlaceList.add(P_PTL_E_S1);

        DataString UserReq_E_S1 = new DataString();
        UserReq_E_S1.SetName("UserReq_E_S1");
        pn.PlaceList.add(UserReq_E_S1);

        DataTransfer OP_Req_E_S1 = new DataTransfer();
        OP_Req_E_S1.SetName("OP_Req_E_S1");
        OP_Req_E_S1.Value = new TransferOperation("localhost", "1081" , "UserReq_E");
        pn.PlaceList.add(OP_Req_E_S1);

        // -------------------------------------------------------------------
        // ----------------END CALEA FERENTARI SECTION 1----------------------
        // -------------------------------------------------------------------

        // -------------------------------------------------------------------
        // --------------------CALEA FERENTARI SECTION 2----------------------
        // -------------------------------------------------------------------

        //------------------VEST--------------------------
        //-------------------IN---------------------------
        DataCarQueue P_LaneIn_int1_V_S2 = new DataCarQueue();
        P_LaneIn_int1_V_S2.Value.Size = 3;
        P_LaneIn_int1_V_S2.SetName("P_LaneIn_int1_V_S2");
        pn.PlaceList.add(P_LaneIn_int1_V_S2);

        //----------------------------T0_V_S2------------------------------- //140
        PetriTransition T0_In_V_S2 = new PetriTransition(pn);
        T0_In_V_S1.TransitionName = "T0_Out_V_S1";
        T0_In_V_S1.InputPlaceName.add("P_LaneIn_int1_V_S2");

        // --------------guard 1-------------------------------------------------------OK
        Condition T0_In_V_S2_Ct11 = new Condition(T0_In_V_S2, "P_LaneIn_int1_V_S2", TransitionCondition.HaveTramForMe);
        Condition T0_In_V_S2_Ct12 = new Condition(T0_In_V_S2, "P_TramStationIn_CaleaFerentari_V_S2", TransitionCondition.CanAddCars);
        T0_In_V_S2_Ct11.SetNextCondition(LogicConnector.AND, T0_In_V_S2_Ct12);
        GuardMapping grd1T0_In_V_S2 = new GuardMapping();
        grd1T0_In_V_S2.condition = T17_Out_V_S1_Ct11;
        grd1T0_In_V_S2.Activations.add(new Activation(T0_In_V_S2, "P_O_Lane_V_S1", TransitionOperation.PopElementWithTargetToQueue, "P_BusStation_Sebastian_V_S1"));
        T0_In_V_S2.GuardMappingList.add(grd1T0_In_V_S2);

        T17_Out_V_S1.Delay = 0;
        pn.Transitions.add(T17_Out_V_S1);

        //----------------------------END T17_V_S1----------------------------------------


        DataCarQueue P_LaneIn_int2_V_S2 = new DataCarQueue();
        P_LaneIn_int2_V_S2.Value.Size = 2;
        P_LaneIn_int2_V_S2.SetName("P_LaneIn_int2_V_S2");
        pn.PlaceList.add(P_LaneIn_int2_V_S2);

        DataCar P_Lane_LocusteanuOut_V_S2 = new DataCar();
        P_Lane_LocusteanuOut_V_S2.SetName("P_Lane_LocusteanuOut_V_S2");
        pn.PlaceList.add(P_Lane_LocusteanuOut_V_S2);

        DataCar P_Lane_LocusteanuIn_V_S2 = new DataCar();
        P_Lane_LocusteanuIn_V_S2.SetName("P_Lane_LocusteanuIn_V_S2");
        pn.PlaceList.add(P_Lane_LocusteanuIn_V_S2);

        DataCarQueue P_LaneIn_int3_V_S2 = new DataCarQueue();
        P_LaneIn_int3_V_S2.Value.Size = 3;
        P_LaneIn_int3_V_S2.SetName("P_LaneIn_int3_V_S2");
        pn.PlaceList.add(P_LaneIn_int3_V_S2);

        DataCarQueue P_TramStationIn_CaleaFerentari_V_S2 = new DataCarQueue();
        P_TramStationIn_CaleaFerentari_V_S2.Value.Size = 1;
        P_TramStationIn_CaleaFerentari_V_S2.SetName("P_TramStationIn_CaleaFerentari_V_S2");
        pn.PlaceList.add(P_TramStationIn_CaleaFerentari_V_S2);

        DataCarQueue P_TramStationIn_CaleaFerentariOut_V_S2 = new DataCarQueue();
        P_TramStationIn_CaleaFerentariOut_V_S2.Value.Size = 1;
        P_TramStationIn_CaleaFerentariOut_V_S2.SetName("P_TramStationIn_CaleaFerentariOut_V_S2");
        pn.PlaceList.add(P_TramStationIn_CaleaFerentariOut_V_S2);

        DataCarQueue P_LaneIn_int4_V_S2 = new DataCarQueue();
        P_LaneIn_int4_V_S2.Value.Size = 3;
        P_LaneIn_int4_V_S2.SetName("P_LaneIn_int4_V_S2");
        pn.PlaceList.add(P_LaneIn_int4_V_S2);

        DataCarQueue P_BusStation_CaleaRahovei_V_S2 = new DataCarQueue();
        P_BusStation_CaleaRahovei_V_S2.Value.Size = 2;
        P_BusStation_CaleaRahovei_V_S2.SetName("P_BusStation_CaleaRahovei_V_S2");
        pn.PlaceList.add(P_BusStation_CaleaRahovei_V_S2);

        DataCarQueue P_BusStation_CaleaRahoveiOut_V_S2 = new DataCarQueue();
        P_BusStation_CaleaRahoveiOut_V_S2.Value.Size = 2;
        P_BusStation_CaleaRahoveiOut_V_S2.SetName("P_BusStation_CaleaRahoveiOut_V_S2");
        pn.PlaceList.add(P_BusStation_CaleaRahoveiOut_V_S2);

        DataCarQueue P_LaneIn_int5_V_S2 = new DataCarQueue();
        P_LaneIn_int5_V_S2.Value.Size = 3;
        P_LaneIn_int5_V_S2.SetName("P_LaneIn_int5_V_S2");
        pn.PlaceList.add(P_LaneIn_int5_V_S2);

        DataCarQueue P_LaneIn_int6_V_S2 = new DataCarQueue();
        P_LaneIn_int6_V_S2.Value.Size = 3;
        P_LaneIn_int6_V_S2.SetName("P_LaneIn_int6_V_S2");
        pn.PlaceList.add(P_LaneIn_int6_V_S2);

        DataCar P_Lane_OlaruOut_V_S2 = new DataCar();
        P_Lane_OlaruOut_V_S2.SetName("P_Lane_OlaruOut_V_S2");
        pn.PlaceList.add(P_Lane_OlaruOut_V_S2);

        DataCar P_Lane_OlaruIn_V_S2 = new DataCar();
        P_Lane_OlaruIn_V_S2.SetName("P_Lane_OlaruIn_V_S2");
        pn.PlaceList.add(P_Lane_OlaruIn_V_S2);

        DataCarQueue P_LaneIn_int7_V_S2 = new DataCarQueue();
        P_LaneIn_int7_V_S2.Value.Size = 3;
        P_LaneIn_int7_V_S2.SetName("P_LaneIn_int7_V_S2");
        pn.PlaceList.add(P_LaneIn_int7_V_S2);

        //-------------------OUT--------------------------
        DataCarQueue P_LaneOut_Int1_V_S2 = new DataCarQueue();
        P_LaneOut_Int1_V_S2.SetName("P_LaneOut_Int1_V_S2");
        P_LaneOut_Int1_V_S2.Value.Size = 3;
        pn.PlaceList.add(P_LaneOut_Int1_V_S2);

        DataCar P_Lane_TocilescuIn_V_S2 = new DataCar();
        P_Lane_TocilescuIn_V_S2.SetName("P_Lane_TocilescuIn_V_S2");
        pn.PlaceList.add(P_Lane_TocilescuIn_V_S2);

        DataCar P_Lane_TocilescuOut_V_S2 = new DataCar();
        P_Lane_TocilescuOut_V_S2.SetName("P_Lane_TocilescuOut_V_S2");
        pn.PlaceList.add(P_Lane_TocilescuOut_V_S2);

        DataCarQueue P_LaneOut_Int2_V_S2 = new DataCarQueue();
        P_LaneOut_Int2_V_S2.Value.Size = 2;
        P_LaneOut_Int2_V_S2.SetName("P_LaneOut_Int2_V_S2");
        pn.PlaceList.add(P_LaneOut_Int2_V_S2);

        DataCarQueue P_TramStationOut_CaleaFerentari_V_Out_S2 = new DataCarQueue();
        P_TramStationOut_CaleaFerentari_V_Out_S2.SetName("P_TramStationOut_CaleaFerentari_V_Out_S2");
        P_TramStationOut_CaleaFerentari_V_Out_S2.Value.Size = 1;
        pn.PlaceList.add(P_TramStationOut_CaleaFerentari_V_Out_S2);

        //am ramas aici

        DataCarQueue P_TramStationOut_CaleaFerentari_V_S2 = new DataCarQueue();
        P_TramStationOut_CaleaFerentari_V_S2.SetName("P_TramStationOut_CaleaFerentari_V_S2");
        P_TramStationOut_CaleaFerentari_V_S2.Value.Size = 1;
        pn.PlaceList.add(P_TramStationOut_CaleaFerentari_V_S2);

        DataCarQueue P_LaneOut_Int3_V_S2 = new DataCarQueue();
        P_LaneOut_Int3_V_S2.SetName("P_LaneOut_Int3_V_S2");
        P_LaneOut_Int3_V_S2.Value.Size = 3;
        pn.PlaceList.add(P_LaneOut_Int3_V_S2);

        DataCar P_Lane_PoenaruIn_V_S2 = new DataCar();
        P_Lane_PoenaruIn_V_S2.SetName("P_Lane_PoenaruIn_V_S2");
        pn.PlaceList.add(P_Lane_PoenaruIn_V_S2);

        DataCar P_Lane_PoenaruIn2_V_S2 = new DataCar();
        P_Lane_PoenaruIn2_V_S2.SetName("P_Lane_PoenaruIn2_V_S2");
        pn.PlaceList.add(P_Lane_PoenaruIn2_V_S2);

        DataCarQueue P_LaneOut_Int4_V_S2 = new DataCarQueue();
        P_LaneOut_Int4_V_S2.SetName("P_LaneOut_Int4_V_S2");
        P_LaneOut_Int4_V_S2.Value.Size = 3;
        pn.PlaceList.add(P_LaneOut_Int4_V_S2);

        DataCar P_Lane_LidlIn_V_S2 = new DataCar();
        P_Lane_LidlIn_V_S2.SetName("P_Lane_LidlIn_V_S2");
        pn.PlaceList.add(P_Lane_LidlIn_V_S2);

        DataCar P_Lane_LidlOut_V_S2 = new DataCar();
        P_Lane_LidlOut_V_S2.SetName("P_Lane_LidlOut_V_S2");
        pn.PlaceList.add(P_Lane_LidlOut_V_S2);

        DataCarQueue P_LaneOut_Int5_V_S2 = new DataCarQueue();
        P_LaneOut_Int5_V_S2.SetName("P_LaneOut_Int5_V_S2");
        P_LaneOut_Int5_V_S2.Value.Size = 3;
        pn.PlaceList.add(P_LaneOut_Int5_V_S2);

        DataCarQueue P_LaneOut_Int6_V_S2 = new DataCarQueue();
        P_LaneOut_Int6_V_S2.SetName("P_LaneOut_Int6_V_S2");
        P_LaneOut_Int6_V_S2.Value.Size = 3;
        pn.PlaceList.add(P_LaneOut_Int6_V_S2);

        DataCar P_Lane_BenzinarieIn_V_S2 = new DataCar();
        P_Lane_BenzinarieIn_V_S2.SetName("P_Lane_BenzinarieIn_V_S2");
        pn.PlaceList.add(P_Lane_BenzinarieIn_V_S2);

        DataCar P_Lane_BenzinarieOut_V_S2 = new DataCar();
        P_Lane_BenzinarieOut_V_S2.SetName("P_Lane_BenzinarieOut_V_S2");
        pn.PlaceList.add(P_Lane_BenzinarieOut_V_S2);

        DataCarQueue P_LaneOut_Int7_V_S2 = new DataCarQueue();
        P_LaneOut_Int7_V_S2.SetName("P_LaneOut_Int7_V_S2");
        P_LaneOut_Int7_V_S2.Value.Size = 3;
        pn.PlaceList.add(P_LaneOut_Int7_V_S2);

        DataCarQueue P_LaneOut_Int8_V_S2 = new DataCarQueue();
        P_LaneOut_Int8_V_S2.SetName("P_LaneOut_Int8_V_S2");
        P_LaneOut_Int8_V_S2.Value.Size = 3;
        pn.PlaceList.add(P_LaneOut_Int8_V_S2);


        //-------------------CROSSING----------------------------------------
        DataCarQueue P_x_Cross_Lane_V_Out_S2 = new DataCarQueue();
        P_x_Cross_Lane_V_Out_S2.Value.Size = 3;
        P_x_Cross_Lane_V_Out_S2.SetName("P_x_Cross_Lane_V_Out_S2");
        pn.PlaceList.add(P_x_Cross_Lane_V_Out_S2);

        DataCarQueue P_x_Cross_Lane_V_In_S2 = new DataCarQueue();
        P_x_Cross_Lane_V_In_S2.Value.Size = 3;
        P_x_Cross_Lane_V_In_S2.SetName("P_x_Cross_Lane_V_In_S2");
        pn.PlaceList.add(P_x_Cross_Lane_V_In_S2);

        DataString P_Cross_TL_V_S2 = new DataString();
        P_Cross_TL_V_S2.SetName("P_Cross_TL_V_S2");
        pn.PlaceList.add(P_Cross_TL_V_S2);

        DataString P_Cross_PTL_V_S2 = new DataString();
        P_Cross_PTL_V_S2.SetName("P_Cross_PTL_V_S2");
        pn.PlaceList.add(P_Cross_PTL_V_S2);

        DataString UserReq_Cross_V_S2 = new DataString();
        UserReq_Cross_V_S2.SetName("UserReq_Cross_V_S2");
        pn.PlaceList.add(UserReq_Cross_V_S2);

        DataTransfer OP_Req_Cross_N_S1 = new DataTransfer();
        OP_Req_Cross_N_S1.SetName("OP_Req_Cross_N_S1");
        OP_Req_Cross_N_S1.Value = new TransferOperation("localhost", "1082" , "UserReq_Cross_V");
        pn.PlaceList.add(OP_Req_Cross_N_S1);

        //-------------------IN---------------------------
        DataCarQueue P_LaneIn_int8_V_S2 = new DataCarQueue();
        P_LaneIn_int8_V_S2.Value.Size = 3;
        P_LaneIn_int8_V_S2.SetName("P_LaneIn_int8_V_S2");
        pn.PlaceList.add(P_LaneIn_int8_V_S2);

        DataCarQueue P_LaneIn_int9_V_S2 = new DataCarQueue();
        P_LaneIn_int9_V_S2.Value.Size = 3;
        P_LaneIn_int9_V_S2.SetName("P_LaneIn_int9_V_S2");
        pn.PlaceList.add(P_LaneIn_int9_V_S2);

        DataCar P_Lane_NiculaescuOut_V_S2 = new DataCar();
        P_Lane_NiculaescuOut_V_S2.SetName("P_Lane_NiculaescuOut_V_S2");
        pn.PlaceList.add(P_Lane_NiculaescuOut_V_S2);

        DataCar P_Lane_NiculaescuIn_V_S2 = new DataCar();
        P_Lane_NiculaescuIn_V_S2.SetName("P_Lane_NiculaescuIn_V_S2");
        pn.PlaceList.add(P_Lane_NiculaescuIn_V_S2);

        DataCarQueue P_LaneIn_int10_V_S2 = new DataCarQueue();
        P_LaneIn_int10_V_S2.Value.Size = 3;
        P_LaneIn_int10_V_S2.SetName("P_LaneIn_int10_V_S2");
        pn.PlaceList.add(P_LaneIn_int10_V_S2);

        DataCarQueue P_LaneIn_int11_V_S2 = new DataCarQueue();
        P_LaneIn_int11_V_S2.Value.Size = 3;
        P_LaneIn_int11_V_S2.SetName("P_LaneIn_int11_V_S2");
        pn.PlaceList.add(P_LaneIn_int11_V_S2);

        DataCar P_Lane_BarleaOut_V_S2 = new DataCar();
        P_Lane_BarleaOut_V_S2.SetName("P_Lane_BarleaOut_V_S2");
        pn.PlaceList.add(P_Lane_BarleaOut_V_S2);

        DataCar P_Lane_BarleaIn_V_S2 = new DataCar();
        P_Lane_BarleaIn_V_S2.SetName("P_Lane_BarleaIn_V_S2");
        pn.PlaceList.add(P_Lane_BarleaIn_V_S2);

        DataCarQueue P_LaneIn_int12_V_S2 = new DataCarQueue();
        P_LaneIn_int12_V_S2.Value.Size = 3;
        P_LaneIn_int12_V_S2.SetName("P_LaneIn_int12_V_S2");
        pn.PlaceList.add(P_LaneIn_int12_V_S2);

        DataCarQueue P_LaneIn_int13_V_S2 = new DataCarQueue();
        P_LaneIn_int13_V_S2.Value.Size = 3;
        P_LaneIn_int13_V_S2.SetName("P_LaneIn_int13_V_S2");
        pn.PlaceList.add(P_LaneIn_int13_V_S2);

        DataCar P_Lane_CarcalechiOut_V_S2 = new DataCar();
        P_Lane_CarcalechiOut_V_S2.SetName("P_Lane_CarcalechiOut_V_S2");
        pn.PlaceList.add(P_Lane_CarcalechiOut_V_S2);

        DataCar P_Lane_CarcalechiIn_V_S2 = new DataCar();
        P_Lane_CarcalechiIn_V_S2.SetName("P_Lane_CarcalechiIn_V_S2");
        pn.PlaceList.add(P_Lane_CarcalechiIn_V_S2);

        DataCarQueue P_LaneIn_int14_V_S2 = new DataCarQueue();
        P_LaneIn_int14_V_S2.Value.Size = 3;
        P_LaneIn_int14_V_S2.SetName("P_LaneIn_int14_V_S2");
        pn.PlaceList.add(P_LaneIn_int14_V_S2);

        DataCarQueue P_LaneIn_int15_V_S2 = new DataCarQueue();
        P_LaneIn_int15_V_S2.Value.Size = 3;
        P_LaneIn_int15_V_S2.SetName("P_LaneIn_int15_V_S2");
        pn.PlaceList.add(P_LaneIn_int15_V_S2);

        DataCar P_Lane_McDonaldsOut_V_S2 = new DataCar();
        P_Lane_McDonaldsOut_V_S2.SetName("P_Lane_McDonaldsOut_V_S2");
        pn.PlaceList.add(P_Lane_McDonaldsOut_V_S2);

        DataCar P_Lane_McDonaldsIn_V_S2 = new DataCar();
        P_Lane_McDonaldsIn_V_S2.SetName("P_Lane_McDonaldsIn_V_S2");
        pn.PlaceList.add(P_Lane_McDonaldsIn_V_S2);

        DataCarQueue P_LaneIn_int16_V_S2 = new DataCarQueue();
        P_LaneIn_int16_V_S2.Value.Size = 3;
        P_LaneIn_int16_V_S2.SetName("P_LaneIn_int16_V_S2");
        pn.PlaceList.add(P_LaneIn_int16_V_S2);

        DataCarQueue P_LaneIn_int17_V_S2 = new DataCarQueue();
        P_LaneIn_int17_V_S2.Value.Size = 3;
        P_LaneIn_int17_V_S2.SetName("P_LaneIn_int17_V_S2");
        pn.PlaceList.add(P_LaneIn_int17_V_S2);

        DataCarQueue P_x_Lane_V_S2 = new DataCarQueue();
        P_x_Lane_V_S2.Value.Size = 4;
        P_x_Lane_V_S2.SetName("P_x_Lane_V_S2");
        pn.PlaceList.add(P_x_Lane_V_S2);

        DataCar P_b_Lane_V_S2 = new DataCar();
        P_b_Lane_V_S2.SetName("P_b_Lane_V_S2");
        pn.PlaceList.add(P_b_Lane_V_S2);

        //-------------------OUT--------------------------
        DataCarQueue P_LaneOut_Int9_V_S2 = new DataCarQueue();
        P_LaneOut_Int9_V_S2.SetName("P_LaneOut_Int9_V_S2");
        P_LaneOut_Int9_V_S2.Value.Size = 3;
        pn.PlaceList.add(P_LaneOut_Int9_V_S2);

        DataCarQueue P_LaneOut_Int10_V_S2 = new DataCarQueue();
        P_LaneOut_Int10_V_S2.SetName("P_LaneOut_Int10_V_S2");
        P_LaneOut_Int10_V_S2.Value.Size = 2;
        pn.PlaceList.add(P_LaneOut_Int10_V_S2);

        DataCarQueue P_BusStation_SoseauaProgresului_V_Out_S2 = new DataCarQueue();
        P_BusStation_SoseauaProgresului_V_Out_S2.SetName("P_BusStation_SoseauaProgresului_V_Out_S2");
        P_BusStation_SoseauaProgresului_V_Out_S2.Value.Size = 2;
        pn.PlaceList.add(P_BusStation_SoseauaProgresului_V_Out_S2);

        DataCarQueue P_BusStation_SoseauaProgresului_V_S2 = new DataCarQueue();
        P_BusStation_SoseauaProgresului_V_S2.SetName("P_BusStation_SoseauaProgresului_V_S2");
        P_BusStation_SoseauaProgresului_V_S2.Value.Size = 2;
        pn.PlaceList.add(P_BusStation_SoseauaProgresului_V_S2);

        DataCarQueue P_TramStation_SoseauaProgresului_V_Out_S2 = new DataCarQueue();
        P_TramStation_SoseauaProgresului_V_Out_S2.SetName("P_TramStation_SoseauaProgresului_V_Out_S2");
        P_TramStation_SoseauaProgresului_V_Out_S2.Value.Size = 1;
        pn.PlaceList.add(P_TramStation_SoseauaProgresului_V_Out_S2);

        DataCarQueue P_TramStation_SoseauaProgresului_V_S2 = new DataCarQueue();
        P_TramStation_SoseauaProgresului_V_S2.SetName("P_TramStation_SoseauaProgresului_V_S2");
        P_TramStation_SoseauaProgresului_V_S2.Value.Size = 1;
        pn.PlaceList.add(P_TramStation_SoseauaProgresului_V_S2);

        DataCarQueue P_LaneOut_Int11_V_S2 = new DataCarQueue();
        P_LaneOut_Int11_V_S2.SetName("P_LaneOut_Int11_V_S2");
        P_LaneOut_Int11_V_S2.Value.Size = 3;
        pn.PlaceList.add(P_LaneOut_Int11_V_S2);

        DataCar P_LaneMarket_V_In_S2 = new DataCar();
        P_LaneMarket_V_In_S2.SetName("P_LaneMarket_V_In_S2");
        pn.PlaceList.add(P_LaneMarket_V_In_S2);

        DataCar P_LaneMarket_V_Out_S2 = new DataCar();
        P_LaneMarket_V_Out_S2.SetName("P_LaneMarket_V_Out_S2");
        pn.PlaceList.add(P_LaneMarket_V_Out_S2);

        DataCarQueue P_LaneOut_Int12_V_S2 = new DataCarQueue();
        P_LaneOut_Int12_V_S2.SetName("P_LaneOut_Int12_V_S2");
        P_LaneOut_Int12_V_S2.Value.Size = 3;
        pn.PlaceList.add(P_LaneOut_Int12_V_S2);

        DataCarQueue P_LaneOut_Int13_V_S2 = new DataCarQueue();
        P_LaneOut_Int13_V_S2.SetName("P_LaneOut_Int13_V_S2");
        P_LaneOut_Int13_V_S2.Value.Size = 3;
        pn.PlaceList.add(P_LaneOut_Int13_V_S2);

        DataCarQueue P_O_Lane_V_S2 = new DataCarQueue();
        P_O_Lane_V_S2.Value.Size = 3;
        P_O_Lane_V_S2.SetName("P_O_Lane_V_S2");
        pn.PlaceList.add(P_O_Lane_V_S2);

        //------------------NORTH--------------------------
        //-------------------IN---------------------------
        DataCar P_LaneIn_N_S2 = new DataCar();
        P_LaneIn_N_S2.SetName("P_LaneIn_N_S2");
        pn.PlaceList.add(P_LaneIn_N_S2);

        DataCarQueue P_x_Lane_N_S2 = new DataCarQueue();
        P_x_Lane_N_S2.Value.Size = 3;
        P_x_Lane_N_S2.SetName("P_x_Lane_N_S2");
        pn.PlaceList.add(P_x_Lane_N_S2);

        DataCar P_b_Lane_N_S2 = new DataCar();
        P_b_Lane_N_S2.SetName("P_b_Lane_N_S2");
        pn.PlaceList.add(P_b_Lane_N_S2);

        //-------------------OUT---------------------------
        DataCarQueue P_O_Lane_N_S2 = new DataCarQueue();
        P_O_Lane_N_S2.Value.Size = 3;
        P_O_Lane_N_S2.SetName("P_O_Lane_N_S2");
        pn.PlaceList.add(P_O_Lane_N_S2);

        DataCar P_Oe_Lane_N_S2 = new DataCar();
        P_Oe_Lane_N_S2.SetName("P_Oe_Lane_N_S2");
        pn.PlaceList.add(P_Oe_Lane_N_S2);

        //------------------SOUTH--------------------------
        //-------------------IN---------------------------
        DataCar P_LaneIn_int1_S_S2 = new DataCar();
        P_LaneIn_int1_S_S2.SetName("P_LaneIn_int1_S_S2");
        pn.PlaceList.add(P_LaneIn_int1_S_S2);

        DataCarQueue P_x_Lane_S_S2 = new DataCarQueue();
        P_x_Lane_S_S2.Value.Size = 3;
        P_x_Lane_S_S2.SetName("P_x_Lane_S_S2");
        pn.PlaceList.add(P_x_Lane_S_S2);

        DataCar P_b_Lane_S_S2 = new DataCar();
        P_b_Lane_S_S2.SetName("P_b_Lane_S_S2");
        pn.PlaceList.add(P_b_Lane_S_S2);

        //-------------------OUT---------------------------
        DataCarQueue P_O_Lane_S_S2 = new DataCarQueue();
        P_O_Lane_S_S2.Value.Size = 3;
        P_O_Lane_S_S2.SetName("P_O_Lane_S_S2");
        pn.PlaceList.add(P_O_Lane_S_S2);

        DataCar P_Oe_Lane_S_S2 = new DataCar();
        P_Oe_Lane_S_S2.SetName("P_Oe_Lane_S_S2");
        pn.PlaceList.add(P_Oe_Lane_S_S2);


        //------------------EAST--------------------------
        //-------------------IN---------------------------
        DataCarQueue P_x_Lane_E_S2 = new DataCarQueue();
        P_x_Lane_E_S2.Value.Size = 3;
        P_x_Lane_E_S2.SetName("P_x_Lane_E_S2");
        pn.PlaceList.add(P_x_Lane_E_S2);

        DataCar P_b_Lane_E_S2 = new DataCar();
        P_b_Lane_E_S2.SetName("P_b_Lane_E_S2");
        pn.PlaceList.add(P_b_Lane_E_S2);

        //-------------------OUT---------------------------
        DataCarQueue P_O_Lane_E_S2 = new DataCarQueue();
        P_O_Lane_E_S2.Value.Size = 3;
        P_O_Lane_E_S2.SetName("P_O_Lane_E_S2");
        pn.PlaceList.add(P_O_Lane_E_S2);

        //-------------------INTERSECTION---------------------------
        DataCarQueue P_I_S2 = new DataCarQueue();
        P_I_S2.Value.Size = 3;
        P_I_S2.SetName("P_I_S2");
        pn.PlaceList.add(P_I_S2);

        //-------------------SEMAPHORES---------------------------
        //-------------------VEST---------------------------
        DataString P_TL_V_S2 = new DataString();
        P_TL_V_S2.SetName("P_TL_V_S2");
        pn.PlaceList.add(P_TL_V_S2);

        DataString P_PTL_V_S2 = new DataString();
        P_PTL_V_S2.SetName("P_PTL_V_S2");
        pn.PlaceList.add(P_PTL_V_S2);

        DataString UserReq_V_S2 = new DataString();
        UserReq_V_S2.SetName("UserReq_V_S2");
        pn.PlaceList.add(UserReq_V_S2);

        DataTransfer OP_Req_V_S2 = new DataTransfer();
        OP_Req_V_S2.SetName("OP_Req_V_S2");
        OP_Req_V_S2.Value = new TransferOperation("localhost", "1083" , "UserReq_V");
        pn.PlaceList.add(OP_Req_V_S2);

        //-------------------NORTH---------------------------
        DataString P_TL_N_S2 = new DataString();
        P_TL_N_S2.SetName("P_TL_N_S2");
        pn.PlaceList.add(P_TL_N_S2);

        DataString P_PTL_N_S2 = new DataString();
        P_PTL_N_S2.SetName("P_PTL_N_S2");
        pn.PlaceList.add(P_PTL_N_S2);

        DataString UserReq_N_S2 = new DataString();
        UserReq_N_S2.SetName("UserReq_N_S2");
        pn.PlaceList.add(UserReq_N_S2);

        DataTransfer OP_Req_N_S2 = new DataTransfer();
        OP_Req_N_S2.SetName("OP_Req_N_S2");
        OP_Req_N_S2.Value = new TransferOperation("localhost", "1083" , "UserReq_N");
        pn.PlaceList.add(OP_Req_N_S2);

        //-------------------SOUTH---------------------------
        DataString P_TL_S_S2 = new DataString();
        P_TL_S_S2.SetName("P_TL_S_S2");
        pn.PlaceList.add(P_TL_S_S2);

        DataString P_PTL_S_S2 = new DataString();
        P_PTL_S_S2.SetName("P_PTL_S_S2");
        pn.PlaceList.add(P_PTL_S_S2);

        DataString UserReq_S_S2 = new DataString();
        UserReq_S_S2.SetName("UserReq_S_S2");
        pn.PlaceList.add(UserReq_S_S2);

        DataTransfer OP_Req_S_S2 = new DataTransfer();
        OP_Req_S_S2.SetName("OP_Req_S_S2");
        OP_Req_S_S2.Value = new TransferOperation("localhost", "1083" , "UserReq_S");
        pn.PlaceList.add(OP_Req_S_S2);

        //-------------------EAST---------------------------
        DataString P_TL_E_S2 = new DataString();
        P_TL_E_S2.SetName("P_TL_E_S2");
        pn.PlaceList.add(P_TL_E_S2);

        DataString P_PTL_E_S2 = new DataString();
        P_PTL_E_S2.SetName("P_PTL_E_S2");
        pn.PlaceList.add(P_PTL_E_S2);

        DataString UserReq_E_S2 = new DataString();
        UserReq_E_S2.SetName("UserReq_E_S2");
        pn.PlaceList.add(UserReq_E_S2);

        DataTransfer OP_Req_E_S2 = new DataTransfer();
        OP_Req_E_S2.SetName("OP_Req_E_S2");
        OP_Req_E_S2.Value = new TransferOperation("localhost", "1083" , "UserReq_E");
        pn.PlaceList.add(OP_Req_E_S2);

        // -------------------------------------------------------------------
        // ----------------END CALEA FERENTARI SECTION 2----------------------
        // -------------------------------------------------------------------

        // -------------------------------------------------------------------
        // --------------------CALEA FERENTARI SECTION 3----------------------
        // -------------------------------------------------------------------

        //------------------VEST--------------------------
        //-------------------IN---------------------------
        DataCarQueue P_LaneIn_int1_V_S3 = new DataCarQueue();
        P_LaneIn_int1_V_S3.Value.Size = 3;
        P_LaneIn_int1_V_S3.SetName("P_LaneIn_int1_V_S3");
        pn.PlaceList.add(P_LaneIn_int1_V_S3);

        DataCarQueue P_LaneIn_int2_V_S3 = new DataCarQueue();
        P_LaneIn_int2_V_S3.Value.Size = 3;
        P_LaneIn_int2_V_S3.SetName("P_LaneIn_int2_V_S3");
        pn.PlaceList.add(P_LaneIn_int2_V_S3);

        DataCarQueue P_LaneIn_BusStationProgresului_V_S3 = new DataCarQueue();
        P_LaneIn_BusStationProgresului_V_S3.Value.Size = 2;
        P_LaneIn_BusStationProgresului_V_S3.SetName("P_LaneIn_BusStationProgresului_V_S3");
        pn.PlaceList.add(P_LaneIn_BusStationProgresului_V_S3);

        DataCarQueue P_LaneIn_BusStationProgresuluiOut_V_S3 = new DataCarQueue();
        P_LaneIn_BusStationProgresuluiOut_V_S3.Value.Size = 2;
        P_LaneIn_BusStationProgresuluiOut_V_S3.SetName("P_LaneIn_BusStationProgresuluiOut_V_S3");
        pn.PlaceList.add(P_LaneIn_BusStationProgresuluiOut_V_S3);

        DataCarQueue P_LaneIn_TramStationProgresului_V_S3 = new DataCarQueue();
        P_LaneIn_TramStationProgresului_V_S3.Value.Size = 1;
        P_LaneIn_TramStationProgresului_V_S3.SetName("P_LaneIn_TramStationProgresului_V_S3");
        pn.PlaceList.add(P_LaneIn_TramStationProgresului_V_S3);

        DataCarQueue P_LaneIn_TramStationProgresuluiOut_V_S3 = new DataCarQueue();
        P_LaneIn_TramStationProgresuluiOut_V_S3.Value.Size = 1;
        P_LaneIn_TramStationProgresuluiOut_V_S3.SetName("P_LaneIn_TramStationProgresuluiOut_V_S3");
        pn.PlaceList.add(P_LaneIn_TramStationProgresuluiOut_V_S3);

        DataCarQueue P_LaneIn_int3_V_S3 = new DataCarQueue();
        P_LaneIn_int3_V_S3.Value.Size = 3;
        P_LaneIn_int3_V_S3.SetName("P_LaneIn_int3_V_S3");
        pn.PlaceList.add(P_LaneIn_int3_V_S3);

        DataCarQueue P_LaneIn_int4_V_S3 = new DataCarQueue();
        P_LaneIn_int4_V_S3.Value.Size = 3;
        P_LaneIn_int4_V_S3.SetName("P_LaneIn_int4_V_S3");
        pn.PlaceList.add(P_LaneIn_int4_V_S3);

        DataCar P_Lane_BarbatescuVechiOut_V_S2 = new DataCar();
        P_Lane_BarbatescuVechiOut_V_S2.SetName("P_Lane_BarbatescuVechiOut_V_S2");
        pn.PlaceList.add(P_Lane_BarbatescuVechiOut_V_S2);

        DataCar P_Lane_BarbatescuVechiIn_V_S2 = new DataCar();
        P_Lane_BarbatescuVechiIn_V_S2.SetName("P_Lane_BarbatescuVechiIn_V_S2");
        pn.PlaceList.add(P_Lane_BarbatescuVechiIn_V_S2);

        DataCarQueue P_LaneIn_int5_V_S3 = new DataCarQueue();
        P_LaneIn_int5_V_S3.Value.Size = 3;
        P_LaneIn_int5_V_S3.SetName("P_LaneIn_int5_V_S3");
        pn.PlaceList.add(P_LaneIn_int5_V_S3);

        DataCar P_Lane_ParcareAURIn_V_S2 = new DataCar();
        P_Lane_ParcareAURIn_V_S2.SetName("P_Lane_ParcareAURIn_V_S2");
        pn.PlaceList.add(P_Lane_ParcareAURIn_V_S2);

        DataCar P_Lane_ParcareVistierilorOut_V_S2 = new DataCar();
        P_Lane_ParcareVistierilorOut_V_S2.SetName("P_Lane_ParcareVistierilorOut_V_S2");
        pn.PlaceList.add(P_Lane_ParcareVistierilorOut_V_S2);

        DataCarQueue P_LaneIn_TramStationChirigiu_V_S3 = new DataCarQueue();
        P_LaneIn_TramStationChirigiu_V_S3.Value.Size = 3;
        P_LaneIn_TramStationChirigiu_V_S3.SetName("P_LaneIn_TramStationChirigiu_V_S3");
        pn.PlaceList.add(P_LaneIn_TramStationChirigiu_V_S3);

        DataCarQueue P_LaneIn_TramStationChirigiuOut_V_S3 = new DataCarQueue();
        P_LaneIn_TramStationChirigiuOut_V_S3.Value.Size = 3;
        P_LaneIn_TramStationChirigiuOut_V_S3.SetName("P_LaneIn_TramStationChirigiuOut_V_S3");
        pn.PlaceList.add(P_LaneIn_TramStationChirigiuOut_V_S3);

        DataCarQueue P_LaneIn_int6_V_S3 = new DataCarQueue();
        P_LaneIn_int6_V_S3.Value.Size = 3;
        P_LaneIn_int6_V_S3.SetName("P_LaneIn_int6_V_S3");
        pn.PlaceList.add(P_LaneIn_int6_V_S3);

        DataCarQueue P_LaneIn_int7_V_S3 = new DataCarQueue();
        P_LaneIn_int7_V_S3.Value.Size = 3;
        P_LaneIn_int7_V_S3.SetName("P_LaneIn_int7_V_S3");
        pn.PlaceList.add(P_LaneIn_int7_V_S3);

        //-------------------OUT--------------------------
        DataCarQueue P_LaneOut_Int1_V_S3 = new DataCarQueue();
        P_LaneOut_Int1_V_S3.SetName("P_LaneOut_Int1_V_S3");
        P_LaneOut_Int1_V_S3.Value.Size = 3;
        pn.PlaceList.add(P_LaneOut_Int1_V_S3);

        DataCar P_LaneDinca_V_In_S3 = new DataCar();
        P_LaneDinca_V_In_S3.SetName("P_LaneDinca_V_In_S3");
        pn.PlaceList.add(P_LaneDinca_V_In_S3);

        DataCar P_LaneDinca_V_Out_S3 = new DataCar();
        P_LaneDinca_V_Out_S3.SetName("P_LaneDinca_V_Out_S3");
        pn.PlaceList.add(P_LaneDinca_V_Out_S3);

        DataCarQueue P_LaneOut_Int2_V_S3 = new DataCarQueue();
        P_LaneOut_Int2_V_S3.SetName("P_LaneOut_Int2_V_S3");
        P_LaneOut_Int2_V_S3.Value.Size = 3;
        pn.PlaceList.add(P_LaneOut_Int2_V_S3);

        DataCarQueue P_LaneOut_Int3_V_S3 = new DataCarQueue();
        P_LaneOut_Int3_V_S3.SetName("P_LaneOut_Int3_V_S3");
        P_LaneOut_Int3_V_S3.Value.Size = 3;
        pn.PlaceList.add(P_LaneOut_Int3_V_S3);

        DataCar P_LaneRaditei_V_In_S3 = new DataCar();
        P_LaneRaditei_V_In_S3.SetName("P_LaneRaditei_V_In_S3");
        pn.PlaceList.add(P_LaneRaditei_V_In_S3);

        DataCarQueue P_LaneOut_Int4_V_S3 = new DataCarQueue();
        P_LaneOut_Int4_V_S3.SetName("P_LaneOut_Int4_V_S3");
        P_LaneOut_Int4_V_S3.Value.Size = 3;
        pn.PlaceList.add(P_LaneOut_Int4_V_S3);

        DataCar P_LanePopeia_V_Out_S3 = new DataCar();
        P_LanePopeia_V_Out_S3.SetName("P_LanePopeia_V_Out_S3");
        pn.PlaceList.add(P_LanePopeia_V_Out_S3);

        DataCarQueue P_LaneOut_Int5_V_S3 = new DataCarQueue();
        P_LaneOut_Int5_V_S3.SetName("P_LaneOut_Int5_V_S3");
        P_LaneOut_Int5_V_S3.Value.Size = 3;
        pn.PlaceList.add(P_LaneOut_Int5_V_S3);

        DataCarQueue P_BusStation_Chirigiu_V_Out_S3 = new DataCarQueue();
        P_BusStation_Chirigiu_V_Out_S3.SetName("P_BusStation_Chirigiu_V_Out_S3");
        P_BusStation_Chirigiu_V_Out_S3.Value.Size = 2;
        pn.PlaceList.add(P_BusStation_Chirigiu_V_Out_S3);

        DataCarQueue P_BusStation_Chirigiu_V_S3 = new DataCarQueue();
        P_BusStation_Chirigiu_V_S3.SetName("P_BusStation_Chirigiu_V_S3");
        P_BusStation_Chirigiu_V_S3.Value.Size = 2;
        pn.PlaceList.add(P_BusStation_Chirigiu_V_S3);

        DataCarQueue P_LaneOut_Int6_V_S3 = new DataCarQueue();
        P_LaneOut_Int6_V_S3.Value.Size = 3;
        P_LaneOut_Int6_V_S3.SetName("P_LaneOut_Int6_V_S3");
        pn.PlaceList.add(P_LaneOut_Int6_V_S3);

        DataCarQueue P_LaneParcare_V_Out_S3 = new DataCarQueue();
        P_LaneParcare_V_Out_S3.SetName("P_LaneParcare_V_Out_S3");
        P_LaneOut_Int6_V_S3.Value.Size = 3;
        pn.PlaceList.add(P_LaneParcare_V_Out_S3);

        DataCarQueue P_LaneOut_Int7_V_S3 = new DataCarQueue();
        P_LaneOut_Int7_V_S3.SetName("P_LaneOut_Int7_V_S3");
        P_LaneOut_Int7_V_S3.Value.Size = 3;
        pn.PlaceList.add(P_LaneOut_Int7_V_S3);

        DataCar P_LaneAnul1821_V_Out_S3 = new DataCar();
        P_LaneAnul1821_V_Out_S3.SetName("P_LaneAnul1821_V_Out_S3");
        pn.PlaceList.add(P_LaneAnul1821_V_Out_S3);

        DataCarQueue P_LaneOut_Int8_V_S3 = new DataCarQueue();
        P_LaneOut_Int8_V_S3.SetName("P_LaneOut_Int8_V_S3");
        P_LaneOut_Int8_V_S3.Value.Size = 2;
        pn.PlaceList.add(P_LaneOut_Int8_V_S3);

        DataCar P_LaneOut_Int9_V_S3 = new DataCar();
        P_LaneOut_Int9_V_S3.SetName("P_LaneOut_Int9_V_S3");
        pn.PlaceList.add(P_LaneOut_Int9_V_S3);

        DataCarQueue P_LaneOut_TramStationChirigiu_V_S3 = new DataCarQueue();
        P_LaneOut_TramStationChirigiu_V_S3.SetName("P_LaneOut_TramStationChirigiu_V_S3");
        P_LaneOut_TramStationChirigiu_V_S3.Value.Size = 1;
        pn.PlaceList.add(P_LaneOut_TramStationChirigiu_V_S3);

        DataCarQueue P_LaneOut_TramStationChirigiuOut_V_S3 = new DataCarQueue();
        P_LaneOut_TramStationChirigiuOut_V_S3.SetName("P_LaneOut_TramStationChirigiuOut_V_S3");
        P_LaneOut_TramStationChirigiuOut_V_S3.Value.Size = 1;
        pn.PlaceList.add(P_LaneOut_TramStationChirigiuOut_V_S3);

        // -------------------------------------------------------------------
        // ----------------END CALEA FERENTARI SECTION 3----------------------
        // -------------------------------------------------------------------


        System.out.println("Lanes_Intersection_Bucharest started \n ------------------------------");
        pn.Delay = 2000;
        // pn.Start();

        PetriNetWindow frame = new PetriNetWindow(false);
        frame.petriNet = pn;
        frame.setVisible(true);

        //test commit
    }
}
