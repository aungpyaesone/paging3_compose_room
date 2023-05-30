package com.aps.room_test.data.local;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bH\'J\u0014\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bH\'J\u0014\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bH\'J\u0019\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Lcom/aps/room_test/data/local/ContactDao;", "", "deleteContact", "", "contact", "Lcom/aps/room_test/data/local/Contact;", "(Lcom/aps/room_test/data/local/Contact;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getContactOrderByFirstName", "Lkotlinx/coroutines/flow/Flow;", "", "getContactOrderByLastName", "getContactOrderByPhoneNumber", "upsertContact", "room_test_debug"})
public abstract interface ContactDao {
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Upsert()
    public abstract java.lang.Object upsertContact(@org.jetbrains.annotations.NotNull()
    com.aps.room_test.data.local.Contact contact, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Delete()
    public abstract java.lang.Object deleteContact(@org.jetbrains.annotations.NotNull()
    com.aps.room_test.data.local.Contact contact, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "select * from contact order by firstName ASC")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.aps.room_test.data.local.Contact>> getContactOrderByFirstName();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "select * from contact order by lastName ASC")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.aps.room_test.data.local.Contact>> getContactOrderByLastName();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "select * from contact order by phoneNumber ASC")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.aps.room_test.data.local.Contact>> getContactOrderByPhoneNumber();
}