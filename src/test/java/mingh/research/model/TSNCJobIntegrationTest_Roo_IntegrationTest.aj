// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package mingh.research.model;

import java.util.List;
import mingh.research.model.TSNCJob;
import mingh.research.model.TSNCJobDataOnDemand;
import mingh.research.model.TSNCJobIntegrationTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

privileged aspect TSNCJobIntegrationTest_Roo_IntegrationTest {
    
    declare @type: TSNCJobIntegrationTest: @RunWith(SpringJUnit4ClassRunner.class);
    
    declare @type: TSNCJobIntegrationTest: @ContextConfiguration(locations = "classpath:/META-INF/spring/applicationContext*.xml");
    
    declare @type: TSNCJobIntegrationTest: @Transactional;
    
    @Autowired
    TSNCJobDataOnDemand TSNCJobIntegrationTest.dod;
    
    @Test
    public void TSNCJobIntegrationTest.testCountTSNCJobs() {
        Assert.assertNotNull("Data on demand for 'TSNCJob' failed to initialize correctly", dod.getRandomTSNCJob());
        long count = TSNCJob.countTSNCJobs();
        Assert.assertTrue("Counter for 'TSNCJob' incorrectly reported there were no entries", count > 0);
    }
    
    @Test
    public void TSNCJobIntegrationTest.testFindTSNCJob() {
        TSNCJob obj = dod.getRandomTSNCJob();
        Assert.assertNotNull("Data on demand for 'TSNCJob' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'TSNCJob' failed to provide an identifier", id);
        obj = TSNCJob.findTSNCJob(id);
        Assert.assertNotNull("Find method for 'TSNCJob' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'TSNCJob' returned the incorrect identifier", id, obj.getId());
    }
    
    @Test
    public void TSNCJobIntegrationTest.testFindAllTSNCJobs() {
        Assert.assertNotNull("Data on demand for 'TSNCJob' failed to initialize correctly", dod.getRandomTSNCJob());
        long count = TSNCJob.countTSNCJobs();
        Assert.assertTrue("Too expensive to perform a find all test for 'TSNCJob', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<TSNCJob> result = TSNCJob.findAllTSNCJobs();
        Assert.assertNotNull("Find all method for 'TSNCJob' illegally returned null", result);
        Assert.assertTrue("Find all method for 'TSNCJob' failed to return any data", result.size() > 0);
    }
    
    @Test
    public void TSNCJobIntegrationTest.testFindTSNCJobEntries() {
        Assert.assertNotNull("Data on demand for 'TSNCJob' failed to initialize correctly", dod.getRandomTSNCJob());
        long count = TSNCJob.countTSNCJobs();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<TSNCJob> result = TSNCJob.findTSNCJobEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'TSNCJob' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'TSNCJob' returned an incorrect number of entries", count, result.size());
    }
    
    @Test
    public void TSNCJobIntegrationTest.testFlush() {
        TSNCJob obj = dod.getRandomTSNCJob();
        Assert.assertNotNull("Data on demand for 'TSNCJob' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'TSNCJob' failed to provide an identifier", id);
        obj = TSNCJob.findTSNCJob(id);
        Assert.assertNotNull("Find method for 'TSNCJob' illegally returned null for id '" + id + "'", obj);
        boolean modified =  dod.modifyTSNCJob(obj);
        Integer currentVersion = obj.getVersion();
        obj.flush();
        Assert.assertTrue("Version for 'TSNCJob' failed to increment on flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }
    
    @Test
    public void TSNCJobIntegrationTest.testMergeUpdate() {
        TSNCJob obj = dod.getRandomTSNCJob();
        Assert.assertNotNull("Data on demand for 'TSNCJob' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'TSNCJob' failed to provide an identifier", id);
        obj = TSNCJob.findTSNCJob(id);
        boolean modified =  dod.modifyTSNCJob(obj);
        Integer currentVersion = obj.getVersion();
        TSNCJob merged = (TSNCJob)obj.merge();
        obj.flush();
        Assert.assertEquals("Identifier of merged object not the same as identifier of original object", merged.getId(), id);
        Assert.assertTrue("Version for 'TSNCJob' failed to increment on merge and flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }
    
    @Test
    public void TSNCJobIntegrationTest.testPersist() {
        Assert.assertNotNull("Data on demand for 'TSNCJob' failed to initialize correctly", dod.getRandomTSNCJob());
        TSNCJob obj = dod.getNewTransientTSNCJob(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'TSNCJob' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'TSNCJob' identifier to be null", obj.getId());
        obj.persist();
        obj.flush();
        Assert.assertNotNull("Expected 'TSNCJob' identifier to no longer be null", obj.getId());
    }
    
    @Test
    public void TSNCJobIntegrationTest.testRemove() {
        TSNCJob obj = dod.getRandomTSNCJob();
        Assert.assertNotNull("Data on demand for 'TSNCJob' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'TSNCJob' failed to provide an identifier", id);
        obj = TSNCJob.findTSNCJob(id);
        obj.remove();
        obj.flush();
        Assert.assertNull("Failed to remove 'TSNCJob' with identifier '" + id + "'", TSNCJob.findTSNCJob(id));
    }
    
}
