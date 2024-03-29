// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package mingh.research.model;

import java.util.List;
import mingh.research.model.TSNCJobIRProperty;
import mingh.research.model.TSNCJobIRPropertyDataOnDemand;
import mingh.research.model.TSNCJobIRPropertyIntegrationTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

privileged aspect TSNCJobIRPropertyIntegrationTest_Roo_IntegrationTest {
    
    declare @type: TSNCJobIRPropertyIntegrationTest: @RunWith(SpringJUnit4ClassRunner.class);
    
    declare @type: TSNCJobIRPropertyIntegrationTest: @ContextConfiguration(locations = "classpath:/META-INF/spring/applicationContext*.xml");
    
    declare @type: TSNCJobIRPropertyIntegrationTest: @Transactional;
    
    @Autowired
    TSNCJobIRPropertyDataOnDemand TSNCJobIRPropertyIntegrationTest.dod;
    
    @Test
    public void TSNCJobIRPropertyIntegrationTest.testCountTSNCJobIRPropertys() {
        Assert.assertNotNull("Data on demand for 'TSNCJobIRProperty' failed to initialize correctly", dod.getRandomTSNCJobIRProperty());
        long count = TSNCJobIRProperty.countTSNCJobIRPropertys();
        Assert.assertTrue("Counter for 'TSNCJobIRProperty' incorrectly reported there were no entries", count > 0);
    }
    
    @Test
    public void TSNCJobIRPropertyIntegrationTest.testFindTSNCJobIRProperty() {
        TSNCJobIRProperty obj = dod.getRandomTSNCJobIRProperty();
        Assert.assertNotNull("Data on demand for 'TSNCJobIRProperty' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'TSNCJobIRProperty' failed to provide an identifier", id);
        obj = TSNCJobIRProperty.findTSNCJobIRProperty(id);
        Assert.assertNotNull("Find method for 'TSNCJobIRProperty' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'TSNCJobIRProperty' returned the incorrect identifier", id, obj.getId());
    }
    
    @Test
    public void TSNCJobIRPropertyIntegrationTest.testFindAllTSNCJobIRPropertys() {
        Assert.assertNotNull("Data on demand for 'TSNCJobIRProperty' failed to initialize correctly", dod.getRandomTSNCJobIRProperty());
        long count = TSNCJobIRProperty.countTSNCJobIRPropertys();
        Assert.assertTrue("Too expensive to perform a find all test for 'TSNCJobIRProperty', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<TSNCJobIRProperty> result = TSNCJobIRProperty.findAllTSNCJobIRPropertys();
        Assert.assertNotNull("Find all method for 'TSNCJobIRProperty' illegally returned null", result);
        Assert.assertTrue("Find all method for 'TSNCJobIRProperty' failed to return any data", result.size() > 0);
    }
    
    @Test
    public void TSNCJobIRPropertyIntegrationTest.testFindTSNCJobIRPropertyEntries() {
        Assert.assertNotNull("Data on demand for 'TSNCJobIRProperty' failed to initialize correctly", dod.getRandomTSNCJobIRProperty());
        long count = TSNCJobIRProperty.countTSNCJobIRPropertys();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<TSNCJobIRProperty> result = TSNCJobIRProperty.findTSNCJobIRPropertyEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'TSNCJobIRProperty' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'TSNCJobIRProperty' returned an incorrect number of entries", count, result.size());
    }
    
    @Test
    public void TSNCJobIRPropertyIntegrationTest.testFlush() {
        TSNCJobIRProperty obj = dod.getRandomTSNCJobIRProperty();
        Assert.assertNotNull("Data on demand for 'TSNCJobIRProperty' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'TSNCJobIRProperty' failed to provide an identifier", id);
        obj = TSNCJobIRProperty.findTSNCJobIRProperty(id);
        Assert.assertNotNull("Find method for 'TSNCJobIRProperty' illegally returned null for id '" + id + "'", obj);
        boolean modified =  dod.modifyTSNCJobIRProperty(obj);
        Integer currentVersion = obj.getVersion();
        obj.flush();
        Assert.assertTrue("Version for 'TSNCJobIRProperty' failed to increment on flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }
    
    @Test
    public void TSNCJobIRPropertyIntegrationTest.testMergeUpdate() {
        TSNCJobIRProperty obj = dod.getRandomTSNCJobIRProperty();
        Assert.assertNotNull("Data on demand for 'TSNCJobIRProperty' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'TSNCJobIRProperty' failed to provide an identifier", id);
        obj = TSNCJobIRProperty.findTSNCJobIRProperty(id);
        boolean modified =  dod.modifyTSNCJobIRProperty(obj);
        Integer currentVersion = obj.getVersion();
        TSNCJobIRProperty merged = (TSNCJobIRProperty)obj.merge();
        obj.flush();
        Assert.assertEquals("Identifier of merged object not the same as identifier of original object", merged.getId(), id);
        Assert.assertTrue("Version for 'TSNCJobIRProperty' failed to increment on merge and flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }
    
    @Test
    public void TSNCJobIRPropertyIntegrationTest.testPersist() {
        Assert.assertNotNull("Data on demand for 'TSNCJobIRProperty' failed to initialize correctly", dod.getRandomTSNCJobIRProperty());
        TSNCJobIRProperty obj = dod.getNewTransientTSNCJobIRProperty(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'TSNCJobIRProperty' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'TSNCJobIRProperty' identifier to be null", obj.getId());
        obj.persist();
        obj.flush();
        Assert.assertNotNull("Expected 'TSNCJobIRProperty' identifier to no longer be null", obj.getId());
    }
    
    @Test
    public void TSNCJobIRPropertyIntegrationTest.testRemove() {
        TSNCJobIRProperty obj = dod.getRandomTSNCJobIRProperty();
        Assert.assertNotNull("Data on demand for 'TSNCJobIRProperty' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'TSNCJobIRProperty' failed to provide an identifier", id);
        obj = TSNCJobIRProperty.findTSNCJobIRProperty(id);
        obj.remove();
        obj.flush();
        Assert.assertNull("Failed to remove 'TSNCJobIRProperty' with identifier '" + id + "'", TSNCJobIRProperty.findTSNCJobIRProperty(id));
    }
    
}
