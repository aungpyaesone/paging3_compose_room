package com.aps.room_test.event;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\b\u0002\u0003\u0004\u0005\u0006\u0007\b\t\u0082\u0001\b\n\u000b\f\r\u000e\u000f\u0010\u0011\u00a8\u0006\u0012"}, d2 = {"Lcom/aps/room_test/event/ContactEvent;", "", "DeleteContacts", "HideDialog", "SaveContact", "SetFirstName", "SetLPhoneNumber", "SetLastName", "ShowDialog", "SortContacts", "Lcom/aps/room_test/event/ContactEvent$DeleteContacts;", "Lcom/aps/room_test/event/ContactEvent$HideDialog;", "Lcom/aps/room_test/event/ContactEvent$SaveContact;", "Lcom/aps/room_test/event/ContactEvent$SetFirstName;", "Lcom/aps/room_test/event/ContactEvent$SetLPhoneNumber;", "Lcom/aps/room_test/event/ContactEvent$SetLastName;", "Lcom/aps/room_test/event/ContactEvent$ShowDialog;", "Lcom/aps/room_test/event/ContactEvent$SortContacts;", "room_test_debug"})
public abstract interface ContactEvent {
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/aps/room_test/event/ContactEvent$SaveContact;", "Lcom/aps/room_test/event/ContactEvent;", "()V", "room_test_debug"})
    public static final class SaveContact implements com.aps.room_test.event.ContactEvent {
        @org.jetbrains.annotations.NotNull()
        public static final com.aps.room_test.event.ContactEvent.SaveContact INSTANCE = null;
        
        private SaveContact() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/aps/room_test/event/ContactEvent$SetFirstName;", "Lcom/aps/room_test/event/ContactEvent;", "firstName", "", "(Ljava/lang/String;)V", "getFirstName", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "room_test_debug"})
    public static final class SetFirstName implements com.aps.room_test.event.ContactEvent {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String firstName = null;
        
        @org.jetbrains.annotations.NotNull()
        public final com.aps.room_test.event.ContactEvent.SetFirstName copy(@org.jetbrains.annotations.NotNull()
        java.lang.String firstName) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public java.lang.String toString() {
            return null;
        }
        
        public SetFirstName(@org.jetbrains.annotations.NotNull()
        java.lang.String firstName) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getFirstName() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/aps/room_test/event/ContactEvent$SetLastName;", "Lcom/aps/room_test/event/ContactEvent;", "lastName", "", "(Ljava/lang/String;)V", "getLastName", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "room_test_debug"})
    public static final class SetLastName implements com.aps.room_test.event.ContactEvent {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String lastName = null;
        
        @org.jetbrains.annotations.NotNull()
        public final com.aps.room_test.event.ContactEvent.SetLastName copy(@org.jetbrains.annotations.NotNull()
        java.lang.String lastName) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public java.lang.String toString() {
            return null;
        }
        
        public SetLastName(@org.jetbrains.annotations.NotNull()
        java.lang.String lastName) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getLastName() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/aps/room_test/event/ContactEvent$SetLPhoneNumber;", "Lcom/aps/room_test/event/ContactEvent;", "phoneNumber", "", "(Ljava/lang/String;)V", "getPhoneNumber", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "room_test_debug"})
    public static final class SetLPhoneNumber implements com.aps.room_test.event.ContactEvent {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String phoneNumber = null;
        
        @org.jetbrains.annotations.NotNull()
        public final com.aps.room_test.event.ContactEvent.SetLPhoneNumber copy(@org.jetbrains.annotations.NotNull()
        java.lang.String phoneNumber) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public java.lang.String toString() {
            return null;
        }
        
        public SetLPhoneNumber(@org.jetbrains.annotations.NotNull()
        java.lang.String phoneNumber) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getPhoneNumber() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/aps/room_test/event/ContactEvent$HideDialog;", "Lcom/aps/room_test/event/ContactEvent;", "()V", "room_test_debug"})
    public static final class HideDialog implements com.aps.room_test.event.ContactEvent {
        @org.jetbrains.annotations.NotNull()
        public static final com.aps.room_test.event.ContactEvent.HideDialog INSTANCE = null;
        
        private HideDialog() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/aps/room_test/event/ContactEvent$ShowDialog;", "Lcom/aps/room_test/event/ContactEvent;", "()V", "room_test_debug"})
    public static final class ShowDialog implements com.aps.room_test.event.ContactEvent {
        @org.jetbrains.annotations.NotNull()
        public static final com.aps.room_test.event.ContactEvent.ShowDialog INSTANCE = null;
        
        private ShowDialog() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/aps/room_test/event/ContactEvent$SortContacts;", "Lcom/aps/room_test/event/ContactEvent;", "sortType", "Lcom/aps/room_test/event/SortType;", "(Lcom/aps/room_test/event/SortType;)V", "getSortType", "()Lcom/aps/room_test/event/SortType;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "room_test_debug"})
    public static final class SortContacts implements com.aps.room_test.event.ContactEvent {
        @org.jetbrains.annotations.NotNull()
        private final com.aps.room_test.event.SortType sortType = null;
        
        @org.jetbrains.annotations.NotNull()
        public final com.aps.room_test.event.ContactEvent.SortContacts copy(@org.jetbrains.annotations.NotNull()
        com.aps.room_test.event.SortType sortType) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public java.lang.String toString() {
            return null;
        }
        
        public SortContacts(@org.jetbrains.annotations.NotNull()
        com.aps.room_test.event.SortType sortType) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.aps.room_test.event.SortType component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.aps.room_test.event.SortType getSortType() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/aps/room_test/event/ContactEvent$DeleteContacts;", "Lcom/aps/room_test/event/ContactEvent;", "contact", "Lcom/aps/room_test/data/local/Contact;", "(Lcom/aps/room_test/data/local/Contact;)V", "getContact", "()Lcom/aps/room_test/data/local/Contact;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "room_test_debug"})
    public static final class DeleteContacts implements com.aps.room_test.event.ContactEvent {
        @org.jetbrains.annotations.NotNull()
        private final com.aps.room_test.data.local.Contact contact = null;
        
        @org.jetbrains.annotations.NotNull()
        public final com.aps.room_test.event.ContactEvent.DeleteContacts copy(@org.jetbrains.annotations.NotNull()
        com.aps.room_test.data.local.Contact contact) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public java.lang.String toString() {
            return null;
        }
        
        public DeleteContacts(@org.jetbrains.annotations.NotNull()
        com.aps.room_test.data.local.Contact contact) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.aps.room_test.data.local.Contact component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.aps.room_test.data.local.Contact getContact() {
            return null;
        }
    }
}